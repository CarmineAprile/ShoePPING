package com.example.test;

import com.example.shoepping.bean.PasswordBean;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPasswordBean {
    // Daniele Ausili

    @ParameterizedTest
    @CsvSource({
            "password1, -1",
            "pass, 2",
            "passwordpasswordpassword, 20",
    })
    void TestPasswordBean(String password, int expectedValid){

        PasswordBean passwordBean = new PasswordBean();
        passwordBean.setPassword(password);
        int output = passwordBean.getIsValid();
        assertEquals(expectedValid, output, 0);
    }

}
