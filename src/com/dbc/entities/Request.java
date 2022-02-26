package com.dbc.entities;

import java.util.ArrayList;

public class Request {

    private Integer id;
    private User owner;
    private BankAccount bankAccount;
    private Categories category;
    private String title, description;
    private Double goal, reachedValue;
    private ArrayList<Donate> donatesList;

    public static ArrayList<Request> requestsDB = new ArrayList<>();
    public static Integer idCount = 0;

    public Request(User owner, BankAccount bankAccount, Categories category, String title, String description, Double goal) {
        try {
            this.setId(++idCount);
            this.setOwner(owner);
            this.setBankAccount(bankAccount);
            this.setCategory(category);
            this.setTitle(title);
            this.setDescription(description);
            this.setGoal(goal);
            this.reachedValue = 0.0;
            this.donatesList = new ArrayList<Donate>();
        } catch (NullPointerException e) {
            System.out.println("Algum dado está faltando.");
            System.out.println(e.getMessage());
        } finally {
            requestsDB.add(this);
        }
        //redundante. tu pode usar sem o finelly
        requestsDB.add(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer finalId = id;
        boolean idExists = requestsDB.stream()
                .map(request -> request.getId())
                .anyMatch(r -> r.equals(finalId));

        if (!idExists) {
            this.id = id;
        } else {
            this.id = ++id;
        }
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        if (owner != null) {
            this.owner = owner;
        }
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        if (bankAccount != null) {
            this.bankAccount = bankAccount;
        }
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getGoal() {
        return goal;
    }

    public void setGoal(Double goal) {
        this.goal = goal;
    }

    public Double getReachedValue() {
        return reachedValue;
    }

    public ArrayList<Donate> getDonatesList() {
        return donatesList;
    }
}