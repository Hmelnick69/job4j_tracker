package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.input.Input;
import ru.job4j.input.MockInput;
import ru.job4j.output.Output;
import ru.job4j.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("1");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultiValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"1", "2", "3", "10"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
        int selectedTwo = input.askInt("Two");
        assertThat(selectedTwo).isEqualTo(2);
        int selectedThree = input.askInt("Three");
        assertThat(selectedThree).isEqualTo(3);
        int selectedTen = input.askInt("Ten");
        assertThat(selectedTen).isEqualTo(10);
    }

    @Test
    void whenNegativeNumberInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
}
}