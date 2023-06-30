package com.example.backend.Repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.Repository;
import com.example.backend.model.Book;


@org.springframework.stereotype.Repository
public interface BookRepository extends ElasticsearchRepository<Book, Integer>{
    List<Book> findByTitle(String title);
    public List<Book> findAll();
}
