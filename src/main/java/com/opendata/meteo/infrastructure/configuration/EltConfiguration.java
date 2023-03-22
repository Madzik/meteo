package com.opendata.meteo.infrastructure.configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EltConfiguration {

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200))
                .setDefaultHeaders(new Header[] {
                        new BasicHeader("Content-type", "application/json")
                })
                .build();

        JacksonJsonpMapper jsonMapper = new JacksonJsonpMapper();

        ElasticsearchTransport elasticsearchTransport = new RestClientTransport(restClient, jsonMapper);

        return new ElasticsearchClient(elasticsearchTransport);
    }

}
