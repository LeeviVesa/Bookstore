package com.example.Bookstore.Domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long isbn;
    private String title;
    private String author;
    private Integer price;
    private Integer year;

    public Book(){}
    public Book(String title, String author, Integer price, Integer year, Long isbn ) {
        super();
        this.title = title;
        this.author = author;
        this.price = price;
        this.year = year;
        this.isbn = isbn;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return "MyFriends [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + ", year=" + year + "]";
    }
}
