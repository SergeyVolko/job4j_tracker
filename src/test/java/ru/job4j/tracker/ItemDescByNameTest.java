package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemDescByNameTest  {

    @Test
    public void whenListSortThenRevers() {
        Item first = new Item("a");
        Item second = new Item("b");
        Item third = new Item("c");
        List<Item> items = new ArrayList<>();
        items.add(second);
        items.add(first);
        items.add(third);
        List<Item> expected = new ArrayList<>();
        expected.add(third);
        expected.add(second);
        expected.add(first);
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expected));
    }

}