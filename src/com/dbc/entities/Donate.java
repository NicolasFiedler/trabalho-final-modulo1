package com.dbc.entities;

public class Donate {
    private Request request;
    private Double donateValue;
    private String descripition, accoutInformation;

    public Boolean simulatePayment (String str) {
        if (str.equalsIgnoreCase("valido")){
            return true;
        }
        return false;
    }

    public Boolean donateRequest (Integer integer){
        return false;
    }
}