package ru.job4j.action;

import org.junit.jupiter.api.Test;
import ru.job4j.input.Input;
import ru.job4j.input.MockInput;
import ru.job4j.output.Output;
import ru.job4j.output.StubOutput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.assertj.core.api.Assertions.assertThat;

class FindByIdActionTest {

    @Test
    void whenFindByIdActionIsTrueAndHasItem() {
        Output output = new StubOutput();
        UserAction action = new FindByIdAction(output);
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First"));
        Input input = new MockInput(new String[]{String.valueOf(item.getId())});
        boolean result = action.execute(input, tracker);
        assertThat(result).isTrue();
    }

    @Test
    void whenFindByIdActionIsFalseAndNoHasItem() {
        Output output = new StubOutput();
        UserAction action = new FindByIdAction(output);
        Tracker tracker = new Tracker();
        Input input = new MockInput(new String[]{"1000"});
        boolean result = action.execute(input, tracker);
        assertThat(result).isFalse();
    }

    @Test
    void whenHasItem() {
        Output output = new StubOutput();
        UserAction action = new FindByIdAction(output);
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First"));
        Input input = new MockInput(new String[]{String.valueOf(item.getId())});
        action.execute(input, tracker);
        assertThat(output.toString()).isEqualTo(
                item + System.lineSeparator()
        );
    }

    @Test
    void whenNoHasItem() {
        Output output = new StubOutput();
        UserAction action = new FindByIdAction(output);
        Tracker tracker = new Tracker();
        Input input = new MockInput(new String[]{"1000"});
        action.execute(input, tracker);
        assertThat(output.toString()).isEqualTo(
                "Заявка с введенным id: 1000 не найдена." + System.lineSeparator()
        );
    }
}