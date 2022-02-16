package com.opendata.meteo.document.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CsvFileService {

    public byte [] writeJsonAsBytes(String json) throws IOException {
        JsonNode jsonObject = new ObjectMapper().readTree(json);

        CsvSchema.Builder builder = CsvSchema.builder();

        JsonNode firstObject = jsonObject.elements().next();
        firstObject.fieldNames().forEachRemaining(builder::addColumn);

        CsvSchema csvSchema = builder.build().withHeader();

        CsvMapper csvMapper = new CsvMapper();
        return csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValueAsBytes(jsonObject);
    }

}
