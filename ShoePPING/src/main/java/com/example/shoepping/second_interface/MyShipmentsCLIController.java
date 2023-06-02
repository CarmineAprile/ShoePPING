package com.example.shoepping.second_interface;

import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public class MyShipmentsCLIController {
    public void start(String shipments) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println(shipments);
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }
}
