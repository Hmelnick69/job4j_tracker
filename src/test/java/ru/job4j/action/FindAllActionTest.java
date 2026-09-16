package ru.job4j.action;

import org.junit.jupiter.api.Test;
import ru.job4j.input.Input;
import ru.job4j.input.MockInput;
import ru.job4j.output.Output;
import ru.job4j.output.StubOutput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import static org.assertj.core.api.Assertions.assertThat;

class FindAllActionTest {

    @Test
    void whenFindAllActionsIsTrueAndHasActions() {
        Output output = new StubOutput();
        UserAction action = new FindAllAction(output);
        Tracker tracker = new Tracker();
        Item[] items = new Item[]{
                tracker.add(new Item("First")),
                tracker.add(new Item("Second"))
        };
        Input input = new MockInput(new String[]{"Mock Input"});
        boolean result = action.execute(input, tracker);
        assertThat(result).isTrue();
    }

    @Test
    void whenFindAllActionsIsFalseAndNoHasActions() {
        Output output = new StubOutput();
        UserAction action = new FindAllAction(output);
        Tracker tracker = new Tracker();
        Input input = new MockInput(new String[]{"Mock Input"});
        boolean result = action.execute(input, tracker);
        assertThat(result).isFalse();
    }

    @Test
    void whenHasAction() {
        Output output = new StubOutput();
        UserAction action = new FindAllAction(output);
        Tracker tracker = new Tracker();
        Input input = new MockInput(new String[]{"Mock Input"});
        Item[] items = new Item[]{
                tracker.add(new Item("First")),
                tracker.add(new Item("Second"))
        };
        action.execute(input, tracker);
        var printActions = "";
        var ln = System.lineSeparator();
        for (Item i : items) {
            printActions += i.toString() + System.lineSeparator();
        }
        assertThat(output.toString()).isEqualTo(
                "=== Вывод всех заявок ===" + ln
                + printActions
        );
    }

    @Test
    void whenNoHasAction() {
        Output output = new StubOutput();
        UserAction action = new FindAllAction(output);
        Tracker tracker = new Tracker();
        Input input = new MockInput(new String[]{"Mock Input"});
        action.execute(input, tracker);
        assertThat(output.toString()).isEqualTo(
                "=== Вывод всех заявок ===" + System.lineSeparator()
                        + "Хранилище еще не содержит заявок" + System.lineSeparator()
        );
    }
}