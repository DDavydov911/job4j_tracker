package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery() {
    }

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery energizer = new Battery(100);
        Battery Cosmos = new Battery(30);
        System.out.println("Energizer: " + energizer.load + ", Cosmos: " + Cosmos.load);
        Cosmos.exchange(energizer);
        System.out.println("Energizer: " + energizer.load + ", Cosmos: " + Cosmos.load);
    }
}
