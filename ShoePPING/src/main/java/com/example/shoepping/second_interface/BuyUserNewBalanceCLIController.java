package com.example.shoepping.second_interface;

import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class BuyUserNewBalanceCLIController {
    public void start(String[] lista) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {

        System.out.println("1) 327 Moonbeam: " + lista[0] + '$');
        System.out.println("2) X-Racer Bodega: " + lista[1] + '$');
        System.out.println("3) Shando: " + lista[2] + '$');
        System.out.println("4) 530: " + lista[3] + '$');
        System.out.println("5) 550 White-Red: " + lista[4] + '$');

        System.out.println("*********************************");
        System.out.println("*   ShoePPING New Balance Page  *");
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

        Scanner scannerNB = new Scanner(System.in);
        int chNB;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chNB = scannerNB.nextInt();
                if (chNB >= 1 && chNB <= 8) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerNB.nextLine();
            }

        }

        switch (chNB){
            case 1 -> shoe1NBMethod(lista);
            case 2 -> shoe2NBMethod(lista);
            case 3 -> shoe3NBMethod(lista);
            case 4 -> shoe4NBMethod(lista);
            case 5 -> shoe5NBMethod(lista);
            case 6 -> goBackNBMethod();
            case 7 -> sellNBMethod();
            case 8 -> profileNBMethod();
            default -> error();

        }
    }

    public void shoe1NBMethod(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("327 Moonbeam", lista[0] + '$', 3);
    }

    public void shoe2NBMethod(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("X-Racer Bodega", lista[1] + '$', 3);
    }

    public void shoe3NBMethod(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("Shando", lista[2] + '$', 3);
    }

    public void shoe4NBMethod(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("530", lista[3] + '$', 3);
    }

    public void shoe5NBMethod(String[] lista) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        BuyShoeCLIController buyShoeCLIController = new BuyShoeCLIController();
        buyShoeCLIController.start("550 White-Red", lista[4] + '$', 3);
    }

    public void goBackNBMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        BuyUserCLIController buyUserCLIController = new BuyUserCLIController();
        buyUserCLIController.start();
    }

    public void sellNBMethod(){
        SellUserShoeCLIController sellUserShoeCLIController = new SellUserShoeCLIController();
        sellUserShoeCLIController.start();

    }

    public void profileNBMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }
}
