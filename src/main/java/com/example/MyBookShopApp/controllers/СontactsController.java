package com.example.MyBookShopApp.controllers;

import skbx.example.struct.Book;
import com.example.MyBookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class СontactsController {

    private final BookService bookService;

    @Autowired
    public СontactsController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("contacts")
    public List<Book> contacts(){
        return bookService.getBooksData();
    }

    @GetMapping("/contacts")
    public String contactsPage(){
        return "/contacts";
    }

}
