package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenMinusOneThenFinish() {
        Fact.calc(-1);
    }

    @Test
    public void when3Then6() {
        int res = Fact.calc(3);
        assertThat(res, is(6));
    }

}