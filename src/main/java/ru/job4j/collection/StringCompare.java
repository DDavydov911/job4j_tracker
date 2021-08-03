package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        int result = 0;
        int length = Math.min(str1.length(), str2.length());
        for (int i = 0; i < length; i++) {
            result = Character.compare(str1.charAt(i), str2.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(str1.length(), str2.length());
        }
        return result;
    }
}
