package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("abc@mail.ru", "Ivanov Ivan");
        map.put("def@mail.ru", "Semenov Semen");
        for (String s : map.keySet()) {
            String value = map.get(s);
            System.out.println(s + ": " + value);
        }
    }
}
