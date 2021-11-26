package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void whenSortListThenNaturalSort() {
        Item first = new Item("a");
        Item second = new Item("b");
        Item third = new Item("c");
        List<Item> items = new ArrayList<>();
        items.add(second);
        items.add(third);
        items.add(first);
        List<Item> expect = new ArrayList<>();
        expect.add(first);
        expect.add(second);
        expect.add(third);
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(expect));
    }
}