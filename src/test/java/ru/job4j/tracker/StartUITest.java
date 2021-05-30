//package ru.job4j.tracker;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//import static org.hamcrest.core.Is.is;
//
//public class StartUITest {
//
//    @Test
//    public void whenCreateItem() {
//        String[] answers = {"answer1"};
//        Input input = new StubInput(answers);
//        Tracker tracker = new Tracker();
//        StartUI.createItem(input, tracker);
//        Item created = tracker.findAll()[0];
//        Item expected = new Item("answer1");
//        assertThat(created.getName(), is(expected.getName()));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("new item");
//        tracker.add(item);
//        String[] answers = {String.valueOf(item.getId()), "replaced item"};
//        StartUI.replaceItem(new StubInput(answers), tracker);
//        Item replaced = tracker.findById(item.getId());
//        assertThat(replaced.getName(), is("replaced item"));
//    }
//
//    @Test
//    public void deteleItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("item1");
//        tracker.add(item);
//        int id = item.getId();
//        String[] answers = {String.valueOf(item.getId())};
//        Input input = new StubInput(answers);
//        StartUI.deteleItem(input, tracker);
//        assertNull(tracker.findById(id));
//    }
//}