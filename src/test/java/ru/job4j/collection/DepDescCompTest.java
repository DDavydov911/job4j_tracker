package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class DepDescCompTest {

    @Test
    public void compare() {
    int res = new DepDescComp().compare(
            "K2/SK1/SSK2",
            "K2/SK1/SSK1"
    );
    assertThat(res, lessThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int res = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(res, greaterThan(0));
    }
}