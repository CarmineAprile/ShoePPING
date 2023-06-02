package com.example.shoepping.second_interface;

import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;
import com.example.shoepping.bean.ModelShoeBean;
import com.example.shoepping.bean.SizeShoeBean;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.buy_shoe.controller.BuyShoeController;
import com.example.shoepping.use_case.buy_shoe.controller.IBuyShoeController;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class BuyShoeCLIController implements IBuyShoeView {

    int reference;

    public void start(String model, String price, int reference) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        this.reference = reference;

        IBuyShoeController buyShoeController = new BuyShoeController(this);

        ModelShoeBean modelShoeBean = new ModelShoeBean();
        modelShoeBean.setModelShoe(model);

        buyShoeController.getSizeAmountList(modelShoeBean);

        System.out.println(model);
        System.out.println(price);

        System.out.println("*********************************");
        System.out.println("*     ShoePPING Buy Shoe Page   *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Confirm");
        System.out.println("2) Go Back");
        System.out.println("3) Buy");
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
            case 1 -> confirmMethod();
            case 2 -> goBackMethod();
            case 3 -> buyMethod();
            case 4 -> sellMethod();
            case 5 -> profileMethod();

            default -> error();

        }
    }

    @Override
    public void onDisable(SizeShoeBean i) {

    }

    @Override
    public void onConfirmSuccess() throws IOException {

    }

    @Override
    public void onConfirmError(MessageBean message, CodeBean code) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {

    }

    public void confirmMethod(){

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

    public void sellMethod(){
        SellUserShoeCLIController sellUserShoeCLIController = new SellUserShoeCLIController();
        sellUserShoeCLIController.start();

    }

    public void profileMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }
}
