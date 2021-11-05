package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(3, "Three"),
                new Item(1, "One"),
                new Item(2, "Two")
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
