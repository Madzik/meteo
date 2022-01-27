package com.opendata.meteo.application.controller;

import com.opendata.meteo.application.model.HydroData;
import com.opendata.meteo.application.service.HydroDataService;
import com.opendata.meteo.document.application.service.ExcelDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("data/")
@RequiredArgsConstructor
public class HydroDataController {


    private final HydroDataService hydroDataService;
    private final ExcelDocumentService excelDocumentService;

    @GetMapping("/hydro")
    public Mono<ResponseEntity<List<HydroData>>> getHydroData() {

        return hydroDataService.getHydroData();
    }

    @GetMapping("/hydro2")
    public ResponseEntity<String> getHydroData2() {
        return hydroDataService.getDataAsString();
    }

    @GetMapping("/data/transfer")
    public ResponseEntity<List<Map<String, Object>>> transferData() {
        return ResponseEntity.of(Optional.of(hydroDataService.transferData()));
    }
}


