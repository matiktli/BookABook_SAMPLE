package com.controllers;

import com.models.Book;
import com.models.enums.BookType;
import com.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/all")
    @ResponseBody
    List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/find",params = "author")
    @ResponseBody
    List<Book> getBooksByAuthor(@RequestParam("author") String author){
        return bookService.getBooksByAuthor(author);
    }

    @RequestMapping(value = "/find", params = "group")
    @ResponseBody
    List<Book> getBooksByGroup(@RequestParam("group") List<String> group){
        return bookService.getBooksByGroupContaining(group);
    }

    @RequestMapping(value = "/find",params = "type")
    @ResponseBody
    List<Book> getBooksByType(@RequestParam("type") String type){
        BookType typeEnum = BookType.fromValue(type);
        return bookService.getBooksByType(typeEnum);
    }

    @RequestMapping(value = "/find",params = "title")
    @ResponseBody
    Book getBookByTitle(@RequestParam("title") String title){
        return bookService.getBookByTitle(title);
    }


}
