package com.example.shoepping.bean;

public class IdBean {
    private String id;
    private int isValid;

    public IdBean() {
        // empty constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        isValid();
    }

    public int getIsValid() {
        return isValid;
    }

    private void isValid(){
        if(id.isEmpty())
            this.isValid = 0;
        else if(isNotAnInt(id))
            this.isValid = 1;
        else this.isValid = -1;
    }

    private boolean isNotAnInt(String value){
        try{
            Integer.parseInt(value);
            return false;
        }catch(Exception e){
            return true;
        }
    }

}
