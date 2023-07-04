package com.example.backend.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.backend.model.Book;



public interface BookRepository extends ElasticsearchRepository<Book, Integer>{
    List<Book> findByTitle(String title);
    public List<Book> findAll();
}
