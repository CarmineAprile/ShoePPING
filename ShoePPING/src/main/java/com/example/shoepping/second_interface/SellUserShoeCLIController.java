package com.example.shoepping.second_interface;

import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.pattern.adapter.Adapter;
import com.example.shoepping.use_case.sell_user_shoe.controller.ISellUserShoeController;
import com.example.shoepping.use_case.sell_user_shoe.controller.SellUserShoeController;
import com.example.shoepping.use_case.sell_user_shoe.view.ISellUserShoeView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class SellUserShoeCLIController implements ISellUserShoeView {
    public void start() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {

        System.out.println("********************************");
        System.out.println("*   ShoePPING Sell Shoe Page   *");
        System.out.println("********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Insert Sale");
        System.out.println("2) Manage Sales");
        System.out.println("3) Recommended Price");
        System.out.println("4) Buy");
        System.out.println("5) Profile");

        Scanner scannerSell = new Scanner(System.in);
        int chSell;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chSell = scannerSell.nextInt();
                if (chSell >= 1 && chSell <= 5) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerSell.nextLine();
            }
        }

        switch (chSell){
            case 1 -> saleMethod();
            case 2 -> manageMethod();
            case 3 -> recommendedMethod();
            case 4 -> buyMethod();
            case 5 -> profileMethod();

            default -> error();

        }

    }

    public void saleMethod() throws IOException, SQLException, ClassNotFoundException, CsvValidationException, ManageException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Brand: ");
        String brandSell = reader.readLine();
        System.out.print("Model:");
        String itemSell = reader.readLine();
        System.out.print("Price: ");
        String priceSell = reader.readLine();
        System.out.print("Condition (As new, Lightly used, Averagely used): ");
        String conditionSell = reader.readLine();
        System.out.print("Size: ");
        String sizeSell = reader.readLine();

        BrandBean brandBean = new BrandBean();
        ModelShoeBean modelShoeBean = new ModelShoeBean();
        PriceBean priceBean = new PriceBean();
        ConditionBean conditionBean = new ConditionBean();
        SizeShoeBean sizeShoeBean = new SizeShoeBean();

        brandBean.setBrand(brandSell);
        modelShoeBean.setModelShoe(itemSell);
        priceBean.setPrice(priceSell);
        conditionBean.setCondition(conditionSell);
        sizeShoeBean.setSizeShoe(sizeSell);

        ISellUserShoeController sellUserShoeController = new SellUserShoeController(this);
        sellUserShoeController.onInsertSale(brandBean, modelShoeBean, priceBean, conditionBean, sizeShoeBean);

    }
    public void manageMethod() {
        // TODO
    }
    public void recommendedMethod() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Price: ");
        String priceSell = reader.readLine();
        System.out.print("Condition (As new, Lightly used, Averagely used): ");
        String conditionSell = reader.readLine();

        if(!(conditionSell.equals("As new") || conditionSell.equals("Lightly used") || conditionSell.equals("Averagely used")) ){
            conditionSell = "Select condition";
        }

        PriceBean priceBean = new PriceBean();
        ConditionBean conditionBean = new ConditionBean();
        priceBean.setPrice(priceSell);
        conditionBean.setCondition(conditionSell);

        ISellUserShoeController sellUserShoeController = new SellUserShoeController(this);
        sellUserShoeController.onReccomendedPriceCalculate(priceBean, conditionBean);

    }
    public void buyMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        BuyUserCLIController buyUserCLIController = new BuyUserCLIController();
        buyUserCLIController.start();
    }
    public void profileMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }

    @Override
    public void onInsertSaleError(MessageBean message, CodeBean code) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println(message.getMessage());
        start();
    }

    @Override
    public void onInsertSaleSuccess() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        System.out.println("Item inserted successfully");
        buyMethod();
    }

    @Override
    public void onRecommendedPriceCalculateError(MessageBean message) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println(message.getMessage());
        start();
    }

    @Override
    public void onRecommendedPriceCalculateSuccess(PriceBean price, ConditionBean condition) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        Adapter adapter = new Adapter();
        // vedere se può chiamare direttamente il pattern o se è un model
        String recommendedPrice = String.valueOf(adapter.calculatePrice(price.getPrice(), condition.getCondition()));
        System.out.println("Recommended price: " + recommendedPrice);
        start();
    }
}
