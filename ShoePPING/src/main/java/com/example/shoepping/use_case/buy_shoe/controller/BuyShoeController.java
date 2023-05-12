package com.example.shoepping.use_case.buy_shoe.controller;

import com.example.shoepping.ValidationCard;
import com.example.shoepping.dao.insert_order_dao.InsertOrderDao;
import com.example.shoepping.dao.size_dao.SizeDaoJDBC;
import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.user.User;
import com.example.shoepping.pattern.observer.ShoeSizeButton;
import com.example.shoepping.pattern.observer.ShoeSizeList;
import com.example.shoepping.pattern.observer.SizeButton;
import com.example.shoepping.pattern.singleton.UserSingleton;
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

    @Override
    public void getSizeAmountList(String model) throws SQLException, IOException, ClassNotFoundException {
        ShoeSizeList shoeSizeList;
        SizeDaoJDBC sizeDao = new SizeDaoJDBC();
        shoeSizeList = sizeDao.getSizeList(model);

        ShoeSizeButton observer37 = new ShoeSizeButton();
        ShoeSizeButton observer38 = new ShoeSizeButton();
        ShoeSizeButton observer39 = new ShoeSizeButton();
        ShoeSizeButton observer40 = new ShoeSizeButton();
        ShoeSizeButton observer41 = new ShoeSizeButton();
        ShoeSizeButton observer42 = new ShoeSizeButton();
        ShoeSizeButton observer43 = new ShoeSizeButton();
        ShoeSizeButton observer44 = new ShoeSizeButton();
        ShoeSizeButton observer45 = new ShoeSizeButton();
        ShoeSizeButton observer46 = new ShoeSizeButton();

        shoeSizeList.addObserver(observer37);
        shoeSizeList.addObserver(observer38);
        shoeSizeList.addObserver(observer39);
        shoeSizeList.addObserver(observer40);
        shoeSizeList.addObserver(observer41);
        shoeSizeList.addObserver(observer42);
        shoeSizeList.addObserver(observer43);
        shoeSizeList.addObserver(observer44);
        shoeSizeList.addObserver(observer45);
        shoeSizeList.addObserver(observer46);

        shoeSizeList.setAvailable();
        onUpdate(shoeSizeList);
    }

    public void onConfirm(String[] orderVec) throws SQLException, IOException, ClassNotFoundException {

        UserSingleton userSingleton = UserSingleton.getInstance();
        User user = userSingleton.getUser();
        boolean isChecked = userSingleton.isChecked();

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
