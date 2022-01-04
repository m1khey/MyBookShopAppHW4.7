package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class GenresController {

    private final BookService bookService;

    @Autowired
    public GenresController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("genresBooks")
    public List<Book> genresBooks(){
        return bookService.getBooksData();
    }

    @GetMapping("/genres/index")
    public String genresPage(){
        return "/genres/index";
    }

}
