package com.opendata.meteo.application.model;

import java.time.LocalDate;

public class Document {
    private String title;
    private String format;
    private byte [] content;

    private LocalDate createdAt;

    private String createdBy;
}
