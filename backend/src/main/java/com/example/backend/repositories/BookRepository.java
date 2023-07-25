package com.example.backend.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.backend.model.Book;



public interface BookRepository extends ElasticsearchRepository<Book, Integer>{

    public List<Book> findAll();

    public Book findByTitle(String title);

    public List<Book> findByCategory(String Category);

    @Query("{\"multi_match\" : {\"query\":\"?0\",\"fields\": [ \"title\", \"category\", \"description\" ] } }")
    public List<Book> findByString (String string);

    //TODO: Review this
    @Query("{\"bool\": {\"should\": [" +
            "{\"match\": {\"title\": \"Light\"}}," +
            "{\"match\": {\"category\": \"Poetry\"}}" +
            "]}}")
    public List<Book> advanced(String tittle, String category, String description);

}
