package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class SigninController {

    private final BookService bookService;

    @Autowired
    public SigninController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("signinUser")
    public List<Book> signinUser(){
        return bookService.getBooksData();
    }

    @GetMapping("/signin")
    public String signinPage(){
        return "/signin";
    }

}
