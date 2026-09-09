package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        var result = -1;
        /* цикл fori, поскольку нам надо найти индекс искомого элемента в массиве */
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                return result;
            }
        }
        throw new ElementNotFoundException("Element not found");
    }

    public static void main(String[] args) {
        String[] array = new String[]{"First", "Second", "Third"};
        String key = "First";
        try {
            System.out.println(indexOf(array, key));
        } catch (ElementNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

