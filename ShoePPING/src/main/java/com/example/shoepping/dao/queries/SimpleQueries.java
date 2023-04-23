
package com.example.shoepping.dao.queries;


import com.example.shoepping.exception.DAOException;
import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.order.OrderList;

import java.sql.*;

public class SimpleQueries {

    private SimpleQueries() {
        throw new IllegalStateException("Utility class");
    }


    public static int selectUser(Connection conn, String username, String passd) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call login(?,?,?)}");
        cs.setString(1, username);
        cs.setString(2, passd);
        cs.registerOutParameter(3, Types.NUMERIC);
        cs.executeQuery();
        return cs.getInt(3);
    }

    public static void insertUser(Connection conn, String username, String passd, String email) throws DAOException {
        try {
            CallableStatement cs = conn.prepareCall("{call addNewUser(?, ?, ?)}");
            cs.setString(1, username);
            cs.setString(2, passd);
            cs.setString(3, email);

            cs.executeQuery();
        }catch (SQLException e){
            throw new DAOException("Failed insert: " + e.getMessage());
        }

    }

    public static int checkUserExistence(Connection conn, String username) throws SQLException {

        CallableStatement cs = conn.prepareCall("{call checkUserExistence(?, ?)}");
        cs.setString(1, username);
        cs.registerOutParameter(2, Types.NUMERIC);

        cs.executeQuery();
        return cs.getInt(2);
    }

    public static int isAdmin(Connection conn, String username, String passd) throws SQLException {

        CallableStatement cs = conn.prepareCall("{call isAdmin(?, ?, ?)}");
        cs.setString(1, username);
        cs.setString(2, passd);
        cs.registerOutParameter(3, Types.NUMERIC);

        cs.executeQuery();
        return cs.getInt(3);
    }

    public static String getEmailUser(Connection conn, String username) throws SQLException {
        CallableStatement cs = conn.prepareCall("{call getEmailUser(?, ?)}");
        cs.setString(1, username);
        cs.registerOutParameter(2, Types.VARCHAR);

        cs.executeQuery();
        return cs.getString(2);
    }

    public static void updateUser(Connection conn, String username, String passd, String email, String oldUsername) throws SQLException {

            CallableStatement cs = conn.prepareCall("{call updateUser(?, ?, ?, ?)}");
            cs.setString(1, username);
            cs.setString(2, passd);
            cs.setString(3, email);
            cs.setString(4, oldUsername);

            cs.executeQuery();
    }

    public static String getOrderList(Connection conn, String username, boolean check) throws SQLException {
        OrderList orderList = new OrderList();
        CallableStatement cs;

        if(check){
            cs = conn.prepareCall("{call getOrdersCSV(?)}");
        }else {
            cs = conn.prepareCall("{call getOrdersSQL(?)}");
        }
            cs.setString(1, username);

        boolean status = cs.execute();

        if(status){
            ResultSet rs = cs.getResultSet();
            while (rs.next()){
                Order order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7));
                orderList.addOrder(order);
            }
        }

        return orderList.toString();
    }

    public static String[] getNikePrice(Connection conn) throws SQLException {
        CallableStatement cs;

        cs = conn.prepareCall("{call getNikePrice()}");

        boolean status = cs.execute();

        return getListPrice(cs, status);
    }

    public static String[] getAdidasPrice(Connection conn) throws SQLException {
        CallableStatement cs;

        cs = conn.prepareCall("{call getAdidasPrice()}");

        boolean status = cs.execute();

        return getListPrice(cs, status);


    }

    public static String[] getNewBalancePrice(Connection conn) throws SQLException {
        CallableStatement cs;


        cs = conn.prepareCall("{call getNewBalancePrice()}");

        boolean status = cs.execute();

        return getListPrice(cs, status);
    }

    public static String[] getListPrice(CallableStatement cs, boolean status) throws SQLException {
        String[] lista = new String[6];
        int i = 0;
        if(status){
            ResultSet rs = cs.getResultSet();
            while (rs.next()){
                float price = rs.getFloat(1);
                lista[i] = String.valueOf(price);
                i++;
            }
        }
        return lista;
    }
}