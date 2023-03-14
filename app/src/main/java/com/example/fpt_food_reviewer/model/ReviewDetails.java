package com.example.fpt_food_reviewer.model;

public class ReviewDetails {
    private int id;
    private int satisfaction_level;
    private int service_speed;
    private int food_quality;
    private int ambiance;
    private int value_for_money;
    private int cleanliness;
    public ReviewDetails(){

    }

    public ReviewDetails(int id, int satisfaction_level, int service_speed, int food_quality, int ambiance, int value_for_money, int cleanliness) {
        this.id = id;
        this.satisfaction_level = satisfaction_level;
        this.service_speed = service_speed;
        this.food_quality = food_quality;
        this.ambiance = ambiance;
        this.value_for_money = value_for_money;
        this.cleanliness = cleanliness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSatisfaction_level() {
        return satisfaction_level;
    }

    public void setSatisfaction_level(int satisfaction_level) {
        this.satisfaction_level = satisfaction_level;
    }

    public int getService_speed() {
        return service_speed;
    }

    public void setService_speed(int service_speed) {
        this.service_speed = service_speed;
    }

    public int getFood_quality() {
        return food_quality;
    }

    public void setFood_quality(int food_quality) {
        this.food_quality = food_quality;
    }

    public int getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(int ambiance) {
        this.ambiance = ambiance;
    }

    public int getValue_for_money() {
        return value_for_money;
    }

    public void setValue_for_money(int value_for_money) {
        this.value_for_money = value_for_money;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }
}
