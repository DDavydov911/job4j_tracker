package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void run() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int num) {
        System.out.println("Количество пассажиров: " + num);
    }

    @Override
    public double refuel(double liters) {
        return 45.90;
    }
}
