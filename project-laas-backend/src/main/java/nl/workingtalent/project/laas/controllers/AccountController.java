package nl.workingtalent.project.laas.controllers;

import java.util.Map;

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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        try {
            String email = loginRequest.get("email");
            String password = loginRequest.get("password");
            System.out.println("Login attempt: " + email);
            Account account = accountService.login(email, password);
            return ResponseEntity.ok(account);
        } catch (RuntimeException e) {
            System.out.println("Login failed: " + e.getMessage());
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}