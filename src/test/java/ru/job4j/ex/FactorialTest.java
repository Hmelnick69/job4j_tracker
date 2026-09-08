package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)

class FactorialTest {

    @Test
    void whenCalcValid() {
        Factorial factorial = new Factorial();
        int number = 3;
        int expected = 6;
        int result = factorial.calc(number);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenException() {
        Factorial factorial = new Factorial();
        int number = -3;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    factorial.calc(number);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }
}