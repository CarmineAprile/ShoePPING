package com.example.shoepping.second_interface;

import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class RecoveryCLIController {
    public void start() throws SQLException, ClassNotFoundException, IOException, ManageException, CsvValidationException {

        System.out.println("************************************");
        System.out.println("*      ShoePPING Recovery Page     *");
        System.out.println("************************************\n");
        System.out.println("***  What should I do for you?   ***\n");
        System.out.println("1) Recover password");
        System.out.println("2) Go back");

        Scanner scannerRec = new Scanner(System.in);
        int chRec;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chRec = scannerRec.nextInt();
                if (chRec >= 1 && chRec <= 2) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerRec.nextLine();
            }

        }

        switch (chRec){
            case 1 -> recoverMethod();
            case 2 -> goBackMethod();
            default -> error();

        }
    }

    public void goBackMethod() throws SQLException, ClassNotFoundException, IOException, ManageException, CsvValidationException {
        LoginCLIController loginCLIController = new LoginCLIController();
        loginCLIController.start();
    }

    public void recoverMethod() throws SQLException, ClassNotFoundException, IOException, ManageException, CsvValidationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Username: ");
        String filler1 = reader.readLine();
        System.out.print("Email: ");
        String filler2 = reader.readLine();
        System.out.println("We have sent an email to " + filler1 + " to reset the password of the user " + filler2);
        LoginCLIController loginCLIController = new LoginCLIController();
        loginCLIController.start();
    }
}
