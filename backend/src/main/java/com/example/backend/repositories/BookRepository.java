package com.example.backend.Repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.backend.Model.Book;


public interface BookRepository extends ElasticsearchRepository<Book, String> {
    public List<Book> findAll();
}
