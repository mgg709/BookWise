package com.example.backend.controller;

import java.io.IOException;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Book;
import com.example.backend.service.BookService;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping
    public void saveBooks() throws IOException {
        bookService.indexBooks();
    }


    
    @GetMapping("/getTitle/{title}")
    public List<Book> findByTitle(@PathVariable final String title){
        return bookService.findByTitle(title);
    }



    @GetMapping("/all")
    public List<Book> findAll(){
        return bookService.findAll();
    }


    //TODO: Remove this in the future
    @GetMapping("{word}")
    public List<Book> findByWord (@PathVariable String word) {

        List<Book> books =  this.bookService.findByString(word);
        return books;
    }



    /**
     * Run indexing when dependency injection finish
     * @throws IOException
     */
    @PostConstruct
    public void indexStarting() {
        try {
            bookService.indexBooks();
        }
        catch (Exception ex) {
            System.out.println("Indexing failed");
        }
    }

    @GetMapping("/category/{title}")
    public List<Book> findByCategory(@PathVariable final String title){
        List<Book> books = this.findByTitle(title);
        return bookService.findByCategory(books.get(0).getCategory());
    }

    @GetMapping("getTwentyBooks/{page}")
    public PageImpl<Book> getTwentyBooks(@PathVariable final int page){
        return bookService.getTwentyBooks(page);
    }

    @GetMapping("getTenBestRated")
    public ResponseEntity<List<Book>> getTenBestRated(){
        return bookService.get10BestRated();
    }
}
