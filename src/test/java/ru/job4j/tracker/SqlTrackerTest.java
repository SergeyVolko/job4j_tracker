package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
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
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdAndReplaceThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item replaceItem = new Item("replace item");
        tracker.replace(item.getId(), replaceItem);
        assertThat(tracker.findById(item.getId()).getName(), is(replaceItem.getName()));
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdAndDeleteThenNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenSaveItemsAndFindAllThenListItem() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> items = List.of(
                tracker.add(new Item("item 1")),
                tracker.add(new Item("item 2"))
        );
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenSaveItemsAndFindByNameThenListItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item 1"));
        tracker.add(new Item("item 2"));
        List<Item> items = List.of(item1);
        assertThat(tracker.findByName("item 1"), is(items));
    }

    @Test
    public void whenSaveItemsAndFindByIdThenId() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item 1"));
        assertThat(tracker.findById(item.getId()), is(item));
    }
}