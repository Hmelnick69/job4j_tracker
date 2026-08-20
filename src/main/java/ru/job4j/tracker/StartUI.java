package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item(1, "first");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(item
                .getCreated()
                .format(formatter));
        Item toStringDemo = new Item(1, "second");
        System.out.println(toStringDemo);
    }
}