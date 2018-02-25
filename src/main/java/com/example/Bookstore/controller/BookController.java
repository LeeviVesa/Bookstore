package com.example.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.Domain.Book;
import com.example.Bookstore.Domain.BookRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    @RequestMapping(value = "/delete/{isbn}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("isbn") Long isbn, Model model) {
        repository.delete(isbn);
        return "redirect:../listbooks";
    }
    @RequestMapping(value = "/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:listbooks";
    }
    //restful haku kaikesta
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> studentListRest() {
        return (List<Book>) repository.findAll();
    }
    //restful haku isbn koodin mukaan
    @RequestMapping(value="/book/{isbn}", method = RequestMethod.GET)
    public @ResponseBody Book findStudentRest(@PathVariable("isbn") Long isbn) {
        return repository.findOne(isbn);
    }
}
