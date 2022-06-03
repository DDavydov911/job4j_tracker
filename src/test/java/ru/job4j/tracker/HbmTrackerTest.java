package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.City;
import ru.job4j.tracker.store.CityStore;

import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void add() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item("item1");
        hbmTracker.add(item1);
        List<Item> all = hbmTracker.findAll();
        assertEquals(item1, all.get(0));
    }

    @Test
    public void replace() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        hbmTracker.add(item1);
        hbmTracker.replace(1, item2);
        assertEquals(item2, hbmTracker.findById(1));
    }

    @Test
    public void delete() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item("item1");
        hbmTracker.add(item1);
        assertTrue(hbmTracker.delete(1));
    }

    @Test
    public void whenFindAll() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        hbmTracker.add(item1);
        hbmTracker.add(item2);
        assertEquals(List.of(item1, item2), hbmTracker.findAll());
    }

    @Test
    public void whenFindByName() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        hbmTracker.add(item1);
        hbmTracker.add(item2);
        assertEquals(List.of(item1), hbmTracker.findByName("item1"));
        assertEquals(List.of(item2), hbmTracker.findByName("item2"));
    }

    @Test
    public void findById() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        hbmTracker.add(item1);
        hbmTracker.add(item2);
        assertEquals(item1, hbmTracker.findById(1));
        assertEquals(item2, hbmTracker.findById(2));
    }
}