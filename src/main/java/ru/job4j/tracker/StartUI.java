package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();

        Tracker tracker = new Tracker();
        tracker.add(new Item("Cap"));
        tracker.add(new Item("Bowl"));
        tracker.add(new Item("Bowl"));
        tracker.add(new Item("Book"));
        tracker.add(new Item("Plate"));
        tracker.add(new Item("Socks"));
        System.out.println(tracker.findById(1));
        System.out.println(tracker.findById(4));
        System.out.println(tracker.findById(5));
    }
}
