package com.example.shoepping.second_interface;

import com.example.shoepping.bean.EmailBean;
import com.example.shoepping.bean.UsernameBean;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.profile.controller.IProfileController;
import com.example.shoepping.use_case.profile.controller.ProfileController;
import com.example.shoepping.use_case.profile.view.IProfileView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class ProfileCLIController implements IProfileView {
    public void start() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {


        System.out.println("*********************************");
        System.out.println("*     ShoePPING profile Page    *");
        System.out.println("*********************************\n");
        IProfileController profileController = new ProfileController(this);
        profileController.setLabels();
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Edit Profile");
        System.out.println("2) My Orders");
        System.out.println("3) My Sales");
        System.out.println("4) My Shipments");
        System.out.println("5) About us");
        System.out.println("6) Go Home Page");
        System.out.println("7) Exit");

        Scanner scannerPro = new Scanner(System.in);
        int chPro;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chPro = scannerPro.nextInt();
                if (chPro >= 1 && chPro <= 7) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerPro.nextLine();
            }

        }

        switch (chPro){
            case 1 -> editMethod();
            case 2 -> ordersMethod();
            case 3 -> salesMethod();
            case 4 -> shipmentsMethod();
            case 5 -> aboutMethod();
            case 6 -> goBackMethod();
            case 7 -> exitMethod();
            default -> error();

        }
    }

    @Override
    public void setLabels(UsernameBean usernameBean, EmailBean emailBean) {
        System.out.println("Username: " + usernameBean.getUsername());
        System.out.println("Email: " + emailBean.getEmail());
    }

    public void editMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        EditProfileCLIController editProfileCLIController = new EditProfileCLIController();
        editProfileCLIController.start();
    }

    public void ordersMethod() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        IProfileController profileController = new ProfileController();
        String orders = profileController.onOrders();

        MyOrdersCLIController myOrdersCLIController = new MyOrdersCLIController();
        myOrdersCLIController.start(orders);
    }

    public void salesMethod() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        IProfileController profileController = new ProfileController();
        String sales = profileController.onSales();

        MySalesCLIController mySalesCLIController = new MySalesCLIController();
        mySalesCLIController.start(sales);
    }

    public void shipmentsMethod() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        IProfileController profileController = new ProfileController();
        String shipments = profileController.onShipments();

        MyShipmentsCLIController myShipmentsCLIController = new MyShipmentsCLIController();
        myShipmentsCLIController.start(shipments);
    }

    public void aboutMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println("ShoePPING app for ISPW project.\nDevelopers: Carmine Aprile, Daniele Ausili.");
        start();
    }

    public void goBackMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        BuyUserCLIController buyUserCLIController = new BuyUserCLIController();
        buyUserCLIController.start();
    }

    public void exitMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        LoginCLIController loginCLIController = new LoginCLIController();
        loginCLIController.start();
    }
}
