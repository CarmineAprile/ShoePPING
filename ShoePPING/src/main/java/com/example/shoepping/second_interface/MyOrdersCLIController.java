package com.example.shoepping.second_interface;

import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public class MyOrdersCLIController {
    public void start(String orders) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println(orders);
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }
}
