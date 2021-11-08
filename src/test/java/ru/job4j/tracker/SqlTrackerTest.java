package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream(
                "test.properties"
        )) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenAddItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceItemAndFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("A1");
        tracker.add(item1);
        int id = item1.getId();
        Item item2 = new Item("B2");
        tracker.replace(id, item2);
        assertThat(tracker.findById(id), is(item2));
    }

    @Test
    public void whenAddAndDeleteItemFindByIdReturnsNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("J8");
        tracker.add(item);
        tracker.delete(item.getId());
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenAddItemAndFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("T4");
        tracker.add(item);
        List<Item> list = tracker.findByName(item.getName());
        assertThat(list.get(0), is(item));
    }

    @Test
    public void whenFindAllThenMustBeSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("G8");
        Item item2 = new Item("G20");
        tracker.add(item1);
        tracker.add(item2);
        List<Item> list = List.of(item1, item2);
        assertThat(tracker.findAll(), is(list));
    }
}
