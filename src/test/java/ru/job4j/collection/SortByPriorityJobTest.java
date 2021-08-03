package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class SortByPriorityJobTest {

    @Test
    public void whenPriorityRises() {
        Comparator<Job> cmpRisePrioriry = new SortByPriorityJob();
        int result = cmpRisePrioriry.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(result, greaterThan(0));
    }
}