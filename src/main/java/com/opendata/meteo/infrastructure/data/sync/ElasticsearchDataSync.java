package com.opendata.meteo.infrastructure.data.sync;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.opendata.meteo.application.model.HydroData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class ElasticsearchDataSync implements DataSync {

    private final ElasticsearchClient elasticsearchClient;

    @Override
    public void syncData(HydroData hydroData) {

        try {
            elasticsearchClient
                    .create(create ->
                            create.index("meteo-data-1")
                                    .id(UUID.randomUUID().toString())
                                    .document(hydroData));

            log.info(String.format("Syncing data for station id %s", hydroData.getIdStacji()));
        } catch (Exception exc) {
            log.info(exc.getMessage());
        }
    }

    @Override
    public void syncData(List<HydroData> hydroData) {
        hydroData.forEach(this::syncData);
    }
}
