package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[size];
        int index = 0;
        for (Item item : items) {
            if (item != null) {
                itemsWithoutNull[index++] = item;
            }
            if (index == size) {
                break;
            }
        }
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] itemsWithKey = new Item[size];
        int index = 0;
        for (Item item: items) {
            if (item != null && key.equals(item.getName())) {
                itemsWithKey[index++] = item;
            }
            if (index == size) {
                break;
            }
        }
        return Arrays.copyOf(itemsWithKey, index);
    }
}