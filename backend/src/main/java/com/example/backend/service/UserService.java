package com.example.backend.service;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backend.model.Book;
import com.example.backend.model.User;
import com.example.backend.repositories.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class UserService{

    @Autowired
    private final UserRepository userRepository;
    
    @Autowired
    private final BookService bookService;



    public List<User> getUsers() { return userRepository.findAll(); }

    public User getUserByUsername(String username) { return userRepository.findItemByUsername(username); }


    /**
     *
     * @param username
     * @param pass
     * @return 0- Ok, 1- Wrong user, 2- Wrong password
     */
    public int login(String username, String pass) {

        User user = this.userRepository.findItemByUsername(username);

        if (user == null)
            return 1;
        if (!user.getPassword().equals(pass)) {
            return 2;
        }

        return 0;
    }


    /**
     * Create a new user or modify an existing one in the DB
     * @param user
     */
    public void save(User user)
        { this.userRepository.save(user); }


    public boolean usernameExist (String username)
        { return this.userRepository.findItemByUsername(username) != null; }

    public boolean emailExist (String email)
        { return this.userRepository.findItemByEmail(email) != null; }

    public void addFavourites(String username, String booktitle){
        User user = userRepository.findItemByUsername(username);
        List<String> favourites = user.getFavourites();
        for (String title: favourites){
            if(title.equals(booktitle)){
                return;
            }
        }
        user.addFavourites(booktitle);
        userRepository.save(user);
    }

    public void removeFavourites(String username, String booktitle){
        User user = userRepository.findItemByUsername(username);
        try{
            user.removeFavourites(booktitle);
            userRepository.save(user);
        }catch (Exception e) {
            return;
        }
    }

    public List<Book> getFavourites(String username){
        User user = userRepository.findItemByUsername(username);
        List<String> favourites = user.getFavourites();
        List<Book> books = new ArrayList<Book>();
        for (String title: favourites){
            books.add(bookService.findByTitle(title));
        }
        return books;
    }


}
