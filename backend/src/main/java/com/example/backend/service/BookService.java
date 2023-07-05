package com.example.backend.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.core.Range;
import org.springframework.stereotype.Service;

import com.example.backend.model.Book;
import com.example.backend.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void save(final Book book){
        bookRepository.save(book);
    }

    public List<Book> findByTitle(final String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> createAndGetBooks() throws IOException {
            BufferedReader br = null;
            List<Book> books = new ArrayList<Book>();

            try {
                br = new BufferedReader(new FileReader("src/main/java/com/example/backend/dataset.csv"));
                //Nos saltamos la primera línea para que no lea las labels del dataset
                String line = br.readLine();
                //Primer libro
                line = br.readLine();
                // int index = 0;
                while (null != line) {

                    String[] libro = line.split(";");
                    if(libro.length!=16) {
                        int aux = libro.length - 16;
                        for(int i=1; i<=aux; i++){
                            libro[8] += libro[8+aux];
                        }
                        Book book = new Book(Integer.parseInt(libro[0]),libro[1],libro[2],Double.parseDouble(libro[3]),Integer.parseInt(libro[7]),libro[8],libro[8+aux+1], Range.just(Integer.parseInt(libro[8+aux+2])),Integer.parseInt(libro[8+aux+3]),libro[8+aux+4],libro[8+aux+5],Integer.parseInt(libro[8+aux+6]),Integer.parseInt(libro[8+aux+7]));
                        books.add(book);
                        System.out.println(book.toString());
                    }else{
                        Book book = new Book(Integer.parseInt(libro[0]),libro[1],libro[2],Double.parseDouble(libro[3]),Integer.parseInt(libro[7]),libro[8],libro[9],Range.just(Integer.parseInt(libro[10])),Integer.parseInt(libro[11]),libro[12],libro[13],Integer.parseInt(libro[14]),Integer.parseInt(libro[15]));
                        books.add(book);
                        System.out.println(book.toString());
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

        public List<Book> findAll(){
            return bookRepository.findAll();
        }

}