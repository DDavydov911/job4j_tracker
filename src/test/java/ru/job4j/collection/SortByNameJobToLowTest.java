package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class SortByNameJobToLowTest {

    @Test
    public void WhenNameToLow() {
        Comparator<Job> cmpNameReversePriority = new SortByNameJobToLow();
        int result = cmpNameReversePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result, lessThan(0));
    }
}