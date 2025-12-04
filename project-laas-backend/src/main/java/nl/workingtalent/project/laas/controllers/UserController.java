package nl.workingtalent.project.laas.controllers;

import nl.workingtalent.project.laas.models.Account;
import nl.workingtalent.project.laas.models.AuthRequest;
import nl.workingtalent.project.laas.services.JwtService;
import nl.workingtalent.project.laas.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody Account requestInfo) {
        return userInfoService.addUser(requestInfo);
    }

    @GetMapping("/user/trainee")
    @PreAuthorize("hasAnyAuthority('TRAINER','TRAINEE')")
    public String userTrainee() {
        return "Welcome to trainee page";
    }

    @GetMapping("/admin/trainer")
    @PreAuthorize("hasAuthority('TRAINER')")
    public String adminTrainer() {
        return "Welcome to trainer page!";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}

