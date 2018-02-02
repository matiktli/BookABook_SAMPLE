package com.models;

import com.models.enums.BookType;
import com.models.enums.StatusType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Document(collection = "books")
public class Book {

    @Id
    private String id;
    @NotNull @Size(min=5,max=20)
    private String title; //required
    @NotNull @Size(min=5,max=20)
    private String author; //required
    private BookType type; //required
    @Size(max=100)
    private String description; //optional
    private List<String> groups; //optional
    private StatusType status=StatusType.FREE;

    public Book(){}

    public Book(String title, String author, BookType type, String description, List<String> groups) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.description = description;
        this.groups = groups;
    }

    public Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.type = builder.type;
        this.description = builder.description;
        this.groups = builder.groups;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public StatusType getStatus() {
        return status;
    }

    public Book setStatus(StatusType status) {
        this.status = status;
        return this;
    }

    public static class Builder{
        private final String title;
        private final String author;
        private final BookType type;
        private String description;
        private List<String> groups;
        private StatusType status;

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

        public Builder status(StatusType status){
            this.status=status;
            return this;
        }

    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", groups=" + groups +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title);
    }
}

