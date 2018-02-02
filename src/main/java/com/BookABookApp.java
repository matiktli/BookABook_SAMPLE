package com;

import com.models.Book;
import com.models.User;
import com.models.enums.BookType;
import com.models.enums.StatusType;
import com.repositories.BookRepository;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class BookABookApp extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public UserRepository userRepository;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BookABookApp.class);
    }

    public static void main(String[] args){
        SpringApplication.run(BookABookApp.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        userRepository.deleteAll();

        userRepository.save(new User("Mateusz","Kitlinski","m.kitlinos@gmail.com","psw1"));
        userRepository.save(new User("Patryk","Karwat","kupeczkas@gmail.com","psw2"));

        bookRepository.save(new Book(new Book.Builder("Spring 1","Tomas", BookType.PAPER_BOOK)
                .description("First book").groups(new ArrayList<>(Arrays.asList("PC","GAME")))).setStatus(StatusType.BOOKED));
        bookRepository.save(new Book(new Book.Builder("Spring 2","Tomas", BookType.E_BOOK)
                .description("Second book").groups(new ArrayList<>(Arrays.asList("PC","ART")))));
        bookRepository.save(new Book(new Book.Builder("Spring 3","Krzys", BookType.AUDIO_BOOK)
                .description("Third book").groups(new ArrayList<>(Arrays.asList("SMH","GAME")))));

    }


}
