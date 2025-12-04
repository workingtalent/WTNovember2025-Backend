package nl.workingtalent.project.laas.controllers;

import nl.workingtalent.project.laas.models.Loan;
import nl.workingtalent.project.laas.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping("/show/loans")
    public List<Loan> list() {
        return loanService.getAll();
    }
}