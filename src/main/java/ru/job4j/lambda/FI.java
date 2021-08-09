package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("images 11", 20),
                new Attachment("image 3", 120),
                new Attachment("image 20", 23)
        };
        Consumer<Attachment[]> print = (ats) -> {
            for (Attachment att : ats) {
                System.out.println(att);
            }
            System.out.println();
        };
        print.accept(atts);
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        Arrays.sort(atts, comparator);
        print.accept(atts);

        Comparator<Attachment> cmpText = (left, right) -> left.getName().compareTo(right.getName());
        Arrays.sort(atts, cmpText);
        print.accept(atts);

        Comparator<Attachment> cmpDescSize = (left, right) -> right.getName().length()
                - left.getName().length();
        Arrays.sort(atts, cmpDescSize);
        print.accept(atts);
    }
}
