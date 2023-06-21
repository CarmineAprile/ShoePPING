package com.example.test;

import com.example.shoepping.dao.user_dao.UserDAOCSV;
import com.example.shoepping.model.user.User;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestUserDaoCSV {
    // Carmine Aprile

    @ParameterizedTest
    @CsvSource({
            "utente1, utente1, true",
            "utenteutente, utenteutente, false",
            "administrator, administrator, false",
    })
    void TestCheckLogin(String username, String password, boolean expectedValid) throws IOException, CsvValidationException {

        User user = new User(username,password);
        UserDAOCSV userDAOCSV = new UserDAOCSV();
        boolean output = userDAOCSV.checkLogin(user);
        assertEquals(expectedValid, output);
    }

    @ParameterizedTest
    @CsvSource({
            "utente1, utente1, utente1@gmail.com",
    })
    void TestGetEmail(String username, String password, String expectedEmail) throws IOException, CsvValidationException {

        User user = new User(username,password);
        UserDAOCSV userDAOCSV = new UserDAOCSV();
        String output = userDAOCSV.getEmail(user);
        assertEquals(expectedEmail, output);
    }

    @ParameterizedTest
    @CsvSource({
            "utente1, utente1, false",
    })
    void TestIsAdmin(String username, String password, boolean expectedAdmin) {

        User user = new User(username,password);
        UserDAOCSV userDAOCSV = new UserDAOCSV();
        boolean output = userDAOCSV.isAdmin(user);
        assertEquals(expectedAdmin, output);
    }
}
