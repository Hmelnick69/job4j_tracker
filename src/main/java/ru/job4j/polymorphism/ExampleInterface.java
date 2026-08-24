package ru.job4j.polymorphism;

public interface ExampleInterface {

    class ExampleClass {
        // код класса
    }

    interface InnerExampleInterface {
        // код интерфейса, интерфейс может быть вложенным, и сам содержать вложенные классы
        public static final int WHEELS = 4;

        void example();

        enum MoneyType {
            RUB, USD, EUR
        }
    }

}
