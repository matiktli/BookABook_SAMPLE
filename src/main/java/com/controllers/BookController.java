package com.controllers;

import com.models.Book;
import com.models.enums.BookType;
import com.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/all")
    public ModelAndView getAllBooks(ModelAndView model) {
        model.addObject("booksList",bookService.getAllBooks());
        model.setViewName("booksList");
        return model;
    }

    @RequestMapping(value="/findForBook",method = RequestMethod.GET)
    public ModelAndView showFindForBookForm(ModelAndView model){
        model.setViewName("bookFinderPage");
        return model;
    }

    @RequestMapping(value = "/findForBook",method = RequestMethod.POST)
    public String responseFinderForBook(Model model,@RequestParam("finderInput") String finderInput){
        model.addAttribute("booksList",bookService.getBooksByTitleOrAuthor(finderInput,finderInput));
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

    @RequestMapping(value = "/find",params = "title")
    public String getBookByTitle(Model model, @RequestParam("title") String title){
        model.addAttribute("book",bookService.getBookByTitle(title));
        return "singleBookPage";
    }

    @RequestMapping(value = "/find",params = "id")
    public String getBookById(Model model, @RequestParam("id") String id){
        model.addAttribute("book",bookService.getBookById(id));
        return "singleBookPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddBookForm(){
        return "bookForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submitAddBookForm(String title,String author, String type,
                                    String description, String groups, int copies){

        Book book = new Book(new Book.Builder(title,author,BookType.valueOf(type))
                .copies(copies)
                .description(description)
                .groups(new ArrayList<>(Arrays.asList(groups.split(",")))));
        bookService.saveBook(book);
        return "redirect:/books/find?id="+book.getId();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateBookForm(ModelAndView model, @RequestParam("id") String id){
        model.addObject("book",bookService.getBookById(id));
        return "bookForm";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdateBookForm(String title,String author, String type, String description,
                                       String groups, int copies, @RequestParam("id") String id){

        Book book = new Book(new Book.Builder(title,author,BookType.valueOf(type))
                .copies(copies)
                .description(description)
                .groups(new ArrayList<>(Arrays.asList(groups.split(",")))));
        bookService.saveBook(book);

        book.setId(id);
        bookService.saveBook(book);
        return "redirect:/books/find?id="+book.getId();
    }





}
