package com.dbc.interfaces;

import com.dbc.entities.user.User;

public interface Crud {
    Boolean createUser (String name, String email, String cpf);
    void updateUser (Integer id);
    Boolean deleteUser (Integer id);
}
