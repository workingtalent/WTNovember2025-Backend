package nl.workingtalent.project.laas.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.project.laas.models.Loan;
import nl.workingtalent.project.laas.services.LoanService;

@CrossOrigin
@RestController
public class LoanController {

    @Autowired
    LoanService loanService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/show/loans")
    public List<Loan> list() {
        System.out.println("LoanController: Getting list of loans");
        List<Loan> loans = loanService.getAll();
        Collections.sort(loans);
        System.out.println("LoanController: Retrieved " + loans.size() + " loans");
        for (Loan loan : loans) {
            System.out.println("Loan ID: " + loan.getId() + ", Borrower: " + loan.getAccount().getUsername() + ", Copy: " 
             + loan.getCopy().getBook().getTitle());
        }
        return loans;
    }
}