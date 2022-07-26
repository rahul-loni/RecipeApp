package com.example.recipe_app;

public class FoodData {

    private String itemName;
    private String itemDescription;
    private String itemPrice;
    private int itmeImage;

    public FoodData(String itemName, String itemDescription, String itemPrice, int itmeImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itmeImage = itmeImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public int getItmeImage() {
        return itmeImage;
    }
}
