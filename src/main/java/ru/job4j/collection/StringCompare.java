package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        int result = 0;
        int length1 = str1.length();
        int length2 = str2.length();
        int length = Math.min(length1, length2);
        for (int i = 0; i < length; i++) {
            char left = str1.charAt(i);
            char right = str2.charAt(i);
            result = Character.compare(left, right);
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(length1, length2);
        }
        return result;
    }
}
