package ru.job4j.tracker;

public class Main {

    public static void main(String[] args) {
        Tracker st = SingleTracker.getInstance();
        st.add(new Item("item1"));
        System.out.println(st.findById(1));
        Tracker st2 = SingleTracker.getInstance();
        System.out.println(st2.findById(1));
        st2.replace(1, new Item("item444"));
        System.out.println(st.findById(1));
        System.out.println(st2.findById(1));
    }
}
