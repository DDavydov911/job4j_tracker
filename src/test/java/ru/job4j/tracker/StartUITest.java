package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Input in = new StubInput(
                new String[]{"0", "Item 1", "1", "1", "New Item", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("New Item"));
    }

    @Test
    public void whenDeleteItem() {
        Input in = new StubInput(
                new String[]{"0", "Item 1", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertNull(tracker.findById(1));
    }

    @Test
    public void whenFindByNameAction() {
        Input in = new StubInput(
                new String[]{"0", "Item 1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertEquals("Item 1", tracker.findAll()[0].getName());
    }

    @Test
    public void whenFindByIdAction() {
        Input in = new StubInput(
                new String[]{"0", "Item 1", "0", "Item 2", "1", "2", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] action = {
                new CreateAction(),
                new FindByIdAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, action);
        assertEquals("Item 2", tracker.findById(2).getName());
    }
}