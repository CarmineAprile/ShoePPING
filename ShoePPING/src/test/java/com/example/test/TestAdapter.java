package com.example.test;

import com.example.shoepping.pattern.adapter.Adapter;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdapter {

    @Test
    public void TestAdapterAsNew(){
        Adapter testAdapter = new Adapter();
        double output = testAdapter.calculatePrice("100", "As new");
        assertEquals(90, output, 0);
    }

    @Test
    public void TestAdapterLightlyUsed(){
        Adapter testAdapter = new Adapter();
        double output = testAdapter.calculatePrice("100", "Lightly used");
        assertEquals(70, output, 0);
    }

    @Test
    public void TestAdapterAveragelyUsed(){
        Adapter testAdapter = new Adapter();
        double output = testAdapter.calculatePrice("100", "Averagely used");
        assertEquals(50, output, 0);
    }


}
