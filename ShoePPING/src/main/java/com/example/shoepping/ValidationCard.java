package com.example.shoepping;

public class ValidationCard {

    private ValidationCard() {
        throw new IllegalStateException("Utility class");
    }
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

    public static boolean valCardCVC(String cvc){

        int l = cvc.length();
        if (l != 3){
            return false;
        }

        char cvc1 = cvc.charAt(0);
        char cvc2 = cvc.charAt(1);
        char cvc3 = cvc.charAt(2);

        return (cvc1 == '0' || cvc1 == '1' || cvc1 == '2' || cvc1 == '3' || cvc1 == '4' || cvc1 == '5' || cvc1 == '6' || cvc1 == '7' || cvc1 == '8' || cvc1 == '9') && (cvc2 == '0' || cvc2 == '1' || cvc2 == '2' || cvc2 == '3' || cvc2 == '4' || cvc2 == '5' || cvc2 == '6' || cvc2 == '7' || cvc2 == '8' || cvc2 == '9') && (cvc3 == '0' || cvc3 == '1' || cvc3 == '2' || cvc3 == '3' || cvc3 == '4' || cvc3 == '5' || cvc3 == '6' || cvc3 == '7' || cvc3 == '8' || cvc3 == '9');
    }
}
