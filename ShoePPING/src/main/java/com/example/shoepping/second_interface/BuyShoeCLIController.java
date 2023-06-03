package com.example.shoepping.second_interface;

import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.buy_shoe.controller.BuyShoeController;
import com.example.shoepping.use_case.buy_shoe.controller.IBuyShoeController;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class BuyShoeCLIController implements IBuyShoeView {

    int reference;

    List<String> sizes = new ArrayList<>();

    public void start(String model, String price, int reference) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        this.reference = reference;

        sizes.add("37");
        sizes.add("38");
        sizes.add("39");
        sizes.add("40");
        sizes.add("41");
        sizes.add("42");
        sizes.add("43");
        sizes.add("44");
        sizes.add("45");
        sizes.add("46");

        IBuyShoeController buyShoeController = new BuyShoeController(this);

        ModelShoeBean modelShoeBean = new ModelShoeBean();
        modelShoeBean.setModelShoe(model);

        buyShoeController.getSizeAmountList(modelShoeBean);

        System.out.println(model);
        System.out.println(price);

        System.out.println("Available sizes:");
        for (String size : sizes) {
            System.out.println(size);
        }

        System.out.println("*********************************");
        System.out.println("*     ShoePPING Buy Shoe Page   *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Confirm");
        System.out.println("2) Go Back");
        System.out.println("3) Buy Menu");
        System.out.println("4) Sell");
        System.out.println("5) Profile");


        Scanner scannerShoe = new Scanner(System.in);
        int chShoe;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chShoe = scannerShoe.nextInt();
                if (chShoe >= 1 && chShoe <= 5) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerShoe.nextLine();
            }

        }

        switch (chShoe){
            case 1 -> confirmMethod(model, price);
            case 2 -> goBackMethod();
            case 3 -> buyMethod();
            case 4 -> sellMethod();
            case 5 -> profileMethod();

            default -> error();

        }
    }

    @Override
    public void onDisable(SizeShoeBean i) {
        sizes.removeIf(size -> size.equals(i.getSizeShoe()));
    }

    @Override
    public void onConfirmSuccess() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        System.out.println("Order received successfully");
        buyMethod();
    }

    @Override
    public void onConfirmError(MessageBean message, CodeBean code) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println(message.getMessage());
        goBackMethod();
    }

    public void confirmMethod(String model, String price) throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Size: ");
        String sizeShoe = reader.readLine();
        System.out.print("Address: ");
        String addressShoe = reader.readLine();
        System.out.print("Card ID: ");
        String cardIdShoe = reader.readLine();
        System.out.print("Card Date: ");
        String cardDateShoe = reader.readLine();
        System.out.print("Card CVC: ");
        String cardCVCShoe = reader.readLine();

        boolean found = false;
        for (String size: sizes){
            if (size.equals(sizeShoe)) {
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Invalid size");
            confirmMethod(model, price);
        }

        OrderVecBean orderVecBean = new OrderVecBean();
        orderVecBean.setModelShoeOrderVec(model);
        orderVecBean.setPriceShoeOrderVec(removeLastChar(price));
        orderVecBean.setSizeOrderVec(sizeShoe);
        orderVecBean.setAddressOrderVec(addressShoe);
        orderVecBean.setCardIDOrderVec(cardIdShoe);
        orderVecBean.setCardDateOrderVec(cardDateShoe);
        orderVecBean.setCardCVCOrderVec(cardCVCShoe);

        IBuyShoeController buyShoeController = new BuyShoeController(this);
        buyShoeController.onConfirm(orderVecBean);

    }

    public void goBackMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        BuyUserCLIController buyUserCLIController = new BuyUserCLIController();

        switch (reference) {
            case 1 -> buyUserCLIController.nikeMethod();
            case 2 -> buyUserCLIController.adidasMethod();
            case 3 -> buyUserCLIController.newBalanceMethod();
            default -> error();
        }

    }

    public void buyMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        BuyUserCLIController buyUserCLIController = new BuyUserCLIController();
        buyUserCLIController.start();
    }

    public void sellMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        SellUserShoeCLIController sellUserShoeCLIController = new SellUserShoeCLIController();
        sellUserShoeCLIController.start();

    }

    public void profileMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }

    public static String removeLastChar(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }
}
