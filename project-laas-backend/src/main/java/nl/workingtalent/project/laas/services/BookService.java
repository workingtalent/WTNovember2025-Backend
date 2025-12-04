package nl.workingtalent.project.laas.services;

import nl.workingtalent.project.laas.models.Book;
import nl.workingtalent.project.laas.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
