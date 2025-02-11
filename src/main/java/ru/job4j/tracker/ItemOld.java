package ru.job4j.tracker;

public class ItemOld implements Comparable<Item> {
    private int id;
    private String name;

    public ItemOld() {
    }

    public ItemOld(String name) {
        this.name = name;
    }

    public ItemOld(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }

    @Override
    public int compareTo(Item o) {
        return name.compareTo(o.getName());
    }
}
