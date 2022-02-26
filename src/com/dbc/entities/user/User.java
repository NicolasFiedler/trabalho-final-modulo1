package com.dbc.entities.user;

import com.dbc.entities.Request;
import com.dbc.interfaces.Crud;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public abstract class User implements Crud {
    private Integer id;
    private String name, email;
    private ArrayList<Request> myRequestsList;

    private static ArrayList<User> userDB = new ArrayList<>();
    private static Integer count = 0;

    public User(){}
    public User(String name, String email) {
        this.setId(count++);
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", myRequestsList=" + myRequestsList +
                '}';
    }

    public static void userListPrint (){
        for (User user :
                getUserDB()) {
            System.out.println(user);
        }
    }

    public static User getUserById (Integer id) {
        for (User user :
                getUserDB()) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
}
