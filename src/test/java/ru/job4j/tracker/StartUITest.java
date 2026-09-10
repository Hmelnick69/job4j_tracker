package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.job4j.action.*;
import ru.job4j.input.Input;
import ru.job4j.input.MockInput;
import ru.job4j.output.Output;
import ru.job4j.output.StubOutput;

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
    void whenFindAllAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        Input input = new MockInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(output),  // индекс 0
                new ExitAction(output)      // индекс 1
        };
        new StartUI(output).init(input, tracker, actions);
        Item[] actionsArray = tracker.findAll();
        var printActions = "";
        for (Item item : actionsArray) {
            printActions += item.toString() + System.lineSeparator();
        }
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Показать все заявки" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Вывод всех заявок ===" + System.lineSeparator()
                        + printActions
                        + "Меню:" + System.lineSeparator()
                        + "0. Показать все заявки" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenFindById() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output),  // индекс 0
                new ExitAction(output)      // индекс 1
        };
        new StartUI(output).init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Вывод заявки по id" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + created + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Вывод заявки по id" + System.lineSeparator()
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
    void whenFindByName() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        Item secondItem = tracker.add(new Item("First"));
        Input input = new MockInput(
                new String[]{"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output),  // индекс 0
                new ExitAction(output)      // индекс 1
        };
        new StartUI(output).init(input, tracker, actions);
        Item[] createdActions = {item, secondItem};
        var printActions = "";
        for (Item items : createdActions) {
            printActions += items.toString() + System.lineSeparator();
        }
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Вывод заявок по имени" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + printActions
                        + "Меню:" + System.lineSeparator()
                        + "0. Вывод заявок по имени" + System.lineSeparator()
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

    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}