package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, -3, 4, -5, -6, 7);
        List<Integer> finalList = list.stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        System.out.println(finalList);
    }
}
