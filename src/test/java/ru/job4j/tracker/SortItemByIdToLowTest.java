package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SortItemByIdToLowTest {

    @Test
    public void compare() {
        Item item1 = new Item(1, "One");
        Item item2 = new Item(2, "Two");
        Item item3 = new Item(3, "Three");
        List<Item> items = Arrays.asList(item2, item1, item3);
        List<Item> expected = Arrays.asList(item3, item2, item1);
        Collections.sort(items, new SortItemByIdToLow());
        assertEquals(expected, items);
    }
}