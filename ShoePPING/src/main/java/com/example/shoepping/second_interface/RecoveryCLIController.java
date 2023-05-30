package com.example.shoepping.second_interface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RecoveryCLIController {
    public void start() throws Exception {

        System.out.println("************************************");
        System.out.println("*      ShoePPING Recovery Page     *");
        System.out.println("************************************\n");
        System.out.println("***  What should I do for you?   ***\n");
        System.out.println("1) Recover password");
        System.out.println("2) Go back");

        Scanner scanner = new Scanner(System.in);
        int ch;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                ch = scanner.nextInt();
                if (ch >= 1 && ch <= 2) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scanner.nextLine();
            }

        }

        switch (ch){
            case 1 -> recoverMethod();
            case 2 -> goBackMethod();
            default -> throw new RuntimeException("Invalid choice");

        }
    }

    public void goBackMethod() throws Exception {
        LoginCLIController loginCLIController = new LoginCLIController();
        loginCLIController.start();
    }

    public void recoverMethod() throws Exception {
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
