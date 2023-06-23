package com.example.backend.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;
import com.example.backend.model.Book;


public interface BookRepository extends Repository<Book, Long>{
    List<Book> findByTitle(String title);
}
