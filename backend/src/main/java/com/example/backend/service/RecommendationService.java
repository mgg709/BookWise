package com.example.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.model.Book;
import com.example.backend.repositories.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final BookRepository bookRepository;
    
    public List<Book> getRecommendations(String title, String[] categories, Integer days) {
        List<Book> books = new ArrayList<Book>();
        List<Book> recommendations = new ArrayList<Book>();
        List<Book> booksSameCategory = new ArrayList<Book>();
        for (String category : categories) {
            books.addAll(bookRepository.findByCategory(category));
        }
        if(days == 1){
            for (Book b : books){
                if(b.getNumberOfPages() > 100)
                    books.remove(b);
            }
        } else if(days==2){
            for (Book b : books){
                if(b.getNumberOfPages() <=100 &&  b.getNumberOfPages() > 200)
                    books.remove(b);
            }
        } else if(days==3){
            for (Book b : books){
                if(b.getNumberOfPages() <=200 &&  b.getNumberOfPages() > 300)
                    books.remove(b);
            }
        }else{
            for (Book b : books){
                if(b.getNumberOfPages() <=300)
                    books.remove(b);
            }
        }
        List<Book> book = bookRepository.findByTitle(title);
        for (Book b : books) {
            if (b.getCategory().equals(book.get(0).getCategory())) {
                booksSameCategory.add(b);
                books.remove(b);
            }
        }

        booksSameCategory.sort((b1,b2) -> b2.getStars().getLowerBound().getValue().get().compareTo(b1.getStars().getLowerBound().getValue().get()));
        books.sort((b1,b2) -> b2.getStars().getLowerBound().getValue().get().compareTo(b1.getStars().getLowerBound().getValue().get()));
        recommendations.add(0, booksSameCategory.get(0));
        recommendations.add(1, booksSameCategory.get(1));
        recommendations.add(2, books.get(2));
        return recommendations;
    }
}
