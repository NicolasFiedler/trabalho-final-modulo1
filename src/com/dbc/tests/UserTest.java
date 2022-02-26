package com.dbc.tests;

import com.dbc.entities.user.Person;
import org.junit.Test;

public class UserTest {
    @Test
    public void testarUsuario (){
        Person person = new Person("nome", "email", "cpf");
    }
}
