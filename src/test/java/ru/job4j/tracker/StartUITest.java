package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input input = new MockInput(
                new String[]{"0", "New name", "1"}
        );
        UserAction[] actions = {
                new CreateAction(output),  // индекс 0
                new ExitAction(output)      // индекс 1
        };
        new StartUI(output).init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Добавить новую заявку" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Создание новой заявки ===" + System.lineSeparator()
                        + "Добавленная заявка: " + created + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Добавить новую заявку" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "New name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),  // индекс 0
                new ExitAction(output)      // индекс 1
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Редактирование заявки" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Редактирование заявки ===" + System.lineSeparator()
                        + "Заявка изменена успешно." + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Редактирование заявки" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),  // индекс 0
                new ExitAction(output)     // индекс 1
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Удаление заявки" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Удаление заявки ===" + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Удаление заявки" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }
}