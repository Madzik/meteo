package com.opendata.meteo.infrastructure.data.sync;

import com.opendata.meteo.application.model.HydroData;

import java.util.List;

public interface DataSync {

    void syncData(HydroData hydroData);
    void syncData(List<HydroData> hydroData);
}
