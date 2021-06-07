package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenMinusOneThenFinish() {
        Fact.calc(-1);
    }

    @Test
    public void when3Then6() {
        int res = Fact.calc(3);
        assertEquals(res, 6);
//        assertThat(res, is(6)); Почему не проходит?
    }

}