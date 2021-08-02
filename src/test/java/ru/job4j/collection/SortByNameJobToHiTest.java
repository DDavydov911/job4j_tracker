package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SortByNameJobToHiTest {

    @Test
    public void WhenNameToHi() {
        Comparator<Job> cmpNameToHi = new SortByNameJobToHi();
        int result = cmpNameToHi.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
                );
        assertThat(result, lessThan(0));
    }
}