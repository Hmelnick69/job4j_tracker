package ru.job4j.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Execution(ExecutionMode.CONCURRENT)

public class ShopDropTest {
    @Test
    public void whenDropLast() {
        Product[] products = {
                new Product("Milk", 10),
                new Product("Bread", 4)
        };
        Product[] result = ShopDrop.delete(products, 1);
        Product[] expected = {
                new Product("Milk", 10),
                null
        };
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenArrayLengthIs4AndDeleteElementWithIndex1() {
        Product[] products = {
                new Product("Bread", 4),
                new Product("Egg", 10),
                new Product("Milk", 2),
                new Product("Fish", 3)
        };
        Product[] result = ShopDrop.delete(products, 1);
        Product[] expected = {
                new Product("Bread", 4),
                new Product("Milk", 2),
                new Product("Fish", 3),
                null
        };

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenArrayLengthIs5AndDeleteElementWithIndex2() {
        Product[] products = {
                new Product("Bread", 4),
                new Product("Egg", 10),
                new Product("Milk", 2),
                new Product("Fish", 3),
                new Product("Fruit", 8)
        };
        Product[] result = ShopDrop.delete(products, 2);
        Product[] expected = {
                new Product("Bread", 4),
                new Product("Egg", 10),
                new Product("Fish", 3),
                new Product("Fruit", 8),
                null
        };
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenArrayLengthIs3AndLastIsNullDeleteFirst() {
        Product[] products = {
                new Product("Bread", 4),
                new Product("Egg", 10),
                null
        };
        Product[] result = ShopDrop.delete(products, 0);
        Product[] expected = {
                new Product("Egg", 10),
                null,
                null
        };
        assertThat(result).isEqualTo(expected);
    }
}