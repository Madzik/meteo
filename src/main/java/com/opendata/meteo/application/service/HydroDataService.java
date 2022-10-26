package com.opendata.meteo.application.service;

import com.opendata.meteo.application.model.HydroData;
import com.opendata.meteo.document.application.service.ExcelDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HydroDataService {

    private final ExcelDocumentService excelDocumentService;
    private final RestTemplate restTemplate;


    public Mono<ResponseEntity<List<HydroData>>> getHydroData() {

        WebClient webClient = WebClient.builder()
                .baseUrl("https://danepubliczne.imgw.pl/api/data")
                .build();

        ClientResponse response = webClient.get()
                .uri("/hydro")
                .exchange()
                .block();

        return response.toEntityList(HydroData.class);
    }

    public Mono<List<Map<String, String>>> getHydroData3() {

        WebClient webClient = WebClient.builder()
                .baseUrl("https://danepubliczne.imgw.pl/api/data")
                .build();

        ClientResponse response = webClient.get()
                .uri("/hydro")
                .exchange()
                .block();

         return response.bodyToMono(new ParameterizedTypeReference<List<Map<String, String>>>() {});
    }

    public ResponseEntity<List> getDataAsList() {
         return restTemplate.getForEntity("https://danepubliczne.imgw.pl/api/data/hydro", List.class);
    }

    public ResponseEntity<String> getDataAsString() {
        return restTemplate.
                getForEntity("https://danepubliczne.imgw.pl/api/data/hydro", String.class);
    }

    public List<Map<String, Object>> transferData() {
        ResponseEntity<String> stringResponseEntity = getDataAsString();
        return excelDocumentService.createDocumentUsingJsonArray(stringResponseEntity.getBody());
    }
}
