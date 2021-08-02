package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SortItemByIdToHiTest {

    @Test
    public void compare() {
        Item item1 = new Item("One", 1);
        Item item2 = new Item("Two", 2);
        Item item3 = new Item("Three", 3);
        List<Item> items = Arrays.asList(item2, item1, item3);
        List<Item> expected = Arrays.asList(item1, item2, item3);
        Collections.sort(items, new SortItemByIdToHi());
        assertEquals(expected, items);
    }
}