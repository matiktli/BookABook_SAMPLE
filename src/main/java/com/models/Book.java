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

    public Book(){}

    public Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.type = builder.type;
        this.description = builder.description;
        this.groups = builder.groups;
        this.copies = builder.copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getGroups() {
        return groups;
    }

    public int getCopies() {
        return copies;
    }


    public static class Builder{
        private final String title;
        private final String author;
        private final BookType type;
        private String description;
        private List<String> groups;
        private int copies;

        public Builder(String title, String author, BookType type) {
            this.title = title;
            this.author = author;
            this.type = type;
        }

        public Builder description(String description){
            this.description=description;
            return this;
        }

        public Builder groups(List<String> groups){
            this.groups=groups;
            return this;
        }

        public Builder copies(int copies){
            this.copies=copies;
            return this;
        }
    }



}
