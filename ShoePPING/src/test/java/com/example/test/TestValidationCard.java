package com.example.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.example.shoepping.ValidationCard.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestValidationCard {
    // Daniele Ausili

    @ParameterizedTest
    @CsvSource({
            "1111 1111 1111 1111, true",
            "1111 , false",
            "111 1111 1111 11111, false",
    })
    void TestValCardID(String cardID, boolean expectedValid){

        boolean output = valCardID(cardID);
        assertEquals(expectedValid, output);
    }

    @ParameterizedTest
    @CsvSource({
            "12/25, true",
            "12 25, false",
            "25/12, false",
    })
    void TestValCardDate(String cardDate, boolean expectedValid){

        boolean output = valCardDate(cardDate);
        assertEquals(expectedValid, output);
    }

    @ParameterizedTest
    @CsvSource({
            "123, true",
            "1234, false",
            "12, false",
    })
    void TestValCardCVC(String cardCVC, boolean expectedValid){

        boolean output = valCardCVC(cardCVC);
        assertEquals(expectedValid, output);
    }

}
