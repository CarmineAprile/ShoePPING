package com.example.shoepping;

public class ValidationNumeric {

    public static boolean isNotAPrice(String price){

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
        return utilityPrice(l, findPoint, price);
    }

    private static boolean utilityPrice(int l, boolean findPoint, String price){
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
