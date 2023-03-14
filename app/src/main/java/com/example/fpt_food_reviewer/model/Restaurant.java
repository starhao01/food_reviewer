package com.example.fpt_food_reviewer.model;

import android.media.Image;

import java.util.List;

public class Restaurant {
    private long id;
    private String name;
    private String address;
    private String description;
    private List<Image> imageList;

    public Restaurant(){

    }

    public Restaurant(long id, String name, String address, String description, List<Image> imageList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.imageList = imageList;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
