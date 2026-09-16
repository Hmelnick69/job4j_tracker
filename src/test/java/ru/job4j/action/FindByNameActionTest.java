package ru.job4j.action;

import org.junit.jupiter.api.Test;
import ru.job4j.input.Input;
import ru.job4j.input.MockInput;
import ru.job4j.output.Output;
import ru.job4j.output.StubOutput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.assertj.core.api.Assertions.assertThat;

class FindByNameActionTest {

    @Test
    void whenFindByNameActionIsTrueAndHasItems() {
        Output output = new StubOutput();
        UserAction action = new FindByNameAction(output);
        Tracker tracker = new Tracker();
        tracker.add(new Item("First"));
        Input input = new MockInput(new String[]{"First"});
        boolean result = action.execute(input, tracker);
        assertThat(result).isTrue();
    }

    @Test
    void whenFindByNameActionIsFalseAndNoHasItems() {
        Output output = new StubOutput();
        UserAction action = new FindByNameAction(output);
        Tracker tracker = new Tracker();
        Input input = new MockInput(new String[]{"NotExist"});
        boolean result = action.execute(input, tracker);
        assertThat(result).isFalse();
    }

    @Test
    void whenHasItems() {
        Output output = new StubOutput();
        UserAction action = new FindByNameAction(output);
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("First"));
        Input input = new MockInput(new String[]{"First"});
        action.execute(input, tracker);
        assertThat(output.toString()).isEqualTo(
                first + System.lineSeparator()
                        + second + System.lineSeparator()
        );
    }

    @Test
    void whenNoHasItems() {
        Output output = new StubOutput();
        UserAction action = new FindByNameAction(output);
        Tracker tracker = new Tracker();
        Input input = new MockInput(new String[]{"NotExist"});
        action.execute(input, tracker);
        assertThat(output.toString()).isEqualTo(
                "Заявки с именем: NotExist не найдены." + System.lineSeparator()
        );
    }
}