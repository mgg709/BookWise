package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

import com.example.backend.model.Book;


@Configuration
public class ConfigurationBeans extends ElasticsearchConfiguration{

    @Override
    public ClientConfiguration clientConfiguration(){
        return ClientConfiguration.builder()
            .connectedTo("localhost:9200")
            .build();
    }
    
    @Bean
    public Book book() {
        return new Book();
    }
}
