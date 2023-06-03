package com.example.shoepping.second_interface;

import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class BuyUserNikeCLIController {
    public void start(String[] lista) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println("1) Air Max 97: " + lista[0] + '$');
        System.out.println("2) Air Jordan 1 Mid: " + lista[1] + '$');
        System.out.println("3) Air Max 2017: " + lista[2] + '$');
        System.out.println("4) Air Max 90: " + lista[3] + '$');
        System.out.println("5) Air Huarache: " + lista[4] + '$');
        System.out.println("6) Air Max 94: " + lista[5] + '$');

        System.out.println("*********************************");
        System.out.println("*      ShoePPING Nike Page     *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Select N.1 Shoe");
        System.out.println("2) Select N.2 Shoe");
        System.out.println("3) Select N.3 Shoe");
        System.out.println("4) Select N.4 Shoe");
        System.out.println("5) Select N.5 Shoe");
        System.out.println("6) Select N.6 Shoe");
        System.out.println("7) Go back");
        System.out.println("8) Sell");
        System.out.println("9) Profile");

        Scanner scannerNike = new Scanner(System.in);
        int chNike;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chNike = scannerNike.nextInt();
                if (chNike >= 1 && chNike <= 9) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerNike.nextLine();
            }

        }

        switch (chNike){
            case 1 -> shoe1NikeMethod(lista);
            case 2 -> shoe2NikeMethod(lista);
            case 3 -> shoe3NikeMethod(lista);
            case 4 -> shoe4NikeMethod(lista);
            case 5 -> shoe5NikeMethod(lista);
            case 6 -> shoe6NikeMethod(lista);
            case 7 -> goBackNikeMethod();
            case 8 -> sellNikeMethod();
            case 9 -> profileNikeMethod();
            default -> error();

        }
    }

    public void shoe1NikeMethod(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("Air Max 97", lista[0] + '$', 1);
    }

    public void shoe2NikeMethod(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("Air Jordan 1 Mid", lista[1] + '$', 1);
    }

    public void shoe3NikeMethod(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("Air Max 2017", lista[2] + '$', 1);
    }

    public void shoe4NikeMethod(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("Air Max 90", lista[3] + '$', 1);
    }

    public void shoe5NikeMethod(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("Air Huarache", lista[4] + '$', 1);
    }

    public void shoe6NikeMethod(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("Air Max 94", lista[5] + '$', 1);
    }

    public void goBackNikeMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        BuyUserCLIController buyUserCLIController = new BuyUserCLIController();
        buyUserCLIController.start();
    }

    public void sellNikeMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        SellUserShoeCLIController sellUserShoeCLIController = new SellUserShoeCLIController();
        sellUserShoeCLIController.start();

    }

    public void profileNikeMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }
}
