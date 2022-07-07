package com.mycomp;

public class Stock {

    private int ID;
    private String name;
    private int quantity;

    public Stock(int ID, String name, int quantity) {
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
