package com.example.recycler_view;

public class Model {
    String username,password;               //Declearing variable

    //Creating the consstructor to get access of this class
    public Model(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Model() {
        //Default constructor to call and create model object
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
