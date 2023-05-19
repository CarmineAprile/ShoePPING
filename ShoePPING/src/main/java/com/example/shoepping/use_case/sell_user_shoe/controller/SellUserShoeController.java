package com.example.shoepping.use_case.sell_user_shoe.controller;

import com.example.shoepping.dao.sales_dao.SalesDaoJDBC;
import com.example.shoepping.model.sale.Sale;
import com.example.shoepping.pattern.singleton.UserSingleton;
import com.example.shoepping.use_case.sell_user_shoe.view.ISellUserShoeView;

public class SellUserShoeController implements ISellUserShoeController{

    ISellUserShoeView sellUserShoeView;

    public SellUserShoeController(ISellUserShoeView sellUserShoeView){
        this.sellUserShoeView = sellUserShoeView;
    }


    @Override
    public void onInsertSale(String brand, String item, String price, String condition, String size) {

        UserSingleton userSingleton = UserSingleton.getInstance();

        if(userSingleton.isChecked()){
            // 8. Check for  user logged with csv
            sellUserShoeView.onInsertSaleError("Not available yet!", 8);
            return;
        }

        Sale sale = new Sale(brand, item, price, condition, size);

        // 0. Check for brand is Empty
        // 1. Check for item is Empty
        // 2. Check for price is empty
        // 3. Check for price is numeric
        // 4. Check for condition is empty
        // 5. Check for size is empty
        // 6. Check for size is integer
        // 7. Check for size between 30 and 60


        switch (sale.isValid()){
            case 0 -> sellUserShoeView.onInsertSaleError("Please insert a brand", 0);
            case 1 -> sellUserShoeView.onInsertSaleError("Please insert an item", 1);
            case 2 -> sellUserShoeView.onInsertSaleError("Please insert a price", 2);
            case 3 -> sellUserShoeView.onInsertSaleError("Please insert a valid price format", 3);
            case 4 -> sellUserShoeView.onInsertSaleError("Please select a condition", 4);
            case 5 -> sellUserShoeView.onInsertSaleError("Please insert a size", 5);
            case 6 -> sellUserShoeView.onInsertSaleError("Please insert an integer", 6);
            case 7 -> sellUserShoeView.onInsertSaleError("Please insert a size value between 30 and 60", 7);
            default -> {
                SalesDaoJDBC salesDaoJDBC = new SalesDaoJDBC();
                // aggiungere la funzione del dao per inserire la sale
                sellUserShoeView.onIsertSaleSuccess();
            }
        }
    }
    @Override
    public void onReccomendedPriceCalculate(String price, String condition) {

        Sale sale = new Sale(price, condition);
        int isValid = sale.isValidRecommendedPrice();

        switch (isValid){
            case 0 -> sellUserShoeView.onReccomendedPriceCalculateError("Please insert a price");
            case 1 -> sellUserShoeView.onReccomendedPriceCalculateError("Please insert a valid price format");
            case 2 -> sellUserShoeView.onReccomendedPriceCalculateError("Please select a condition");
            default -> sellUserShoeView.onReccomendedPriceCalculateSuccess(sale.getPrice(), sale.getCondition());
        }
    }


}
