package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.RecommendedBooksPageDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import skbx.example.struct.Book;
import com.example.MyBookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.getPageOfRecomendedBooks(0,6).getContent();
    }

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public RecommendedBooksPageDto getBooksPage(@RequestParam("offset") Integer offset,
                                                @RequestParam("limit") Integer limit) {
        return new RecommendedBooksPageDto(bookService.getPageOfRecomendedBooks(offset,limit).getContent());
    }

}
