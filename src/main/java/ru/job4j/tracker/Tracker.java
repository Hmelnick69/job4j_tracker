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
        Item result = null;
        for (int index = 0; index < this.size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int temp = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                result[temp] = item;
                temp++;
            }
        }

        return Arrays.copyOf(result, temp);
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item != null) {
                result[index] = item;
            }
        }
        return Arrays.copyOf(result, size);
    }
}