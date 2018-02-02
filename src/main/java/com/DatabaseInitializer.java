package com;

import com.models.Book;
import com.models.User;
import com.models.enums.BookType;
import com.models.enums.StatusType;
import com.repositories.BookRepository;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DatabaseInitializer {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public UserRepository userRepository;

    DatabaseInitializer(){}

    public void dataInit(){
        bookRepository.deleteAll();
        userRepository.deleteAll();

        userRepository.save(new User("Adam","Kowalski","aa@bb.cc","psw1"));
        userRepository.save(new User("Joshua","Gains","dd@ee.ff","psw2"));

        bookRepository.save(new Book(new Book.Builder("Spring 1","Tomas", BookType.PAPER_BOOK)
                .description("First book").groups(new ArrayList<>(Arrays.asList("PC","GAME","DB")))));
        bookRepository.save(new Book(new Book.Builder("Spring 2","Carlos", BookType.E_BOOK)
                .description("Second book").groups(new ArrayList<>(Arrays.asList("PC","ART")))));
        bookRepository.save(new Book(new Book.Builder("Spring 3","Tomas", BookType.AUDIO_BOOK)
                .description("Third book").groups(new ArrayList<>(Arrays.asList("SPRING","GAME")))));
        bookRepository.save(new Book(new Book.Builder("Spring 4","Ania", BookType.PAPER_BOOK)
                .description("Fourth book").groups(new ArrayList<>(Arrays.asList("ART","FUN","GAME")))));
        bookRepository.save(new Book(new Book.Builder("Spring 5","Craig", BookType.AUDIO_BOOK)
                .description("Fifth book").groups(new ArrayList<>(Arrays.asList("FUN","NEW")))));
        bookRepository.save(new Book(new Book.Builder("Spring 6","Walls", BookType.PAPER_BOOK)
                .description("Sample desc").groups(new ArrayList<>(Arrays.asList("NEW")))));
    }
}
