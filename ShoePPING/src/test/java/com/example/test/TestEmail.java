package com.example.test;

import com.example.shoepping.bean.EmailBean;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestEmail {
    // Carmine Aprile
    @ParameterizedTest
    @CsvSource({
            "'', 5",
            "email, 6",
            "mariorossimariorossimariorossi0000@gmail.it, 30",
            "mariorossi00@gmail.it, -1"
    })
    void TestEmailBean(String email, int expectedValid){

        EmailBean emailBean = new EmailBean();
        emailBean.setEmail(email);
        int output = emailBean.getIsValid();
        assertEquals(expectedValid, output, 0);
    }
}
