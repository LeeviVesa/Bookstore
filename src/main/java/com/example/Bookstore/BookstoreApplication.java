package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.Domain.Book;
import com.example.Bookstore.Domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		long isbn = 1;
		long isbn2 = 2;
		return (args) -> {
			log.info("save books");
			repository.save(new Book("Matey", "Pepperson", 10810, 3018, isbn2));
			repository.save(new Book("Katy", "Kateson", 1080, 1999, isbn));

			log.info("fetch all students");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
