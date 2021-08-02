package ru.job4j.collection;

import java.util.Comparator;

public class SortByNameJobToLow implements Comparator<Job> {//Уже есть
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
