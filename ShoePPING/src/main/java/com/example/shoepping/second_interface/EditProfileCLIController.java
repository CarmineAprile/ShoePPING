package com.example.shoepping.second_interface;

import com.example.shoepping.bean.CheckedBean;
import com.example.shoepping.bean.CodeBean;
import com.example.shoepping.bean.MessageBean;
import com.example.shoepping.bean.UserBean;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.edit_profile.view.IEditProfileView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Log.error;

public class EditProfileCLIController implements IEditProfileView {
    public void start() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {

        System.out.println("****************************************");
        System.out.println("*      ShoePPING Edit Profile Page     *");
        System.out.println("****************************************\n");
        System.out.println("****** What should I do for you? *******\n");
        System.out.println("1) Update Data");
        System.out.println("2) Go Back");


        Scanner scannerEd = new Scanner(System.in);
        int chEd;
        while (true) {
            System.out.print("Please enter your choice: ");
            try {
                chEd = scannerEd.nextInt();
                if (chEd >= 1 && chEd <= 2) {
                    break;
                }
                System.out.println("Invalid option");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option: please insert an integer");
                scannerEd.nextLine();
            }

        }

        switch (chEd){
            case 1 -> editMethod();
            case 2 -> goBackMethod();
            default -> error();

        }
    }

    public void editMethod(){

    }

    public void goBackMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }

    @Override
    public void onEditProfileSuccess(CheckedBean checkedBean, UserBean userNew) {

    }

    @Override
    public void onEditProfileError(MessageBean messageBean, CodeBean codeBean) {

    }
}
