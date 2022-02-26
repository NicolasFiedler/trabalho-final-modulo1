package com.dbc.entities.user;

public class Person extends User {
    private String cpf;

    public Person(){}
    public Person(String name, String email, String cpf) {
        super(name, email);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void readUser(Integer id) {

    }

    @Override
    public void updateUser(Integer id) {

    }

    @Override
    public void deleteUser(Integer id) {

    }
}
