package com.example.shoepping.second_interface;

import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.registration.controller.IRegistrationController;
import com.example.shoepping.use_case.registration.controller.RegistrationController;
import com.example.shoepping.use_case.registration.view.IRegistrationView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class RegistrationCLIController implements IRegistrationView {
    public void start() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println("****************************************");
        System.out.println("*      ShoePPING Registration Page     *");
        System.out.println("****************************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Sign up");
        System.out.println("2) Go back");

        Scanner scannerReg = new Scanner(System.in);
        int chReg;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chReg = scannerReg.nextInt();
                if (chReg >= 1 && chReg <= 2) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerReg.nextLine();
            }

        }

        switch (chReg){
            case 1 -> signUpMethod();
            case 2 -> goBackMethod();
            default -> error();

        }
    }

    public void goBackMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        LoginCLIController loginCLIController = new LoginCLIController();
        loginCLIController.start();
    }

    public void signUpMethod() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Username: ");
        String usernameReg = reader.readLine();
        System.out.print("Password: ");
        String passReg = reader.readLine();
        System.out.print("Confirm Password: ");
        String repassReg = reader.readLine();
        System.out.print("Email: ");
        String emailReg = reader.readLine();
        System.out.print("File System Login (true or false): ");
        String check = reader.readLine();

        boolean isChecked;
        isChecked = check.equals("true");

        //check on data length (via bean)

        IRegistrationController registrationController = new RegistrationController(this);
        registrationController.onRegistration(usernameReg, passReg, repassReg, emailReg,isChecked);
    }

    @Override
    public void onRegistrationSuccess() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {

        System.out.println("Registration successful");
        goBackMethod();

    }

    @Override
    public void onRegistrationError(String message, int codeError) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println(message);
        start();

    }
}
