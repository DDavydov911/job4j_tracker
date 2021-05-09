package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Bible", 1200);
        Book book2 = new Book("Clean code", 800);
        Book book3 = new Book("Boom", 230);
        Book book4 = new Book("Major", 340);
        Book[] library = new Book[4];
        library[0] = book1;
        library[1] = book2;
        library[2] = book3;
        library[3] = book4;
        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i]);
        }
        System.out.println();
        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;
        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i]);
        }
        System.out.println();
        for (int i = 0; i < library.length; i++) {
            if ("Clean code".equals(library[i].getName())) {
                System.out.println(library[i].getName());
            }
        }
    }
}
