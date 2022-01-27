package com.opendata.meteo.document.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opendata.meteo.document.application.model.Document;
import com.opendata.meteo.document.application.model.DocumentFormat;
import com.opendata.meteo.document.application.model.DocumentService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExcelDocumentService implements DocumentService {

    @Override
    public DocumentFormat getDocumentFormat() {
        return DocumentFormat.EXCEL;
    }

    @Override
    public Document createDocument(String json) {
        List<String> columns = new ArrayList<>();
        List<Map<String, Object>> values = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);

        JSONObject jsonObject = jsonArray.getJSONObject(0);
        columns.addAll(jsonObject.keySet());

        jsonArray.toList().stream()
                .map(JSONObject::new)
                .forEach(obj -> values.add(obj.toMap())
                );

        return new Document();
    }

    public List<Map<String, String>>  createDocumentIntoList(String json, String c) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, List.class);
    }

    public List<Map<String, Object>> createDocumentUsingJsonArray(String json) {
        JSONArray jsonArray = new JSONArray(json);
        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            list.add(jsonObject.toMap());
        }
        return list;
    }
}

