package com.example.shoepping.second_interface;

import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class BuyUserAdidasCLIController {
    public void start(String[] lista) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {

        System.out.println("1) Gazelle: " + lista[0] + '$');
        System.out.println("2) Stan Smith: " + lista[1] + '$');
        System.out.println("3) Yeezy Boost 350: " + lista[2] + '$');
        System.out.println("4) EQT Flurro Yellow: " + lista[3] + '$');
        System.out.println("5) Superstar: " + lista[4] + '$');

        System.out.println("*********************************");
        System.out.println("*     ShoePPING Adidas Page     *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Select N.1 Shoe");
        System.out.println("2) Select N.2 Shoe");
        System.out.println("3) Select N.3 Shoe");
        System.out.println("4) Select N.4 Shoe");
        System.out.println("5) Select N.5 Shoe");
        System.out.println("6) Go back");
        System.out.println("7) Sell");
        System.out.println("8) Profile");

        Scanner scannerAdidas = new Scanner(System.in);
        int chAdidas;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chAdidas = scannerAdidas.nextInt();
                if (chAdidas >= 1 && chAdidas <= 8) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerAdidas.nextLine();
            }

        }

        switch (chAdidas){
            case 1 -> shoe1Method(lista);
            case 2 -> shoe2Method(lista);
            case 3 -> shoe3Method(lista);
            case 4 -> shoe4Method(lista);
            case 5 -> shoe5Method(lista);
            case 6 -> goBackMethod();
            case 7 -> sellMethod();
            case 8 -> profileMethod();
            default -> error();

        }
    }

    public void shoe1Method(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("Gazelle", lista[0] + '$', 2);
    }

    public void shoe2Method(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("Stan Smith", lista[1] + '$', 2);
    }

    public void shoe3Method(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("Yeezy Boost 350", lista[2] + '$', 2);
    }

    public void shoe4Method(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("EQT Flurro Yellow", lista[3] + '$', 2);
    }

    public void shoe5Method(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("Superstar", lista[4] + '$', 2);
    }

    public void goBackMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
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
