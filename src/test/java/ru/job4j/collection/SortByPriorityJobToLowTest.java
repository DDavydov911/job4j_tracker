package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class SortByPriorityJobToLowTest {

    @Test
    public void WhenPriorityToLow() {
        Comparator<Job> cmpToLowPrioriry = new SortByPriorityJobToLow();
        int result = cmpToLowPrioriry.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(result, lessThan(0));
    }
}