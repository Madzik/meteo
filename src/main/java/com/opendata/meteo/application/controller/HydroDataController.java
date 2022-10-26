package com.opendata.meteo.application.controller;

import com.opendata.meteo.application.model.HydroData;
import com.opendata.meteo.application.service.HydroDataService;
import com.opendata.meteo.document.application.service.CsvFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/data/")
@RequiredArgsConstructor
public class HydroDataController {


    private final HydroDataService hydroDataService;
    private final CsvFileService csvFileService;

    @GetMapping("/hydro")
    public ResponseEntity<List<HydroData>> getHydroData() {
        return hydroDataService.getHydroData().block();
    }

    @GetMapping("/data/transfer")
    public ResponseEntity<List<Map<String, Object>>> transferData() {
        return ResponseEntity.of(Optional.of(hydroDataService.transferData()));
    }

    @GetMapping(value = "/file", produces = "application/csv")
    public ResponseEntity<byte []> saveFile() throws IOException {
        byte[] bytes = csvFileService.writeJsonAsBytes(hydroDataService.getDataAsString().getBody());
        return new ResponseEntity(bytes, HttpStatus.OK);
    }
}


