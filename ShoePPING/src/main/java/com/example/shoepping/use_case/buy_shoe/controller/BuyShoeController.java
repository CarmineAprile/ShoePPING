package com.example.shoepping.use_case.buy_shoe.controller;

import com.example.shoepping.bean.*;
import com.example.shoepping.dao.insert_order_dao.InsertOrderDao;
import com.example.shoepping.dao.size_dao.SizeDaoJDBC;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.user.User;
import com.example.shoepping.pattern.observer.ShoeSizeButton;
import com.example.shoepping.pattern.observer.ShoeSizeList;
import com.example.shoepping.pattern.observer.SizeButton;
import com.example.shoepping.pattern.singleton.UserSingleton;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;
import com.opencsv.exceptions.CsvValidationException;

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
        SizeShoeBean sizeShoeBean = new SizeShoeBean();

        for (SizeButton button : shoeSizeList.buttons) {
            if(!button.getIsAvailable()){
                sizeShoeBean.setSizeShoe(String.valueOf(i));
                buyShoeView.onDisable(sizeShoeBean);
            }
            i++;
        }
    }

    @Override
    public void getSizeAmountList(ModelShoeBean modelShoeBean) throws SQLException, IOException, ClassNotFoundException {
        ShoeSizeList shoeSizeList;
        SizeDaoJDBC sizeDao = new SizeDaoJDBC();
        shoeSizeList = sizeDao.getSizeList(modelShoeBean.getModelShoe());

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

    public void onConfirm(OrderVecBean orderVec) throws SQLException, IOException, ClassNotFoundException, CsvValidationException, ManageException {

        UserSingleton userSingleton = UserSingleton.getInstance();
        User user = userSingleton.getUser();
        boolean isChecked = userSingleton.isChecked();

        String conditionOrder = "new";
        String statusOrder = "payed";

        String dateOrder = ZonedDateTime.now(ZoneId.of("Europe/Rome")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Order order = new Order(dateOrder, orderVec.getModelShoeOrderVec(), Double.parseDouble(orderVec.getPriceShoeOrderVec()), conditionOrder, orderVec.getAddressOrderVec(), statusOrder);

        /*
        0 not selected size
        1 empty address
        2 invalid cardID
        3 invalid expiration cardDate
        4 invalid CVC
         */
        orderVec.isValid();

        if(orderVec.getIsValid() == 0){
            utilityOnConfirm("Please select a size", 0);
        }else if(orderVec.getIsValid() == 1){
            utilityOnConfirm("Please select an address", 1);
        }else if(orderVec.getIsValid() == 2){
            utilityOnConfirm("Please insert a valid card ID", 2);
        }else if(orderVec.getIsValid() == 3){
            utilityOnConfirm("Please insert a valid expiration card date", 3);
        }else if(orderVec.getIsValid() == 4){
            utilityOnConfirm("Please insert a valid CVC", 4);
        }else{
            InsertOrderDao insertOrderDao = new InsertOrderDao();
            insertOrderDao.insertOrder(order, user, Integer.parseInt(orderVec.getSizeOrderVec()), isChecked);
            buyShoeView.onConfirmSuccess();
        }

    }

    private void utilityOnConfirm(String message, int errorCode) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        MessageBean messageBean = new MessageBean();
        CodeBean codeBean = new CodeBean();

        messageBean.setMessage(message);
        codeBean.setCode(errorCode);
        buyShoeView.onConfirmError(messageBean, codeBean);
    }



}
