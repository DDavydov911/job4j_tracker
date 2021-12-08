package ru.job4j.tracker;

public class OverMemoryAction implements UserAction {
    private final Output out;

    public OverMemoryAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Переполнить память данными";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== OverFullMemory ====");
        for (int i = 0; i < 2_000_000_000; i++) {
            tracker.add(new Item("N" + i));
        }
        return true;
    }
}
