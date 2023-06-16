package com.example.test;

import com.example.shoepping.dao.user_dao.UserDAOJDBC;
import com.example.shoepping.model.user.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
class TestUserDAOJDBC {
    // Daniele Ausili

    @ParameterizedTest
    @CsvSource({
            "utente1, utente1, true",
            "utenteutente, utenteutente, false",
            "administrator, administrator, false",
    })
    void TestCheckLogin(String username, String password, boolean expectedValid) throws SQLException, IOException, ClassNotFoundException {

        User user = new User(username,password);
        UserDAOJDBC userDAOJDBC = new UserDAOJDBC();
        boolean output = userDAOJDBC.checkLogin(user);
        assertEquals(expectedValid, output);
    }

    @ParameterizedTest
    @CsvSource({
            "utente1, utente1, utente1@gmail.com",
    })
    void TestGetEmail(String username, String password, String expectedEmail) throws SQLException, IOException, ClassNotFoundException {

        User user = new User(username,password);
        UserDAOJDBC userDAOJDBC = new UserDAOJDBC();
        String output = userDAOJDBC.getEmail(user);
        assertEquals(expectedEmail, output);
    }

    @ParameterizedTest
    @CsvSource({
            "administrator, administrator, true",
            "utente1, utente1, false",
    })
    void TestIsAdmin(String username, String password, boolean expectedAdmin) throws SQLException, IOException, ClassNotFoundException {

        User user = new User(username,password);
        UserDAOJDBC userDAOJDBC = new UserDAOJDBC();
        boolean output = userDAOJDBC.isAdmin(user);
        assertEquals(expectedAdmin, output);
    }


}
