package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("12345", "Ivan Ivanov");
        PassportOffice po = new PassportOffice();
        po.add(citizen);
        assertThat(po.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenAddFalse() {
        Citizen citizen = new Citizen("12345", "Ivan Ivanov");
        PassportOffice po = new PassportOffice();
        po.add(citizen);
        assertFalse(po.add(citizen));
    }
}