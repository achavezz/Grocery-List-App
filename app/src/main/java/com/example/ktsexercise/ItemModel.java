package com.example.ktsexercise;

public class ItemModel {
    String itemName;
    Integer itemID;
    Integer itemCount;
    int image;

    public ItemModel(String itemName, Integer itemID, Integer itemCount, int image) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemCount = itemCount;
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getItemID() {
        return itemID;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public int getImage() {
        return image;
    }
}
