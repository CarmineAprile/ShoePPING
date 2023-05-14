package com.example.shoepping.use_case.buy_user_used_shoe.controller;

import com.example.shoepping.ValidationCard;
import com.example.shoepping.dao.catalog_dao.CatalogDao;
import com.example.shoepping.dao.insert_order_dao.InsertOrderDao;
import com.example.shoepping.model.catalog.Catalog;
import com.example.shoepping.model.catalog.CatalogItem;
import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.user.User;
import com.example.shoepping.pattern.singleton.UserSingleton;
import com.example.shoepping.use_case.buy_user_used_shoe.view.IBuyUserUsedShoeView;

import java.io.IOException;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BuyUserUsedShoeController implements IBuyUserUsedShoeController{

    IBuyUserUsedShoeView buyUserUsedShoeView;

    public BuyUserUsedShoeController(IBuyUserUsedShoeView buyUserUsedShoeView){
        this.buyUserUsedShoeView = buyUserUsedShoeView;
    }

    @Override
    public String setLabels(String label) throws SQLException, IOException, ClassNotFoundException {

        CatalogDao catalogDao = new CatalogDao();

        Catalog catalog = catalogDao.getCatalog();

        String sellIDUpdate = null;

        StringBuilder sellID = new StringBuilder();
        for(int i = 6; i<label.length(); i++){
            if((label.charAt(i) != ',')){
                sellID.append(label.charAt(i));
            }else {
                sellIDUpdate = String.valueOf(sellID);
                break;
            }
        }


        for (CatalogItem catalogItem : catalog.getCatalog()){
            if(catalogItem.getShoeSale() == Integer.parseInt(sellID.toString())){
                buyUserUsedShoeView.onLabelsUpdate(catalogItem.getShoeSale(), catalogItem.getShoeBrand(), catalogItem.getShoeItem(), catalogItem.getShoePrice(), catalogItem.getShoeSize(), catalogItem.getShoeUsername(), catalogItem.getShoeCondition());
            }
        }

        return sellIDUpdate;
    }

    @Override
    public void onConfirm(String item, String brand, String price, String size, String seller, String[] userDataVec, String sellIDUpdate) throws SQLException, IOException, ClassNotFoundException {

        UserSingleton userSingleton = UserSingleton.getInstance();
        User user = userSingleton.getUser();
        boolean isChecked = userSingleton.isChecked();

        String conditionOrder = "used";
        String statusOrder = "payed";

        String dateOrder = ZonedDateTime.now(ZoneId.of("Europe/Rome")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Order order = new Order(dateOrder, item, Double.parseDouble(price), conditionOrder, userDataVec[0], statusOrder);

        int orderCode = order.isValid();

        boolean cardIDCode = ValidationCard.valCardID(userDataVec[1]);
        boolean cardDateCode = ValidationCard.valCardDate(userDataVec[2]);
        boolean cardCVCCode = ValidationCard.valCardCVC(userDataVec[3]);

        /*
        0 empty address
        1 invalid cardID
        2 invalid expiration cardDate
        3 invalid CVC
        */

        if(orderCode == 0){
            buyUserUsedShoeView.onConfirmError("Please enter an address", 0);
        }else if(!cardIDCode){
            buyUserUsedShoeView.onConfirmError("Please insert a valid card ID", 1);
        }else if(!cardDateCode){
            buyUserUsedShoeView.onConfirmError("Please insert a valid expiration card date", 2);
        }else if(!cardCVCCode){
            buyUserUsedShoeView.onConfirmError("Please insert a valid CVC", 3);
        }else{
            InsertOrderDao insertOrderDao = new InsertOrderDao();
            insertOrderDao.insertOrderCatalog(order, user, isChecked, sellIDUpdate);
            buyUserUsedShoeView.onConfirmSuccess();
        }


    }
}
