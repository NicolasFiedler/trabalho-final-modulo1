package com.dbc.tests;

import com.dbc.entities.Donate;
import com.dbc.entities.Request;
import com.dbc.enums.Categories;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestTest {

    private Request request;

    @Test
    public void newDonateMustBeAdded() {
        request = new Request(null, null, Categories.ANIMAIS, "Ajudem meu doguinho", "meu doguinho foi atropelado", 2500.0);
        Donate donate = new Donate("Lucas", "054", "luc", 500.0, "boa sorte com o dog", "?");

        boolean addedNewDonate = request.setNewDonate(donate);

        assertTrue(addedNewDonate);
        System.out.println(request.getDonatesList());
    }

    @Test
    public void reachedValueMustBeIncremented() {
        request = new Request(null, null, Categories.ANIMAIS, "Ajudem meu doguinho", "meu doguinho foi atropelado", 2500.0);
        request.setReachedValue(400.0);
        Donate donate = new Donate("Lucas", "054", "luc", 500.0, "boa sorte com o dog", "?");

        boolean addedNewDonate = request.setNewDonate(donate);

        assertTrue(addedNewDonate);
        assertEquals(900.0, request.getReachedValue(), 0);
        System.out.println(request.getDonatesList());
    }

    @Test
    public void goalMustBeReached() {
        request = new Request(null, null, Categories.ANIMAIS, "Ajudem meu doguinho", "meu doguinho foi atropelado", 2500.0);
        request.setReachedValue(2501.0);

        boolean goalReached = request.checkIfGoalHasReached();

        assertTrue(goalReached);
    }

    @Test
    public void requestMustBeClosed() {
        request = new Request(null, null, Categories.ANIMAIS, "Ajudem meu doguinho", "meu doguinho foi atropelado", 2500.0);
        request.setReachedValue(400.0);
        Donate donate = new Donate("Lucas", "054", "luc", 2200.0, "boa sorte com o dog", "?");
        Donate donate2 = new Donate("Luca", "054", "luc", 2100.0, "boa sorte com o dog", "?");
        request.addNewDonate(donate);
        request.addNewDonate(donate2);

        boolean goalReached = request.checkIfGoalHasReached();

        assertTrue(goalReached);
        assertEquals(0, Request.requestsDB.size(), 0);
    }
}
