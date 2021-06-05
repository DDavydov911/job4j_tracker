package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

//    @Test
//    public void whenCreateItem() {
//        Input in = new StubInput(
//                new String[] {"0", "Item name", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(out),
//                new ExitAction()
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Input in = new StubInput(
//                new String[]{"0", "Item 1", "1", "1", "New Item", "2"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(out),
//                new ReplaceAction(),
//                new ExitAction()
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("New Item"));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Input in = new StubInput(
//                new String[]{"0", "Item 1", "1", "1", "2"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(out),
//                new DeleteAction(),
//                new ExitAction()
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertNull(tracker.findById(1));
//    }
//
//    @Test
//    public void whenFindByNameAction() {
//        Input in = new StubInput(
//                new String[]{"0", "Item 1", "1", "2"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(out),
//                new ShowAction(),
//                new ExitAction()
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertEquals("Item 1", tracker.findAll()[0].getName());
//    }
//
//    @Test
//    public void whenFindByIdAction() {
//        Input in = new StubInput(
//                new String[]{"0", "Item 1", "0", "Item 2", "1", "2", "2"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] action = {
//                new CreateAction(out),
//                new FindByIdAction(),
//                new ExitAction()
//        };
//        new StartUI(out).init(in, tracker, action);
//        assertEquals("Item 2", tracker.findById(2).getName());
//    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
}