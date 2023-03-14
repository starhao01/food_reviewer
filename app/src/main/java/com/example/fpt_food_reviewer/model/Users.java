package com.example.fpt_food_reviewer.model;

public class Users {
    private int id;
    private String userName;
    private String passWord;
    private boolean isAdmin;
    public Users(){

    }

    public Users(int id, String userName, String passWord, boolean isAdmin) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
