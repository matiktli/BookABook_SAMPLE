package com.models;

import com.models.enums.BookType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String title; //required
    private String author; //required
    private BookType type; //required
    private String description; //optional
    private List<String> groups; //optional
    private int copies; //optional



}
