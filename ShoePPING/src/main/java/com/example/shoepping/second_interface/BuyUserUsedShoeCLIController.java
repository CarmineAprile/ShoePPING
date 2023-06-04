package com.example.shoepping.second_interface;

import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.buy_user_used_shoe.controller.BuyUserUsedShoeController;
import com.example.shoepping.use_case.buy_user_used_shoe.controller.IBuyUserUsedShoeController;
import com.example.shoepping.use_case.buy_user_used_shoe.view.IBuyUserUsedShoeView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class BuyUserUsedShoeCLIController implements IBuyUserUsedShoeView {
    String sellIDUpdate;

    IdBean shoeSaleB;
    BrandBean shoeBrandB;
    ModelShoeBean shoeItemB;
    PriceBean shoePriceB;
    SizeShoeBean shoeSizeB;
    SellerBean shoeUsernameB;
    ConditionBean shoeConditionB;

    public void start(String element) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        System.out.println("************************************");
        System.out.println("*   ShoePPING Buy Used Shoe Page   *");
        System.out.println("************************************\n");
        IBuyUserUsedShoeController buyUserUsedShoeController = new BuyUserUsedShoeController(this);

        LabelBean labelBean = new LabelBean();
        labelBean.setLabel(element);
        sellIDUpdate = buyUserUsedShoeController.setLabels(labelBean);

        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Confirm");
        System.out.println("2) Go Back");
        System.out.println("3) Buy Menu");
        System.out.println("4) Sell");
        System.out.println("5) Profile");

        Scanner scannerUsed = new Scanner(System.in);
        int chUsed;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chUsed = scannerUsed.nextInt();
                if (chUsed >= 1 && chUsed <= 5) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerUsed.nextLine();
            }

        }

        switch (chUsed){
            case 1 -> confirmMethod();
            case 2 -> goBackMethod();
            case 3 -> buyMethod();
            case 4 -> sellMethod();
            case 5 -> profileMethod();

            default -> error();

        }
    }

    public void confirmMethod() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Shipping address: ");
        String addressBuy = reader.readLine();
        System.out.print("Card ID: ");
        String cardIdBuy = reader.readLine();
        System.out.print("Card Date: ");
        String cardDateBuy = reader.readLine();
        System.out.print("Card CVC: ");
        String cardCVCBuy = reader.readLine();

        UserVecBean userVecBean = new UserVecBean();
        userVecBean.setAddressUserVec(addressBuy);
        userVecBean.setCardIDUserVec(cardIdBuy);
        userVecBean.setCardDateUserVec(cardDateBuy);
        userVecBean.setCardCVCUserVec(cardCVCBuy);
        userVecBean.setConditionUserVec(shoeConditionB.getCondition());

        SellIdUpdateBean sellIdUpdateBean = new SellIdUpdateBean();
        sellIdUpdateBean.setSellIdUpdate(shoeSaleB.getId());

        IBuyUserUsedShoeController buyUserUsedShoeController = new BuyUserUsedShoeController(this);
        buyUserUsedShoeController.onConfirm(shoeItemB, shoeBrandB, shoePriceB, shoeSizeB, shoeUsernameB, userVecBean, sellIdUpdateBean);

    }
    public void goBackMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        BuyCatalogCLIController buyCatalogCLIController = new BuyCatalogCLIController();
        buyCatalogCLIController.start();
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
    public void onLabelsUpdate(IdBean shoeSale, BrandBean shoeBrand, ModelShoeBean shoeItem, PriceBean shoePrice, SizeShoeBean shoeSize, SellerBean shoeUsername, ConditionBean shoeCondition) {
        System.out.println("Model: " + shoeItem.getModelShoe());
        System.out.println("Brand: " + shoeBrand.getBrand());
        System.out.println("Price: " + shoePrice.getPrice() + '$');
        System.out.println("Size: " + shoeSize.getSizeShoe());
        System.out.println("Condition: " + shoeCondition.getCondition());
        System.out.println("Seller: " + shoeUsername.getSeller());

        shoeSaleB = shoeSale;
        shoeBrandB = shoeBrand;
        shoeItemB = shoeItem;
        shoePriceB = shoePrice;
        shoeSizeB = shoeSize;
        shoeUsernameB = shoeUsername;
        shoeConditionB = shoeCondition;
    }

    @Override
    public void onConfirmError(MessageBean message, CodeBean code) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println(message.getMessage());
        goBackMethod();
    }

    @Override
    public void onConfirmSuccess() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        System.out.println("Order received successfully");
        buyMethod();
    }
}
