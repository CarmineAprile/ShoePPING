package com.example.shoepping.use_case.buy_shoe.controller;

import com.example.shoepping.bean.*;
import com.example.shoepping.dao.insert_order_dao.InsertOrderDao;
import com.example.shoepping.dao.size_dao.SizeDaoJDBC;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.user.User;
import com.example.shoepping.pattern.observer.BarchartObserver;
import com.example.shoepping.pattern.observer.ShoeSizeSubject;
import com.example.shoepping.pattern.observer.ButtonObserver;
import com.example.shoepping.pattern.singleton.UserSingleton;
import com.example.shoepping.use_case.buy_shoe.view.IBuyShoeView;
import com.opencsv.exceptions.CsvValidationException;
import javafx.scene.chart.XYChart;

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
    public void onUpdate(int sizeButton) {

        SizeShoeBean sizeShoeBean = new SizeShoeBean();
        sizeShoeBean.setSizeShoe(String.valueOf(sizeButton));
        buyShoeView.onDisable(sizeShoeBean);

    }

    @Override
    public void onBarchart(XYChart.Series<String, Integer> barchart) {
        BarchartBean barchartBean = new BarchartBean();
        barchartBean.setBarchart(barchart);
        buyShoeView.onBarchart(barchartBean);
    }

    @Override
    public void getSizeAmountList(ModelShoeBean modelShoeBean) throws SQLException, IOException, ClassNotFoundException {
        ShoeSizeSubject shoeSizeList;
        SizeDaoJDBC sizeDao = new SizeDaoJDBC();
        shoeSizeList = sizeDao.getSizeList(modelShoeBean.getModelShoe());

        ButtonObserver observer37 = new ButtonObserver(37, buyShoeView, shoeSizeList);
        ButtonObserver observer38 = new ButtonObserver(38, buyShoeView, shoeSizeList);
        ButtonObserver observer39 = new ButtonObserver(39, buyShoeView, shoeSizeList);
        ButtonObserver observer40 = new ButtonObserver(40, buyShoeView, shoeSizeList);
        ButtonObserver observer41 = new ButtonObserver(41, buyShoeView, shoeSizeList);
        ButtonObserver observer42 = new ButtonObserver(42, buyShoeView, shoeSizeList);
        ButtonObserver observer43 = new ButtonObserver(43, buyShoeView, shoeSizeList);
        ButtonObserver observer44 = new ButtonObserver(44, buyShoeView, shoeSizeList);
        ButtonObserver observer45 = new ButtonObserver(45, buyShoeView, shoeSizeList);
        ButtonObserver observer46 = new ButtonObserver(46, buyShoeView, shoeSizeList);
        BarchartObserver barchartObserver = new BarchartObserver(buyShoeView, shoeSizeList);

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
        shoeSizeList.addObserver(barchartObserver);

        shoeSizeList.notifyObserver();
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
