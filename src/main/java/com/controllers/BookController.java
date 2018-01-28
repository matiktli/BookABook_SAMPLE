package com.controllers;

import com.models.Book;
import com.models.enums.BookType;
import com.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getAllBooks(Model model) {
        model.addAttribute("booksList",bookService.getAllBooks());
        return "booksList";
    }

    @RequestMapping(value = "/find",params = "author")
    public String getBooksByAuthor(Model model, @RequestParam("author") String author){
        model.addAttribute("booksList",bookService.getBooksByAuthor(author));
        return "booksList";
    }

    @RequestMapping(value = "/find", params = "group")
    public String getBooksByGroup(Model model,@RequestParam("group") List<String> group){
        model.addAttribute("booksList",bookService.getBooksByGroupContaining(group));
        return "booksList";
    }

    @RequestMapping(value = "/find",params = "type")
    public String getBooksByType(Model model,@RequestParam("type") String type){
        BookType typeEnum = BookType.fromValue(type);
        model.addAttribute("booksList",bookService.getBooksByType(typeEnum));
        return "booksList";
    }

    //TODO: Make book page
    @RequestMapping(value = "/find",params = "title")
    @ResponseBody
    Book getBookByTitle(@RequestParam("title") String title){
        return bookService.getBookByTitle(title);
    }



}
