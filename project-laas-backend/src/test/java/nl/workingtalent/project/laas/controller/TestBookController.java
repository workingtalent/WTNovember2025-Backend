package nl.workingtalent.project.laas.controller;

import nl.workingtalent.project.laas.controllers.BookController;
import nl.workingtalent.project.laas.models.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TestBookController {

    @Autowired
    private BookController bookController;

    @Test
    void contextLoads() {
        assertThat(bookController).isNotNull();
    }

    @Test
    void testShowBooks() throws Exception {
        List<Book> books = bookController.list();

        assertThat(books).hasSize(3);
    }
}