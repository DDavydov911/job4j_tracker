package ru.job4j.tracker;

import org.junit.Test;
import java.util.Scanner;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        String[] answers = {"answer1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("answer1");
        assertThat(created.getName(), is(expected.getName()));
    }
}