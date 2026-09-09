package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.Assert;

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
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenException() {
        Factorial factorial = new Factorial();
        int number = -3;
        IllegalArgumentException exception = Assert.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    factorial.calc(number);
                });
        Assertions.assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }
}