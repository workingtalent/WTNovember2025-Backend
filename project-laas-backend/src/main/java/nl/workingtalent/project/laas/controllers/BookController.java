package nl.workingtalent.project.laas.controllers;

import nl.workingtalent.project.laas.models.Book;
import nl.workingtalent.project.laas.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/show/books")
    public List<Book> list() {
        System.out.println("BookController: Getting list of books");
        List<Book> books = bookService.getAll();
        System.out.println("BookController: Retrieved " + books.size() + " books");
        return books;
    }
}