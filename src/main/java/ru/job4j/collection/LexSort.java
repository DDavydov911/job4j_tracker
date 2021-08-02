package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String nums1 = "";
        String nums2 = "";
        for (int i = 0; i < o1.length(); i++) {
            char n = o1.charAt(i);
            if (n == '.') {
                break;
            }
            if (Character.isDigit(n)) {
                nums1 += n;
            }
        }
        for (int i = 0; i < o2.length(); i++) {
             char n = o2.charAt(i);
            if (n == '.') {
                break;
            }
             if (Character.isDigit(n)) {
                 nums2 += n;
             }
        }
        return Integer.compare(Integer.parseInt(nums1), Integer.parseInt(nums2));
    }
}
