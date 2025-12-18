package nl.workingtalent.project.laas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.project.laas.models.Account;
import nl.workingtalent.project.laas.services.AccountService;



@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular dev server
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account) {
        System.out.println("Registering account: " + account.getEmail());
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.ok(createdAccount);
    }
}