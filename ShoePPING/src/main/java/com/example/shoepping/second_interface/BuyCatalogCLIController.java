package com.example.shoepping.second_interface;

import com.example.shoepping.bean.ModelShoeBean;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.buy_catalog.controller.BuyCatalogController;
import com.example.shoepping.use_case.buy_catalog.controller.IBuyCatalogController;
import com.example.shoepping.use_case.buy_catalog.view.IBuyCatalogView;
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

public class BuyCatalogCLIController implements IBuyCatalogView {

    List<String> modelShoeBeanList = new ArrayList<>();

    public void start() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        System.out.println("******************************");
        System.out.println("*   ShoePPING Catalog Page   *");
        System.out.println("******************************\n");

        IBuyCatalogController buyCatalogController = new BuyCatalogController(this);
        buyCatalogController.getCatalog();

        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Select Sale ID");
        System.out.println("2) Select Filter");
        System.out.println("3) Buy");
        System.out.println("4) Sell");
        System.out.println("5) Profile");

        Scanner scannerManage = new Scanner(System.in);
        int chManage;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chManage = scannerManage.nextInt();
                if (chManage >= 1 && chManage <= 5) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerManage.nextLine();
            }
        }

        switch (chManage){
            case 1 -> selectMethod();
            case 2 -> filterMethod();
            case 3 -> buyMethod();
            case 4 -> sellMethod();
            case 5 -> profileMethod();

            default -> error();

        }
    }

    public void selectMethod() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Insert Sale ID: ");
        String idSale = reader.readLine();

        BuyUserUsedShoeCLIController buyUserUsedShoeCLIController = new BuyUserUsedShoeCLIController();


        for (String element : modelShoeBeanList){
            String sellIDUpdate = null;
            StringBuilder sellID = new StringBuilder();
            for(int i = 6; i<element.length(); i++){
                if((element.charAt(i) != ',')){
                    sellID.append(element.charAt(i));
                }else {
                    sellIDUpdate = String.valueOf(sellID);
                    break;
                }
            }
            if(idSale.equals(sellIDUpdate)){
                buyUserUsedShoeCLIController.start(element);
            }
        }
    }
    public void filterMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        onApplyFilterError();
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

    @Override
    public void setShoeLabel(ModelShoeBean modelShoeBean) {
        System.out.println(modelShoeBean.getModelShoe());
        modelShoeBeanList.add(modelShoeBean.getModelShoe());
    }

    @Override
    public void onApplyFilterError() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println("Not available yet for this interface!");
        start();
    }
}
