package ru.job4j.poly;

public interface Transport {
    void  run();
    void passengers(int num);
    double refuel(double liters);
}
