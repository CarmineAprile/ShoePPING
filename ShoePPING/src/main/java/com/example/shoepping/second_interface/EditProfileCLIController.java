package com.example.shoepping.second_interface;

import com.example.shoepping.bean.*;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.use_case.edit_profile.controller.EditProfileController;
import com.example.shoepping.use_case.edit_profile.controller.IEditProfileController;
import com.example.shoepping.use_case.edit_profile.view.IEditProfileView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public void editMethod() throws IOException, CsvValidationException, SQLException, ClassNotFoundException, ManageException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Username: ");
        String usernameEdit = reader.readLine();
        System.out.print("Password: ");
        String passEdit = reader.readLine();
        System.out.print("Confirm Password: ");
        String repassEdit = reader.readLine();
        System.out.print("Email: ");
        String emailEdit = reader.readLine();

        UsernameBean usernameBean = new UsernameBean();
        PasswordBean passwordBean = new PasswordBean();
        PasswordBean repasswordBean = new PasswordBean();
        EmailBean emailBean = new EmailBean();

        usernameBean.setUsername(usernameEdit);
        passwordBean.setPassword(passEdit);
        repasswordBean.setPassword(repassEdit);
        emailBean.setEmail(emailEdit);

        IEditProfileController editProfileController = new EditProfileController(this);
        editProfileController.onEditProfile(usernameBean,passwordBean,repasswordBean,emailBean);

    }

    public void goBackMethod() throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        ProfileCLIController profileCLIController = new ProfileCLIController();
        profileCLIController.start();
    }

    @Override
    public void onEditProfileSuccess(CheckedBean checkedBean, UserBean userNew) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        if(checkedBean.getChecked()){
            System.out.println("Work in progress...");
        }else {
            IEditProfileController editProfileController = new EditProfileController(this);
            editProfileController.setNewUser(userNew);
        }
        goBackMethod();
    }

    @Override
    public void onEditProfileError(MessageBean messageBean, CodeBean codeBean) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        System.out.println(messageBean.getMessage());
        start();
    }
}
