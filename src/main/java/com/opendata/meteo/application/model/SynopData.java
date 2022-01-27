package com.opendata.meteo.application.model;

import lombok.Getter;

import java.time.LocalDate;


@Getter
public class SynopData {

    private Integer id;
    private String stacja;
    private LocalDate dataPomiaru;
    private Integer godzinaPomiaru;
    private Double temperatura;
    private Integer predkoscWiatru;
    private Integer kierunekWiatru;
    private Double wilgotnoscWzledna;
    private Double sumaOpadu;
    private Double cisnienie;
}
