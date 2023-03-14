package com.example.fpt_food_reviewer.model;

import java.util.Date;

public class Review {
    private int id;
    private int restaurantId;
    private int userId;
    private int reviewDetailsId;
    private String comment;
    private Date createdDate;
    public Review(){

    }

    public Review(int id, int restaurantId, int userId, int reviewDetailsId, String comment, Date createdDate) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.reviewDetailsId = reviewDetailsId;
        this.comment = comment;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReviewDetailsId() {
        return reviewDetailsId;
    }

    public void setReviewDetailsId(int reviewDetailsId) {
        this.reviewDetailsId = reviewDetailsId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
