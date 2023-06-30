package com.example.backend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

import com.example.backend.model.Book;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.backend.repositories")
@ComponentScan(basePackages = { "com.example.backend" })
public class ConfigurationBeans extends ElasticsearchConfiguration{

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedToLocalhost()
                .build();
    }
}
