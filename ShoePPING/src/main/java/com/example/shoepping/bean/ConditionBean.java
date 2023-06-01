package com.example.shoepping.bean;

public class ConditionBean {
    private String condition;
    private int isValid;

    public ConditionBean() {
        // empty constructor
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
        isValid();
    }

    public int getIsValid() {
        return isValid;
    }

    private void isValid() {
        if (condition.equals("Select condition"))
            this.isValid = 4;
        else this.isValid = -1;
    }
}
