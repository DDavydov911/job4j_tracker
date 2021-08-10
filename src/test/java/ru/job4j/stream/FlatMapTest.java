package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FlatMapTest {

    @Test
    public void toList() {
        FlatMap fm = new FlatMap();
        Integer[][]  ints = new Integer[][]{
                new Integer[]{1, 2, 3, 4, 5},
                new Integer[]{6, 7, 8, 9, 10},
                new Integer[]{11, 12, 13, 14, 15}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<Integer> result = fm.toList(ints);
        assertThat(result, is(expected));
    }
}