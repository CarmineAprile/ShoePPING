package com.example.shoepping.second_interface;

import com.example.shoepping.bean.ItemDataBean;
import com.example.shoepping.bean.SaleBean;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.manage_sale.controller.IManageSaleController;
import com.example.shoepping.use_case.manage_sale.controller.ManageSaleController;
import com.example.shoepping.use_case.manage_sale.view.IManageSaleView;
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

public class ManageSaleCLIController implements IManageSaleView {

    List<List<String>> itemDataBeanList = new ArrayList<>();

    public void start() throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {
        System.out.println("**********************************");
        System.out.println("*   ShoePPING Sale Manage Page   *");
        System.out.println("**********************************\n");

        IManageSaleController manageSaleController = new ManageSaleController(this);
        manageSaleController.getSales();

        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) Confirm Sale");
        System.out.println("2) Refuse Sale");
        System.out.println("3) Buy");
        System.out.println("4) Sell");
        System.out.println("5) Go Back");
        System.out.println("6) Profile");

        Scanner scannerManage = new Scanner(System.in);
        int chManage;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chManage = scannerManage.nextInt();
                if (chManage >= 1 && chManage <= 6) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerManage.nextLine();
            }
        }

        switch (chManage){
            case 1 -> confirmMethod();
            case 2 -> refuseMethod();
            case 3 -> buyMethod();
            case 4 -> sellMethod();
            case 5 -> goBackMethod();
            case 6 -> profileMethod();

            default -> error();

        }
    }

    public void confirmMethod() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Insert Sale ID: ");
        String idSale = reader.readLine();

        IManageSaleController manageSaleController = new ManageSaleController(this);

        for (List<String> element : itemDataBeanList){
            if(element.get(0).equals(idSale)){
                try {
                    ItemDataBean itemDataBean = new ItemDataBean();
                    itemDataBean.setItemData(element);

                    manageSaleController.onConfirmSale(itemDataBean);
                } catch (SQLException | IOException | ClassNotFoundException e) {
                    throw new ManageException("Error: " + e);
                }
            }
        }
        start();
    }

    public void refuseMethod() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Insert Sale ID: ");
        String idSale = reader.readLine();

        IManageSaleController manageSaleController = new ManageSaleController(this);

        for (List<String> element : itemDataBeanList){
            if(element.get(0).equals(idSale)){
                try {
                    ItemDataBean itemDataBean = new ItemDataBean();
                    itemDataBean.setItemData(element);

                    manageSaleController.onRefuseSale(itemDataBean);
                } catch (SQLException | IOException | ClassNotFoundException e) {
                    throw new ManageException("Error: " + e);
                }
            }
        }
        start();
    }
    public void buyMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        BuyUserCLIController buyUserCLIController = new BuyUserCLIController();
        buyUserCLIController.start();
    }
    public void sellMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        SellUserShoeCLIController sellUserShoeCLIController = new SellUserShoeCLIController();
        sellUserShoeCLIController.start();
    }
    public void goBackMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        sellMethod();
    }
    public void profileMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }

    @Override
    public void setNotAvailableCSV() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println("Not available yet!");
        buyMethod();
    }

    @Override
    public void setSaleButton(SaleBean saleBean, ItemDataBean itemDataBean) {
        System.out.println(saleBean.getSale());
        itemDataBeanList.add(itemDataBean.getItemData());
    }
}
