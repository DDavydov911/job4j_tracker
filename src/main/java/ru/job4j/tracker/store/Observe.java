package ru.job4j.tracker.store;

public interface Observe<T> {
    void receive(T model);
}
