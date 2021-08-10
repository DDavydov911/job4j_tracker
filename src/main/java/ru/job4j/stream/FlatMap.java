package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public List<Integer> toList(Integer[][] integers) {
        return Arrays.stream(integers)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
