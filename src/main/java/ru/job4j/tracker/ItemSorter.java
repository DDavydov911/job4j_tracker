package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("Three", 3),
                new Item("One", 1),
                new Item("Two", 2)
        );
        System.out.println(items);
        Collections.sort(items, new SortItemByIdToHi());
        System.out.println(items);
        Collections.sort(items, new SortItemByIdToLow());
        System.out.println(items);
        Collections.sort(items, new SortItemByName());
        System.out.println(items);
        Collections.sort(items, Collections.reverseOrder());
        System.out.println(items);
    }
}
