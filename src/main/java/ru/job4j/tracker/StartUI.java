package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime timeItemCreate = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String timeItemCreateFormat = timeItemCreate.format(formatter);
        System.out.println(timeItemCreateFormat);
        item.setId(1);
        item.setName("Ivan");
        System.out.println(item);
    }
}
