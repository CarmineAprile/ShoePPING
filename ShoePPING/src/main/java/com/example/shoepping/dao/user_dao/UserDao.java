package com.example.shoepping.dao.user_dao;

import com.example.shoepping.exception.ManageException;
import com.example.shoepping.model.user.User;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface UserDao {

    // aggiungere gestione personalizzata dell'eccezione
    boolean checkLogin(User instance) throws SQLException, ClassNotFoundException, IOException, CsvValidationException;
    //Return true se l'utente ha inserito correttamente username e password
    
    boolean checkExistence(User instance) throws ClassNotFoundException, SQLException, IOException, CsvValidationException;

    void addUser(User instance) throws ClassNotFoundException, SQLException, IOException, ManageException;

    void updateUser(User instance, String oldUsername) throws SQLException, IOException, ClassNotFoundException;

    String getEmail(User instance) throws SQLException, IOException, ClassNotFoundException, CsvValidationException;

    boolean isAdmin(User instance) throws SQLException, IOException, ClassNotFoundException;


}
