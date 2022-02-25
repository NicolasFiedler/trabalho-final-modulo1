package com.dbc.entities;

import java.util.ArrayList;

public class Request {
    private Integer id;
    private User owner;
    private BankAccount bankAccount;
    private String title, descripition;
    private Double goal, reachedValue;
    private ArrayList<Donate> donateList;

    private static ArrayList<Request> requestsDB;

    public static void printaRequest () {

    }
}