package ru.job4j.collection;

import java.util.Comparator;

public class SortByNameJobToHi implements Comparator<Job> { //Уже есть
    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
