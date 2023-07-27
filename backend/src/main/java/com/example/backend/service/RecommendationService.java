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
        List<Book> booksToRemove = new ArrayList<Book>();
        List<Book> recommendations = new ArrayList<Book>();
        List<Book> booksSameCategory = new ArrayList<Book>();
        for (String category : categories) {
            books.addAll(bookRepository.findByCategory(category));
        }
        if(days == 1){
            for (Book b : books){
                if(b.getNumberOfPages() > 200)
                    booksToRemove.add(b);
            }
        } else if(days==2){
            for (Book b : books){
                if(b.getNumberOfPages() <=200 ||  b.getNumberOfPages() > 300)
                    booksToRemove.add(b);
            }
        } else if(days==3){
            for (Book b : books){
                if(b.getNumberOfPages() <=300 ||  b.getNumberOfPages() > 400)
                    booksToRemove.add(b);
            }
        }else{
            for (Book b : books){
                if(b.getNumberOfPages() <=400)
                    booksToRemove.add(b);
            }
        }
        books.removeAll(booksToRemove);
        if(!title.isEmpty()){
        Book book = bookRepository.findByTitle(title).get(0);
       
        for (Book b : books) {
            if (b.getCategory().equals(book.getCategory())) {
                booksSameCategory.add(b);
            }
        }
        }
        books.removeAll(booksSameCategory);
        booksSameCategory.sort((b1,b2) -> b2.getStars().getLowerBound().getValue().get().compareTo(b1.getStars().getLowerBound().getValue().get()));
        books.sort((b1,b2) -> b2.getStars().getLowerBound().getValue().get().compareTo(b1.getStars().getLowerBound().getValue().get()));
        for(int i = 0; i<2 && i<booksSameCategory.size();i++){
            recommendations.add(i, booksSameCategory.get(i));
        }
        if(!books.isEmpty() && !recommendations.isEmpty()){
            if(books.get(0) != recommendations.get(0) && books.get(0) != recommendations.get(1)){
                recommendations.add(2, books.get(0));
            }
        }
        if(!books.isEmpty() && recommendations.isEmpty()){
           for(int i = 0; i<3 && i<books.size();i++){
            recommendations.add(i, books.get(i));
           }
        }
        return recommendations;
    }
}