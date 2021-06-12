package ru.job4j.tracker;

public final class SingleTracker {
    private static Tracker instance = null;

    private SingleTracker() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return instance.add(item);
    }

    public Item findById(int id) {
        return instance.findById(id);
    }

    public boolean replace(int id, Item item) {
        return instance.replace(id, item);
    }

    public boolean delete(int id) {
        return instance.delete(id);
    }

    public Item[] findAll() {
        return instance.findAll();
    }

    public Item[] findByName(String key) {
        return instance.findByName(key);
    }
}
