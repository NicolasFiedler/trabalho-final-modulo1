package com.dbc.entities;

import java.util.ArrayList;

public class Request {

    private Integer id;
    private User owner;
    private BankAccount bankAccount;
    private Categories category;
    private String title, description;
    private Double goal;
    private Double reachedValue;
    private ArrayList<Donate> donatesList;

    public static ArrayList<Request> requestsDB = new ArrayList<>();
    public static Integer idCount = 0;

    public Request() {}

    public Request(User owner, BankAccount bankAccount, Categories category, String title, String description, Double goal) {
        this.setId(++idCount);
        this.setOwner(owner);
        this.setBankAccount(bankAccount);
        this.setCategory(category);
        this.setTitle(title);
        this.setDescription(description);
        this.goal = goal;
        this.reachedValue = 0.0;
        this.donatesList = new ArrayList<Donate>();

        requestsDB.add(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer finalId = id;
        boolean idExists = requestsDB.stream()
                .map(Request::getId)
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

    public Double getReachedValue() {
        return reachedValue;
    }

    public void setReachedValue(Double value) {
        this.reachedValue += value;
    }

    public ArrayList<Donate> getDonatesList() {
        return donatesList;
    }

    public boolean setNewDonate(Donate donate) {
        Double value = donate.getDonateValue();
        if (value > 0) {
            this.setReachedValue(value);
            return true;
        }
        return false;
    }

//  TODO - listar pelos valores menores
    public static void getAllRequests() {

    }

    // TODO - tratar caso retorne nulo.
    public Request getRequestById(Integer id) {
        Request request = requestsDB.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
        return request;
    }

    public boolean addNewDonate(Donate donate) {
        if (donate != null) {
            this.setNewDonate(donate);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getId() + " - " +
                this.getTitle() + "\n-- Valor: " +
                this.getReachedValue() + "/" +
                this.getGoal() + "\nDescrição: " +
                this.getDescription() + "\nUsuário: " +
                this.getOwner().getName();

    }
}