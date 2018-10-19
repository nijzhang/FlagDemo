package com.example.a15625.flagdemo;

public class Item {
    private String name;
    private int imageId;

    public Item(String Name,int imageId)
    {
        this.imageId = imageId;
        this.name = Name;
    }
    public String getName()
    {
        return name;
    }
    public int getImageId()
    {
        return imageId;
    }
}
