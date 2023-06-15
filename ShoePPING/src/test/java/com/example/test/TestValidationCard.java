package com.example.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.example.shoepping.ValidationCard.valCardID;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidationCard {
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



}
