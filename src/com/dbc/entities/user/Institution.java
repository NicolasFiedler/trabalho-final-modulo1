package com.dbc.entities.user;

public class Institution extends User {
    private String cnpj;

    public Institution(String name, String email, String cnpj)  {
        super(name, email);
        this.cnpj = cnpj;
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
