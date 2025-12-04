package nl.workingtalent.project.laas.controllers;

import nl.workingtalent.project.laas.models.Copy;
import nl.workingtalent.project.laas.services.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CopyController {

    @Autowired
    CopyService copyService;

    @GetMapping("/show/copies/bookid/{bookId}")
    public List<Copy> list(@PathVariable Integer bookId) {
        return copyService.getCopiesForBook(bookId);
    }
}