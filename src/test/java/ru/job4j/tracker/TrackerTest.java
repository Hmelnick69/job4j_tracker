package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item expected = tracker.add(new Item("First"));
        Item result = tracker.findById(expected.getId());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        Item[] expected = new Item[]{first, second};
        Item[] result = tracker.findAll();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First"));
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(first.getName());
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item second = tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item secondCopy = tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(second.getName());
        Item[] expected = {second, secondCopy};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Item item2 = new Item(item.getId(), "Bug with description");
        boolean result = tracker.replace(item.getId(), item2);
        Item found = tracker.findById(item.getId());
        assertThat(result).isTrue();
        assertThat(found).isEqualTo(item2);
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Item updateItem = new Item("Bug with description");
        boolean result = tracker.replace(1000, updateItem);
        Item found = tracker.findById(item.getId());
        assertThat(found).isEqualTo(item);
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        tracker.delete(item.getId());
        Item result = tracker.findById(item.getId());
        assertThat(result).isNull();
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        tracker.delete(1000);
        Item found = tracker.findById(item.getId());
        assertThat(found).isEqualTo(item);
    }
}