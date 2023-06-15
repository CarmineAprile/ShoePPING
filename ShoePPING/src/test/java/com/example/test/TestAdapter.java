package com.example.test;

import com.example.shoepping.pattern.adapter.Adapter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAdapter {
    // Carmine Aprile
    @ParameterizedTest
    @CsvSource({
            "100, As new, 90",
            "100, Lightly used, 70",
            "100, Averagely used, 50",
    })
    void TestAdapter(String price, String condition, double expectedPrice){
        Adapter testAdapter = new Adapter();
        double output = testAdapter.calculatePrice(price, condition);
        assertEquals(expectedPrice, output, 0);
    }
}
