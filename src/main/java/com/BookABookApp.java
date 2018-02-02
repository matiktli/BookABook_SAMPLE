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
    DatabaseInitializer databaseInitializer;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BookABookApp.class);
    }

    public static void main(String[] args){
        SpringApplication.run(BookABookApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        databaseInitializer.dataInit();
    }


}
