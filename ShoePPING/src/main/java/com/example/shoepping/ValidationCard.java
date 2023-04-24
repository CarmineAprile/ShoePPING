package com.example.shoepping;

public class ValidationCard {
    public static boolean valCardID(String cardID) {
        int l = cardID.length();
        if(l != 19)
            return false;

        for (int i=0; i<l; i++){
            if(i == 4 || i == 9 || i == 14) {
                String s = String.valueOf(cardID.charAt(i));
                if(!s.equals(" ")){
                    return false;
                }
                continue;
            }

            char c = cardID.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean valCardDate(String cardDate){
        int l = cardDate.length();
        if(l != 5)
            return false;

        char m1 = cardDate.charAt(0);
        char m2 = cardDate.charAt(1);
        char space = cardDate.charAt(2);
        char y1 = cardDate.charAt(3);
        char y2 = cardDate.charAt(4);

        return (m1 == '0' && (m2 != '0') || m1 == '1' && (m2 == '0' || m2 == '1' || m2 == '2')) && (space == '/') && (y1 != '0' && y1 != '1') && (!(y1 == '2' && (y2 == '0' || y2 == '1' || y2 == '2')));
    }

    public static boolean valCardCVC(String CVC){

        int l = CVC.length();
        if (l != 3){
            return false;
        }

        char CVC1 = CVC.charAt(0);
        char CVC2 = CVC.charAt(1);
        char CVC3 = CVC.charAt(2);

        return (CVC1 == '0' || CVC1 == '1' || CVC1 == '2' || CVC1 == '3' || CVC1 == '4' || CVC1 == '5' || CVC1 == '6' || CVC1 == '7' || CVC1 == '8' || CVC1 == '9') && (CVC2 == '0' || CVC2 == '1' || CVC2 == '2' || CVC2 == '3' || CVC2 == '4' || CVC2 == '5' || CVC2 == '6' || CVC2 == '7' || CVC2 == '8' || CVC2 == '9') && (CVC3 == '0' || CVC3 == '1' || CVC3 == '2' || CVC3 == '3' || CVC3 == '4' || CVC3 == '5' || CVC3 == '6' || CVC3 == '7' || CVC3 == '8' || CVC3 == '9');
    }
}
