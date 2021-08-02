package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemByIdToLow implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Integer.compare(o2.getId(), o1.getId());
    }
}
