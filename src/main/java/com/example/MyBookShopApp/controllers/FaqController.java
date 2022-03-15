package com.example.MyBookShopApp.controllers;

import skbx.example.struct.Book;
import com.example.MyBookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class FaqController {

    private final BookService bookService;

    @Autowired
    public FaqController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("faqCompany")
    public List<Book> faqCompany(){
        return bookService.getBooksData();
    }

    @GetMapping("/faq")
    public String faqPage(){
        return "/faq";
    }

}
