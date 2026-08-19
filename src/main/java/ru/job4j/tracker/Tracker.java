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

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return (index != -1) ? items[index] : null;
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

    public boolean replace(int id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (item != null && index != -1) {
            item.setId(id);
            items[index] = item;
            result = true;
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            int start = index + 1;
            int distPos = index;
            int length = size - index - 1;
            System.arraycopy(items, start, items, distPos, length);
            items[size - 1] = null;
            size--;
        }
    }
}