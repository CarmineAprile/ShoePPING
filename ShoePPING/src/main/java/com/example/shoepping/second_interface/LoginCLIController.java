package com.example.shoepping.second_interface;

import com.example.shoepping.use_case.login.controller.ILoginController;
import com.example.shoepping.use_case.login.controller.LoginController;
import com.example.shoepping.use_case.login.view.ILoginView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginCLIController implements ILoginView {
    public void start() throws Exception {
        System.out.println("*********************************");
        System.out.println("*      ShoePPING Login Page     *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Login");
        System.out.println("2) Login with Google");
        System.out.println("3) Password recovery");
        System.out.println("4) Create new account");
        System.out.println("5) Quit");

        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                choice = input.nextInt();
                if (choice >= 1 && choice <= 5) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                input.nextLine();
            }

        }

        switch (choice){
            case 1 -> loginMethod();
            case 2 -> System.out.println("Work in progress...");
            case 3 -> recoveryMethod();
            case 4 -> registrationMethod();
            case 5 -> System.exit(0);
            default -> throw new RuntimeException("Invalid choice");

        }
    }

    public void loginMethod() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Username: ");
        String usernameLogin = reader.readLine();
        System.out.print("Password: ");
        String passLogin = reader.readLine();
        System.out.print("File System Login (true or false): ");
        String check = reader.readLine();

        boolean isChecked;
        isChecked = check.equals("true");

        //check on data length (via bean)

        ILoginController loginPresenter = new LoginController(this);
        loginPresenter.onLogin(usernameLogin, passLogin, isChecked);

    }

    public void recoveryMethod() throws Exception {
        RecoveryCLIController recoveryCLIController = new RecoveryCLIController();
        recoveryCLIController.start();
    }

    public void registrationMethod(){
        RegistrationCLIController registrationCLIController = new RegistrationCLIController();
        registrationCLIController.start();
    }

    @Override
    public void onLoginSuccessUser() {
        BuyUserCLIController buyUserCLIController = new BuyUserCLIController();
        buyUserCLIController.start();
    }

    @Override
    public void onLoginSuccessAdmin() {
        AdministratorCLIController administratorCLIController = new AdministratorCLIController();
        administratorCLIController.start();
    }

    @Override
    public void onLoginError(String message, int codeError) throws Exception {

        System.out.println(message);
        start();

    }
}
