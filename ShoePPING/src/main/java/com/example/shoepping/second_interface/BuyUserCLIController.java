package com.example.shoepping.second_interface;

import com.example.shoepping.exception.ManageException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class BuyUserCLIController {
    public void start() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println("*********************************");
        System.out.println("*      ShoePPING Menu Page     *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Nike Menu");
        System.out.println("2) Adidas Menu");
        System.out.println("3) New Balance Menu");
        System.out.println("4) Profile");
        System.out.println("5) Sell");
        System.out.println("6) Catalog");

        Scanner scannerBuy = new Scanner(System.in);
        int chBuy;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chBuy = scannerBuy.nextInt();
                if (chBuy >= 1 && chBuy <= 6) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerBuy.nextLine();
            }

        }

        switch (chBuy){
            case 1 -> NikeMethod();
            case 2 -> AdidasMethod();
            case 3 -> NewBalanceMethod();
            case 4 -> ProfileMethod();
            case 5 -> SellMethod();
            case 6 -> CatalogMethod();
            default -> error();

        }
    }

    public void NikeMethod(){
        //TODO
    }

    public void AdidasMethod(){
        //TODO
    }

    public void NewBalanceMethod(){
        //TODO
    }

    public void ProfileMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }

    public void SellMethod(){
        SellUserShoeCLIController sellUserShoeCLIController = new SellUserShoeCLIController();
        sellUserShoeCLIController.start();

    }

    public void CatalogMethod(){
        BuyCatalogCLIController buyCatalogCLIController = new BuyCatalogCLIController();
        buyCatalogCLIController.start();
    }
}
