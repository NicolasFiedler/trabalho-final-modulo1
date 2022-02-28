package com.dbc.interfaces;

public interface Crud {
    Boolean createUser (String name, String email, String cpf);
    Boolean updateUser (Integer id);
    Boolean deleteUser (Integer id);
}