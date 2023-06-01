package com.example.shoepping.use_case.buy_user_used_shoe.controller;

import com.example.shoepping.bean.*;
import com.example.shoepping.dao.catalog_dao.CatalogDao;
import com.example.shoepping.dao.insert_order_dao.InsertOrderDao;
import com.example.shoepping.model.catalog.Catalog;
import com.example.shoepping.model.catalog.CatalogItem;
import com.example.shoepping.model.order.Order;
import com.example.shoepping.model.sale.Sale;
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
    public String setLabels(LabelBean label) throws SQLException, IOException, ClassNotFoundException {

        CatalogDao catalogDao = new CatalogDao();

        Catalog catalog = catalogDao.getCatalog();

        String sellIDUpdate = null;

        StringBuilder sellID = new StringBuilder();
        for(int i = 6; i<label.getLabel().length(); i++){
            if((label.getLabel().charAt(i) != ',')){
                sellID.append(label.getLabel().charAt(i));
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
    public void onConfirm(ModelShoeBean item, BrandBean brand, PriceBean price, SizeShoeBean size, SellerBean seller, UserVecBean userDataVec, SellIdUpdateBean sellIDUpdate) throws SQLException, IOException, ClassNotFoundException{

        UserSingleton userSingleton = UserSingleton.getInstance();
        User user = userSingleton.getUser();
        boolean isChecked = userSingleton.isChecked();

        String conditionOrder = "used";
        String statusOrder = "payed";

        String dateOrder = ZonedDateTime.now(ZoneId.of("Europe/Rome")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Order order = new Order(dateOrder, item.getModelShoe(), Double.parseDouble(price.getPrice()), conditionOrder, userDataVec.getAddressUserVec(), statusOrder);
        Sale sale = new Sale(brand.getBrand(), item.getModelShoe(), price.getPrice(), userDataVec.getConditionUserVec(), size.getSizeShoe(), seller.getSeller());

        /*
        0 empty address
        1 invalid cardID
        2 invalid expiration cardDate
        3 invalid CVC
        */
        userDataVec.isValid();

        if(userDataVec.getIsValid() == 0){
            utilityOnConfirm("Please enter an address", 0);
        }else if(userDataVec.getIsValid() == 1){
            utilityOnConfirm("Please insert a valid card ID", 1);
        }else if(userDataVec.getIsValid() == 2){
            utilityOnConfirm("Please insert a valid expiration card date", 2);
        }else if(userDataVec.getIsValid() == 3){
            utilityOnConfirm("Please insert a valid CVC", 3);
        }else{
            InsertOrderDao insertOrderDao = new InsertOrderDao();
            insertOrderDao.insertOrderCatalog(order, user, isChecked, sellIDUpdate.getSellIdUpdate(), sale);
            buyUserUsedShoeView.onConfirmSuccess();
        }
    }

    private void utilityOnConfirm(String message, int errorCode) {
        MessageBean messageBean = new MessageBean();
        CodeBean codeBean = new CodeBean();

        messageBean.setMessage(message);
        codeBean.setCode(errorCode);
        buyUserUsedShoeView.onConfirmError(messageBean, codeBean);
    }
}
