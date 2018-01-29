package com.services;

import com.models.Book;
import com.models.enums.BookType;
import com.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBooksByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getBooksByType(BookType type){
        return bookRepository.findByType(type);
    }

    public List<Book> getBooksByGroupContaining(List<String> group){
        return bookRepository.findBookByGroupsContains(group);
    }

    public Book getBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }
    public Book getBookById(String id){ return bookRepository.findOne(id);}

    public void saveBook(Book book){
        bookRepository.save(book);
    }

    public Book updateBook(String id){
        return null;
    }

    public void deleteBook(String id){
        bookRepository.delete(id);
    }
}
