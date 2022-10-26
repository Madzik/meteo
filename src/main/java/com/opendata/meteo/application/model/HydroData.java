package com.opendata.meteo.application.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@JsonInclude()
public class HydroData {

    @Setter(onMethod_ = {@JsonSetter(value = "id_stacji")})
    @Getter(onMethod_ = {@JsonGetter(value = "idStacji")})
    private String idStacji;

    @JsonProperty("stacja")
    private String stacja;

    @JsonProperty("rzeka")
    private String rzeka;

    @JsonProperty("województwo")
    private String wojewodztwo;

    @Setter(onMethod_ = {@JsonSetter(value = "stan_wody")})
    @Getter(onMethod_ = {@JsonGetter(value = "stanWody")})
    private int stanWody;

    @Setter(onMethod_ = {@JsonSetter(value = "stan_wody_data_pomiaru")})
    @Getter(onMethod_ = {@JsonGetter(value = "stanWodyDataPomiaru")})
    private String stanWodyDataPomiaru;

    @Setter(onMethod_ = {@JsonSetter(value = "temperatura_wody")})
    @Getter(onMethod_ = {@JsonGetter(value = "temperaturaWody")})
    private double temperaturaWody;

    @Setter(onMethod_ = {@JsonSetter(value = "temperatura_wody_data_pomiaru")})
    @Getter(onMethod_ = {@JsonGetter(value = "temperaturaWodyDataPomiaru")})
    private String temperaturaWodyDataPomiaru;

    @Setter(onMethod_ = {@JsonSetter(value = "zjawisko_lodowe")})
    @Getter(onMethod_ = {@JsonGetter(value = "zjawiskoLodowe")})
    private int zjawiskoLodowe;

    @Setter(onMethod_ = {@JsonSetter(value = "zjawisko_lodowe_data_pomiaru")})
    @Getter(onMethod_ = {@JsonGetter(value = "zjawiskoLodoweDataPomiaru")})
    private String zjawiskoLodoweDataPomiaru;

    @Setter(onMethod_ = {@JsonSetter(value = "zjawisko_zarastania")})
    @Getter(onMethod_ = {@JsonGetter(value = "zjawiskoZarastania")})
    private int zjawiskoZarastania;

    @Setter(onMethod_ = {@JsonSetter(value = "zjawisko_zarastania_data_pomiaru")})
    @Getter(onMethod_ = {@JsonGetter(value = "zjawiskoZarastaniaDataPomiaru")})
    private String zjawiskoZarastaniaDataPomiaru;
}
