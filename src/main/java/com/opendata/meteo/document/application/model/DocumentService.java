package com.opendata.meteo.document.application.model;

public interface DocumentService {

    DocumentFormat getDocumentFormat();
    Document createDocument(String json);
}
