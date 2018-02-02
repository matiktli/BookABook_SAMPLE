package com.services;

import com.models.Book;
import com.models.User;
import com.models.enums.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    public void bookingBookForUser(String idBook,String idUser){
        Book book = bookService.getBookById(idBook);
        User user = userService.getUserById(idUser);
        book.setStatus(StatusType.BOOKED);
        book.setId(idBook);
        user.getUserBooks().add(book);
        user.setId(idUser);
        bookService.saveBook(book);
        userService.saveUser(user);
    }

    public void returningBook(String idBook,String idUser){
        Book book = bookService.getBookById(idBook);
        User user = userService.getUserById(idUser);
        user.getUserBooks().remove(book);
        user.setId(idUser);
        book.setStatus(StatusType.FREE);
        bookService.saveBook(book);
        userService.saveUser(user);
    }
}
