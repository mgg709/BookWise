package com.example.backend.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.Range;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backend.model.Book;
import com.example.backend.repositories.BookRepository;

import javax.annotation.PostConstruct;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;



    // Dealing with elasticsearch
    //***********************************************************************

    /**
     * Read the csv to create the books.
     * @return List of books
     * @throws IOException Fail while reading dataset file.
     */
    public List<Book> createAndGetBooks() throws IOException {
            BufferedReader br = null;
            List<Book> books = new ArrayList<Book>();

            try {

                br = new BufferedReader(
                        new InputStreamReader(new ClassPathResource("dataset.csv").getInputStream()));

                //Skip the first line, so we don't read the labels.
                String line = br.readLine();

                line = br.readLine();
                // int index = 0;
                while (null != line) {

                    String[] libro = line.split(";");
                    if(libro.length!=19) {
                        int aux = libro.length - 19;
                        for(int i=1; i<=aux; i++){
                            libro[8] += libro[8+aux];
                        }
                        List<String> array = new ArrayList<String>();
                        array.add(libro[8+aux+8].toString());
                        array.add(libro[8+aux+9].toString());
                        array.add(libro[8+aux+10].toString());
                        Book book = new Book(Integer.parseInt(libro[0]),libro[1],libro[2],Double.parseDouble(libro[3]),Integer.parseInt(libro[6]),Integer.parseInt(libro[7]),libro[8],libro[8+aux+1], Range.just(Integer.parseInt(libro[8+aux+2])),Integer.parseInt(libro[8+aux+3]),libro[8+aux+4],libro[8+aux+5],Integer.parseInt(libro[8+aux+6]),Integer.parseInt(libro[8+aux+7]), array);
                        books.add(book);
                    }else{
                        List<String> array = new ArrayList<String>();
                        array.add(libro[16].toString());
                        array.add(libro[17].toString());
                        array.add(libro[18].toString());
                        Book book = new Book(Integer.parseInt(libro[0]),libro[1],libro[2],Double.parseDouble(libro[3]),Integer.parseInt(libro[6]),Integer.parseInt(libro[7]),libro[8],libro[9],Range.just(Integer.parseInt(libro[10])),Integer.parseInt(libro[11]),libro[12],libro[13],Integer.parseInt(libro[14]),Integer.parseInt(libro[15]), array);
                        books.add(book);
                    }
                    // index++;
                    line = br.readLine();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (null != br) {
                    br.close();
                }
            }
            return books;
        }


    public void indexBooks() throws IOException{
        List<Book> books = this.createAndGetBooks();
        bookRepository.saveAll(books);
    }


    /**
     * Run indexing when dependency injection finish
     * @throws IOException
     */
    @PostConstruct
    public void indexStarting() {
        try {
            this.indexBooks();
        }
        catch (Exception ex) {
            System.out.println("Indexing failed");
        }
    }




    // Searches and utilities
    //***********************************************************************

    public void save(final Book book){ bookRepository.save(book); }

    public void delete(final Book book) { bookRepository.delete(book); }

    public Book findByTitle(final String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> findByCategory(final String category){
        return bookRepository.findByCategory(category);
    }

    public List<Book> findAll(){
            return bookRepository.findAll();
        }

    public PageImpl<Book> getTwentyBooks(int page){
        PageRequest pageWithTwentyBooks = PageRequest.of(page, 20);
        return new PageImpl<>(bookRepository.findAll(pageWithTwentyBooks).toList(), pageWithTwentyBooks, bookRepository.count());
    }


    /**
     * Returns the List of books that (flexibly) match a certain string by tittle, category or description.
     * @param string
     * @return
     */
    public List<Book> findByString(final String string){

        return bookRepository.findByString(string);
    }

    public ResponseEntity<List<Book>> get10BestRated(){
        List<Book> books = new ArrayList<Book>();
        List<Book> booksBestRated = new ArrayList<Book>();
        books = bookRepository.findAll();
        for(Book b: books){
            if(b.getStars().getLowerBound().getValue().get() ==5){
                booksBestRated.add(b);
            }
        }
        booksBestRated.sort((b1, b2) -> b2.getNumberOfReviews().compareTo(b1.getNumberOfReviews()));
        return ResponseEntity.ok(booksBestRated.subList(0, 10));
    }

    public ResponseEntity<List<Book>> get10BestSellings(){
        List<Book> books = new ArrayList<Book>();
        books = bookRepository.findAll();
        books.sort((b1, b2) -> b1.getAvilability().compareTo(b2.getAvilability()));
        return ResponseEntity.ok(books.subList(0, 10));
    }
}