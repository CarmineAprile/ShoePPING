package com.example.shoepping.second_interface;

import com.example.shoepping.bean.ItemDataBean;
import com.example.shoepping.bean.SaleBean;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.manage_sale_admin.controller.IManageSaleAdminController;
import com.example.shoepping.use_case.manage_sale_admin.controller.ManageSaleAdminController;
import com.example.shoepping.use_case.manage_sale_admin.view.IManageSaleAdminView;
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

public class ManageSalesAdminCLIController implements IManageSaleAdminView {

    List<List<String>> itemDataBeanList = new ArrayList<>();

    public void start() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {

        System.out.println("***********************************");
        System.out.println("*   ShoePPING Admin Manage Page   *");
        System.out.println("***********************************\n");

        IManageSaleAdminController manageSaleAdminController = new ManageSaleAdminController(this);
        manageSaleAdminController.getSales();

        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Confirm Sale");
        System.out.println("2) Refuse Sale");
        System.out.println("3) Go Back");
        System.out.println("4) Exit");

        Scanner scannerManAd = new Scanner(System.in);
        int chManAd;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chManAd = scannerManAd.nextInt();
                if (chManAd >= 1 && chManAd <= 4) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerManAd.nextLine();
            }
        }

        switch (chManAd){
            case 1 -> confirmMethod();
            case 2 -> refuseMethod();
            case 3 -> goBackMethod();
            case 4 -> exitMethod();
            default -> error();

        }
    }

    public void goBackMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        AdministratorCLIController administratorCLIController = new AdministratorCLIController();
        administratorCLIController.start();
    }

    public void refuseMethod() throws IOException, ManageException, CsvValidationException, SQLException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Insert Sale ID: ");
        String idSale = reader.readLine();

        IManageSaleAdminController manageSaleAdminController = new ManageSaleAdminController(this);

        for (List<String> element : itemDataBeanList){
            if(element.get(0).equals(idSale)){
                try {
                    ItemDataBean itemDataBean = new ItemDataBean();
                    itemDataBean.setItemData(element);

                    manageSaleAdminController.onRefuseOrder(itemDataBean);
                } catch (SQLException | IOException | ClassNotFoundException e) {
                    throw new ManageException("Error: " + e);
                }
            }
        }
        start();
    }

    public void confirmMethod() throws IOException, ManageException, CsvValidationException, SQLException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Insert Sale ID: ");
        String idSale = reader.readLine();

        IManageSaleAdminController manageSaleAdminController = new ManageSaleAdminController(this);

        for (List<String> element : itemDataBeanList){
            if(element.get(0).equals(idSale)){
                try {
                    ItemDataBean itemDataBean = new ItemDataBean();
                    itemDataBean.setItemData(element);

                    manageSaleAdminController.onConfirmOrder(itemDataBean);
                } catch (SQLException | IOException | ClassNotFoundException e) {
                    throw new ManageException("Error: " + e);
                }
            }
        }
        start();
    }

    @Override
    public void setSaleButton(SaleBean s, ItemDataBean itemData) {
        System.out.println(s.getSale());
        itemDataBeanList.add(itemData.getItemData());
    }

    public void exitMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        LoginCLIController loginCLIController = new LoginCLIController();
        loginCLIController.start();
    }
}
