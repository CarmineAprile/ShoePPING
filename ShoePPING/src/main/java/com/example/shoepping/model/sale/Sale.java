package com.example.shoepping.model.sale;

public class Sale implements ISale{

    private String brand;
    private String item;
    private  String price;
    private String condition;
    private String size;
    private String seller;

    public Sale(String brand, String item, String price, String condition, String size) {
        this.brand = brand;
        this.item = item;
        this.price = price;
        this.condition = condition;
        this.size = size;
    }

    public Sale(String brand, String item, String price, String condition, String size, String seller) {
        this.brand = brand;
        this.item = item;
        this.price = price;
        this.condition = condition;
        this.size = size;
        this.seller = seller;
    }

    public Sale(String price, String condition){
        this.price = price;
        this.condition = condition;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCondition(String condition){
        this.condition = condition;
    }

    public void setSize(String size) {
        this.size = size;
    }


    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getItem() {
        return item;
    }

    @Override
    public String getPrice() {
        return price;
    }

    @Override
    public String getCondition() {
        return condition;
    }

    @Override
    public String getSize() {
        return size;
    }
    @Override
    public String getSeller() {
        return seller;
    }


    @Override
    public int isValid() {
        // 0. Check for brand is Empty
        // 1. Check for item is Empty
        // 2. Check for price is empty
        // 3. Check for price is numeric
        // 4. Check for condition is empty
        // 5. Check for size is empty
        // 6. Check for size is integer

        if(brand.isEmpty()){
            return 0;
        }else if (item.isEmpty()){
            return 1;
        }else if (price.isEmpty()){
            return 2;
        }else if(isNotAPrice(price)) {
            return 3;
        }else if(condition.equals("Select condition")){
            return 4;
        }else if(size.isEmpty()){
            return 5;
        }else if(!isASize(size)){
            return 6;
        }else if(Integer.parseInt(size) < 30 || Integer.parseInt(size) >60){
            return 7;
        }else return -1;
    }

    @Override
    public int isValidRecommendedPrice() {
        // 0. Check for brand is Empty
        // 1. Check for item is Empty
        // 2. Check for price is empty
        // 3. Check for price is numeric
        // 4. Check for condition is empty
        // 5. Check for size is empty
        // 6. Check for size is integer


        if(price.isEmpty()) {
            return 0;
        }else if (isNotAPrice(price)) {
            return 1;
        }else if(condition.equals("Select condition")){
            return 2;
        }else return -1;
    }

    private boolean isNotAPrice(String price){

        int l = price.length();
        int cont = 0;
        boolean findPoint = false;

        for(int i = 0; i<l; i++){

            if(price.charAt(i) == '.'){
                findPoint = true;
                if(cont > 3){
                    return true;
                }
                for(int j = 0; j<(l-i); j++){
                    if(j>2){
                        return true;
                    }
                }
            }
            cont++;
        }
        return utilityPrice(l, findPoint);
    }

    private boolean utilityPrice(int l, boolean findPoint){
        if(l>3 && !findPoint)
            return true;

        try{
            Double.parseDouble(price);
            return false;
        }catch(Exception e){
            return true;
        }
    }

    private boolean isASize(String size){
        try{
            Integer.parseInt(size);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
