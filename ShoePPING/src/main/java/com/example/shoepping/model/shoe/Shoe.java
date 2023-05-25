package com.example.shoepping.model.shoe;

public class Shoe implements IShoe{

    private final String ID;
    private final String amount;
    private final String price;


    public Shoe(String ID, String amount, String price) {
        this.ID = ID;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public String getAmount() {
        return this.amount;
    }

    @Override
    public String getPrice() {
        return this.price;
    }

    @Override
    public int isValid() {
        // 0. check for ID is empty
        // 1. check for ID is int
        // 2. check for amount is empty
        // 3. check for amount is int
        // 4. check for pice is empty
        // 5. check for price is numeric
        if(getID().isEmpty()){
            return 0;
        }else if(isNotAnInt(getID())){
            return 1;
        }else if(getAmount().isEmpty()){
            return 2;
        }else if(isNotAnInt(getAmount())){
            return 3;
        }else if(getPrice().isEmpty()){
            return 4;
        }else if(isNotAPrice(getPrice())){
            return 5;
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

    private boolean isNotAnInt(String value){
        try{
            Integer.parseInt(value);
            return false;
        }catch(Exception e){
            return true;
        }
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
}
