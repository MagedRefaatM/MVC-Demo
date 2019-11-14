package com.me.demo;

class Controller {

    String Name = "";
    String Password = "";

    void setNameAndPassword(String name, String password){
        this.Name = name;
        this.Password = password;
    }

    String getName() {
        return Name;
    }

    String getPassword() {
        return Password;
    }
}