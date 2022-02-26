package com.dbc.entities.user;

import com.dbc.entities.Request;
import com.dbc.interfaces.Crud;

import java.util.ArrayList;

public abstract class User implements Crud {
    private Integer id;
    private String name, email;
    private ArrayList<Request> myRequestsList;

    private static ArrayList<User> userDB = new ArrayList<>();
    private static Integer count++;

    public User(){}
    public User(String name, String email) throws Exception {

        this.setName(name);
        this.setEmail(email);
        userDB.add(this);
    }


    public ArrayList<Request> getMyRequestsList() {
        return myRequestsList;
    }

    public void setMyRequestsList(ArrayList<Request> myRequestsList) {
        this.myRequestsList = myRequestsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (idCheckIfNotExist(id)) {
            this.id = id;
        } else {

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Request createNewRequest () {
        return null;
    }

    public static ArrayList<User> getUserDB() {
        return userDB;
    }

    public Boolean idCheckIfNotExist (String id) {
        for (User user : getUserDB()) {
            if(user.getId().equalsIgnoreCase(id)){
                return false;
            }
        }
        return true;
    }
}
