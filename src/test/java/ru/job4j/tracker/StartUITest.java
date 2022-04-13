package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item 1", "1", "1", "New Item", "2"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new ReplaceAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("New Item"));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item 1", "1", "1", "2"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new DeleteAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(1));
    }

    @Test
    public void whenShowAction() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Item 2"));
        List<UserAction> actions = List.of(
                new ShowAction(output),
                new ExitAction()
        );
        String ls = System.lineSeparator();
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + ls
                        + "0. Show all items" + ls
                        + "1. Exit" + ls
                        + "=== Show all items ====" + ls
                        + item + ls
                        + "Menu." + ls
                        + "0. Show all items" + ls
                        + "1. Exit" + ls
                ));
    }

    @Test
    public void whenFindByIdAction() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Item 123"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> action = List.of(
                new FindByIdAction(output),
                new ExitAction()
        );
        String ls = System.lineSeparator();
        new StartUI(output).init(in, tracker, action);
        assertThat(output.toString(), is("Menu."  + ls
                + "0. Find item by id" + ls
                + "1. Exit" + ls
                + "=== Find item by id ===" + ls
                + item + ls
                + "Menu."  + ls
                + "0. Find item by id" + ls
                + "1. Exit" + ls));

    }

    @Test
    public void whenFindByNameAction() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Good Item"));
        Input in = new StubInput(
                new String[]{"0", item.getName(), "1"}
        );
        List<UserAction> actions = List.of(
                new FindByNameAction(output),
                new ExitAction()
        );
        String ls = System.lineSeparator();
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + ls
                + "0. Find items by name" + ls
                + "1. Exit" + ls
                + "=== Find items by name ====" + ls
                + item + ls
                + "Menu." + ls
                + "0. Find items by name" + ls
                + "1. Exit" + ls
        ));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"9", "0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        String ls = System.lineSeparator();
        assertThat(output.toString(), is("Menu." + ls
                + "0. Exit" + ls
                + "Wrong input, you can select: 0 .. 0" + ls
                + "Menu." + ls
                + "0. Exit" + ls
        ));
    }
}