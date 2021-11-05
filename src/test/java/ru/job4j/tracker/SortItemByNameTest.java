package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SortItemByNameTest {

    @Test
    public void compare() {
        Item itemOne = new Item(1, "One");
        Item itemTwo = new Item(2, "Two");
        Item itemThree = new Item(3, "Three");
        List<Item> items = Arrays.asList(itemTwo, itemOne, itemThree);
        List<Item> expected = Arrays.asList(itemOne, itemThree, itemTwo);
        Collections.sort(items, new SortItemByName());
        assertEquals(expected, items);
    }
}