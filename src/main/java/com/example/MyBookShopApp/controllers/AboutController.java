package com.example.MyBookShopApp.controllers;

import skbx.example.struct.Book;
import com.example.MyBookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class AboutController {

    private final BookService bookService;

    @Autowired
    public AboutController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("aboutCompany")
    public List<Book> aboutCompany(){
        return bookService.getBooksData();
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "/about";
    }

}
