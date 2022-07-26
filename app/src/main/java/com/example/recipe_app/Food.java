package com.example.recipe_app;

public class Food {
    private String itemName;
    private String itemDisc;
    private String itemPrice;
    private int itemImage;

    public Food(String itemName, String itemDisc, String itemPrice, int itemImage) {
        this.itemName = itemName;
        this.itemDisc = itemDisc;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDisc() {
        return itemDisc;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }
}
