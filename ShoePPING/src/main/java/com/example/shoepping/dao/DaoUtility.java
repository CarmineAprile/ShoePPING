package com.example.shoepping.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DaoUtility {

    private DaoUtility() {
        throw new IllegalStateException("Utility class");
    }
    public static Connection prepareQuery() throws SQLException, ClassNotFoundException, IOException {

        // STEP 1: dichiarazioni
        Connection conn;

        //get connection data
        String url;
        String pass;
        String user;
        String driverClassName;

        try (InputStream input = new FileInputStream("config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            url = prop.getProperty("dburl");
            pass = prop.getProperty("dbpassword");
            user = prop.getProperty("dbuser");
            driverClassName = prop.getProperty("dbdriver");

        } catch (IOException ex) {
            throw new IOException(ex);
        }

        // STEP 2: loading dinamico del driver mysql
        Class.forName(driverClassName);

        // STEP 3: apertura connessione
        conn = DriverManager.getConnection(url, user, pass);

        return conn;
    }
}
