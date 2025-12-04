package nl.workingtalent.project.laas.controller;

import nl.workingtalent.project.laas.controllers.BookController;
import nl.workingtalent.project.laas.models.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import nl.workingtalent.project.laas.models.Account;
import nl.workingtalent.project.laas.services.UserInfoService;
import nl.workingtalent.project.laas.repositories.UserInfoRepository;


@SpringBootTest
class TestAccount {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    void canFindById() {
        Account testAccount = new Account("username", "password", "email@example.com", "ROLE_USER", "FirstName", "LastName");
        Account savedAccount = userInfoRepository.save(testAccount);

        Long testId = savedAccount.getId();

        Account foundAccount = userInfoService.findAccountById(testId);
        assertThat(foundAccount).isNotNull();
        assertThat(foundAccount.getUsername()).isEqualTo("username");
    }
}