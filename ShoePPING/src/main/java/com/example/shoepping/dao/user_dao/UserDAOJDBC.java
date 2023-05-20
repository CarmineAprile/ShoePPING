package com.example.shoepping.dao.user_dao;

import com.example.shoepping.dao.DaoUtility;
import com.example.shoepping.dao.queries.SimpleQueries;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.model.user.User;

import java.io.IOException;
import java.sql.*;


public class UserDAOJDBC implements UserDao {

    @Override
    public boolean checkLogin(User instance) throws SQLException, ClassNotFoundException, IOException {

        int rs;
        Connection conn = DaoUtility.prepareQuery();

        // In pratica i risultati delle query possono essere visti come un Array Associativo o un Map
        rs = SimpleQueries.selectUser(conn, instance.getUsername(), instance.getPassword());

        return rs == 1;
    }

    @Override
    public boolean checkExistence(User instance) throws ClassNotFoundException, SQLException, IOException {
        int rs;
        Connection conn = DaoUtility.prepareQuery();

        // In pratica i risultati delle query possono essere visti come un Array Associativo o un Map
        rs = SimpleQueries.checkUserExistence(conn, instance.getUsername());

        return rs == 1;
    }

    @Override
    public void addUser(User instance) throws ClassNotFoundException, SQLException, IOException, ManageException {

        Connection conn = DaoUtility.prepareQuery();

        // In pratica i risultati delle query possono essere visti come un Array Associativo o un Map
        SimpleQueries.insertUser(conn, instance.getUsername(), instance.getPassword(), instance.getEmail());
    }

    @Override
    public void updateUser(User instance, String oldUsername) throws SQLException, IOException, ClassNotFoundException{
        Connection conn = DaoUtility.prepareQuery();

        SimpleQueries.updateUser(conn, instance.getUsername(), instance.getPassword(), instance.getEmail(), oldUsername);
    }

    @Override
    public String getEmail(User instance) throws SQLException, IOException, ClassNotFoundException {

        Connection conn = DaoUtility.prepareQuery();

        return SimpleQueries.getEmailUser(conn, instance.getUsername());
    }

    @Override
    public boolean isAdmin(User instance) throws SQLException, IOException, ClassNotFoundException {

        int rs;

        Connection conn = DaoUtility.prepareQuery();
        rs = SimpleQueries.isAdmin(conn, instance.getUsername(), instance.getPassword());

        return rs == 1;
    }
}