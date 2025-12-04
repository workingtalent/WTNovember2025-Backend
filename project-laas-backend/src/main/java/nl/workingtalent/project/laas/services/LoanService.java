package nl.workingtalent.project.laas.services;

import nl.workingtalent.project.laas.models.Loan;
import nl.workingtalent.project.laas.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAll() {
        return loanRepository.findAll();
    }
}
