package com.example.shoepping.second_interface;

import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.administrator.controller.AdministratorController;
import com.example.shoepping.use_case.administrator.controller.IAdministratorController;
import com.example.shoepping.use_case.administrator.view.IAdministratorView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class AdministratorCLIController implements IAdministratorView {
    public void start() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println("*********************************");
        System.out.println("*      ShoePPING Admin Page     *");
        System.out.println("*********************************\n");

        IAdministratorController administratorController = new AdministratorController(this);
        System.out.println(administratorController.getReport());

        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Add amount");
        System.out.println("2) Update price");
        System.out.println("3) Manage sales");
        System.out.println("4) Exit");

        Scanner scannerAdmin = new Scanner(System.in);
        int chAdm;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chAdm = scannerAdmin.nextInt();
                if (chAdm >= 1 && chAdm <= 4) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerAdmin.nextLine();
            }

        }

        switch (chAdm){
            case 1 -> amountMethod();
            case 2 -> priceMethod();
            case 3 -> manageMethod();
            case 4 -> exitMethod();
            default -> error();

        }
    }

    public void exitMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        LoginCLIController loginCLIController = new LoginCLIController();
        loginCLIController.start();
    }

    public void manageMethod() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        ManageSalesAdminCLIController manageSalesAdminCLIController = new ManageSalesAdminCLIController();
        manageSalesAdminCLIController.start();
    }

    public void priceMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("ID: ");
        String idAdmin = reader.readLine();
        System.out.print("Price: ");
        String priceAdmin = reader.readLine();

        IdBean idBean = new IdBean();
        PriceBean priceBean = new PriceBean();

        idBean.setId(idAdmin);
        priceBean.setPrice(priceAdmin);

        IAdministratorController administratorController = new AdministratorController(this);
        administratorController.onUpdatePrice(idBean, priceBean);
    }

    public void amountMethod() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("ID: ");
        String idAdmin = reader.readLine();
        System.out.print("Amount: ");
        String amountAdmin = reader.readLine();
        System.out.print("Size: ");
        String sizeAdmin = reader.readLine();

        IdBean idBean = new IdBean();
        AmountBean amountBean = new AmountBean();
        SizeShoeBean sizeShoeBean = new SizeShoeBean();

        idBean.setId(idAdmin);
        amountBean.setAmount(amountAdmin);
        sizeShoeBean.setSizeShoe(sizeAdmin);

        IAdministratorController administratorController = new AdministratorController(this);
        administratorController.onUpdateAmount(idBean, amountBean, sizeShoeBean);
    }


    @Override
    public void onUpdateAmountError(MessageBean message, CodeBean errorCode) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println(message.getMessage());
        start();
    }

    @Override
    public void onUpdateAmountSuccess() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        System.out.println("Amount updated successfully!");
        start();
    }

    @Override
    public void onUpdatePriceError(MessageBean message, CodeBean errorCode) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println(message.getMessage());
        start();
    }

    @Override
    public void onUpdatePriceSuccess() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        System.out.println("Price updated successfully!");
        start();
    }
}
