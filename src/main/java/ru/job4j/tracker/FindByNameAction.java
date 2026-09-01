package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private static final String MSG_NAME = "Введите имя: ";

    @Override
    public String name() {
        return "Вывод заявок по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr(MSG_NAME);
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Заявки с именем: " + name + " не найдены.");
            return false;
        }
        for (Item item : items) {
            System.out.println(item);
        }
        return true;
    }
}
