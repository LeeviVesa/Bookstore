package com.example.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.Domain.Book;
import com.example.Bookstore.Domain.BookRepository;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;
    @RequestMapping("/index")
    public String home() {
        return "index";
    }

    @RequestMapping("/listbooks")
    public String listbooks(Model model) {
            model.addAttribute("Books", repository.findAll());
            return "listbooks";

    }
}
