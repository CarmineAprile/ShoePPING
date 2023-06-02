package com.example.shoepping.second_interface;

import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public class MySalesCLIController {
    public void start(String sales) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println(sales);
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }
}
