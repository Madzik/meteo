package com.opendata.meteo.application.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class HydroData {

    private String idStacji;
    private String stacja;
    private String rzeka;
    private String wojewodztwo;
    private int stanWody;
    private LocalDate stanWodyDataPomiaru;
    private double temperaturaWody;
    private LocalDate temperaturaWodyDataPomiaru;
    private int zjawiskoLodowe;
    private LocalDate zjawiskoLodoweDataPomiaru;
    private int zjawiskoZarastania;
    private LocalDate zjawiskoZarastaniaDataPomiaru;
}
