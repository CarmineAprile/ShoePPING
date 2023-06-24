package com.example.shoepping.use_case.sell_user_shoe.controller;

import com.example.shoepping.bean.*;
import com.example.shoepping.dao.sales_dao.SalesDaoJDBC;
import com.example.shoepping.exception.ManageException;
import com.example.shoepping.model.sale.Sale;
import com.example.shoepping.pattern.adapter.Adapter;
import com.example.shoepping.pattern.singleton.UserSingleton;
import com.example.shoepping.use_case.sell_user_shoe.view.ISellUserShoeView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public class SellUserShoeController implements ISellUserShoeController{

    ISellUserShoeView sellUserShoeView;

    public SellUserShoeController(ISellUserShoeView sellUserShoeView){
        this.sellUserShoeView = sellUserShoeView;
    }


    @Override
    public void onInsertSale(BrandBean brand, ModelShoeBean item, PriceBean price, ConditionBean condition, SizeShoeBean size) throws IOException, SQLException, ClassNotFoundException, CsvValidationException, ManageException {

        UserSingleton userSingleton = UserSingleton.getInstance();

        if(userSingleton.isChecked()){
            // 8. Check for  user logged with csv
            utilityOnSellUser("Not available yet!", 8);
            return;
        }

        Sale sale = new Sale(brand.getBrand(), item.getModelShoe(), price.getPrice(), condition.getCondition(), String.valueOf(size.getSizeShoe()));

        // 0. Check for brand is Empty
        // 1. Check for item is Empty
        // 2. Check for price is empty
        // 3. Check for price is numeric
        // 4. Check for condition is empty
        // 5. Check for size is empty
        // 6. Check for size is integer
        // 7. Check for size between 30 and 60

        if(brand.getIsValid() == 0){
            utilityOnSellUser("Please insert a brand", 0);
        }else if(item.getIsValid() == 1){
            utilityOnSellUser("Please insert an item", 1);
        }else if(price.getIsValid() == 2){
            utilityOnSellUser("Please insert a price", 2);
        }else if(price.getIsValid() == 3){
            utilityOnSellUser("Please insert a valid price format", 3);
        }else if(condition.getIsValid() == 4){
            utilityOnSellUser("Please select a condition", 4);
        }else if(size.getIsValid() == 5){
            utilityOnSellUser("Please insert a size", 5);
        }else if(size.getIsValid() == 6){
            utilityOnSellUser("Please insert an integer", 6);
        }else if(size.getIsValid() == 7){
            utilityOnSellUser("Please insert a size value between 30 and 60", 7);
        }else {
                SalesDaoJDBC salesDaoJDBC = new SalesDaoJDBC();
                salesDaoJDBC.insertSale(sale, userSingleton.getUser().getUsername());
                // aggiungere la funzione del dao per inserire la sale
                sellUserShoeView.onInsertSaleSuccess();
            }
    }

    private void utilityOnSellUser(String message, int errorCode) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {
        MessageBean messageBean = new MessageBean();
        CodeBean codeBean = new CodeBean();

        messageBean.setMessage(message);
        codeBean.setCode(errorCode);
        sellUserShoeView.onInsertSaleError(messageBean, codeBean);
    }
    @Override
    public void onReccomendedPriceCalculate(PriceBean price, ConditionBean condition) throws CsvValidationException, SQLException, IOException, ClassNotFoundException, ManageException {

        MessageBean messageBean = new MessageBean();

        if(price.getIsValid() == 2){
            messageBean.setMessage("Please insert a price");
            sellUserShoeView.onRecommendedPriceCalculateError(messageBean);
        }else if(price.getIsValid() == 3){
            messageBean.setMessage("Please insert a valid price format");
            sellUserShoeView.onRecommendedPriceCalculateError(messageBean);
        }else if(condition.getIsValid() == 4){
            messageBean.setMessage("Please select a condition");
            sellUserShoeView.onRecommendedPriceCalculateError(messageBean);
        }else {

            PriceBean priceBean = new PriceBean();

            Adapter adapter = new Adapter();
            String recommendedPrice = String.valueOf(adapter.calculatePrice(price.getPrice(), condition.getCondition()));

            priceBean.setPrice(recommendedPrice);

            sellUserShoeView.onRecommendedPriceCalculateSuccess(priceBean);
        }
    }

}
