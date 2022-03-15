package com.example.MyBookShopApp.controllers;

import skbx.example.struct.Book;
import com.example.MyBookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class DocumentsController {

    private final BookService bookService;

    @Autowired
    public DocumentsController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("documents")
    public List<Book> documents(){
        return bookService.getBooksData();
    }

    @GetMapping("/documents/index")
    public String documentPage(){
        return "/documents/index";
    }

}
