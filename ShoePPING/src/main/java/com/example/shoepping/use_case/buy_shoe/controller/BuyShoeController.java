package com.example.shoepping.use_case.buy_shoe.controller;

import com.example.shoepping.ValidationCard;
import com.example.shoepping.dao.insert_order_dao.InsertOrderDao;
import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.user.User;
import com.example.shoepping.pattern.observer.ShoeSizeList;
import com.example.shoepping.pattern.observer.SizeButton;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;

import java.io.IOException;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BuyShoeController implements IBuyShoeController{

    IBuyShoeView buyShoeView;

    public BuyShoeController(IBuyShoeView buyShoeView) {
        this.buyShoeView = buyShoeView;
    }

    @Override
    public void onUpdate(ShoeSizeList shoeSizeList) {
        int i = 37;
        for (SizeButton button : shoeSizeList.buttons) {
            if(!button.getIsAvailable()){
                buyShoeView.onDisable(i);
            }
            i++;
        }
    }

    public void onConfirm(User user, boolean isChecked, String[] orderVec) throws SQLException, IOException, ClassNotFoundException {

        String conditionOrder = "new";
        String statusOrder = "payed";

        String dateOrder = ZonedDateTime.now(ZoneId.of("Europe/Rome")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Order order = new Order(dateOrder, orderVec[0], Double.parseDouble(orderVec[1]), conditionOrder, orderVec[3], statusOrder);
        int orderCode = order.isValid();

        boolean cardIDCode = ValidationCard.valCardID(orderVec[4]);
        boolean cardDateCode = ValidationCard.valCardDate(orderVec[5]);
        boolean cardCVCCode = ValidationCard.valCardCVC(orderVec[6]);

        /*
        0 not selected size
        1 empty address
        2 invalid cardID
        3 invalid expiration cardDate
        4 invalid CVC
         */

        if(orderVec[2].equals("Select size")){
            buyShoeView.onConfirmError("Please select a size", 0);
        }else if(orderCode == 0){
            buyShoeView.onConfirmError("Please enter an address", 1);
        }else if(!cardIDCode){
            buyShoeView.onConfirmError("Please insert a valid card ID", 2);
        }else if(!cardDateCode){
            buyShoeView.onConfirmError("Please insert a valid expiration card date", 3);
        }else if(!cardCVCCode){
            buyShoeView.onConfirmError("Please insert a valid CVC", 4);
        }else{
            InsertOrderDao insertOrderDao = new InsertOrderDao();
            insertOrderDao.insertOrder(order, user, Integer.parseInt(orderVec[2]), isChecked);
            buyShoeView.onConfirmSuccess();
        }

    }




}
