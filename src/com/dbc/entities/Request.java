package com.dbc.entities;

import com.dbc.interfaces.Crud;

import java.util.ArrayList;

public class Request {

    private Integer id;
    private User owner;
    private BankAccount bankAccount;
//    private Categories category;
    private String title, description;
    private Double goal, reachedValue;
    private ArrayList<Donate> donatesList;

    public static ArrayList<Request> requestsDB = new ArrayList<>();
}