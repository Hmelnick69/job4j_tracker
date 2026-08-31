package ru.job4j.tracker;

public class StartUI {
    private static final String MSG_SELECT = "Выбрать :";
    private static final String MSG_ID = "Введите id: ";
    private static final String MSG_NAME = "Введите имя: ";

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt(MSG_SELECT);
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                findAllItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявок по имени ===");
        String name = input.askStr(MSG_NAME);
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Заявки с именем: " + name + " не найдены.");
            return;
        }
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявки по id ===");
        int id = input.askInt(MSG_ID);
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
            return;
        }
        System.out.println(item);
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        int id = input.askInt(MSG_ID);
        if (!tracker.delete(id)) {
            System.out.println("Ошибка удаления заявки.");
            return;
        }
        System.out.println("Заявка удалена успешно.");
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Редактирование заявки ===");
        int id = input.askInt(MSG_ID);
        String name = input.askStr(MSG_NAME);
        Item item = new Item(name);
        if (!tracker.replace(id, item)) {
            System.out.println("Ошибка замены заявки.");
            return;
        }
        System.out.println("Заявка изменена успешно.");
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("Хранилище еще не содержит заявок");
            return;
        }
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Создание новой заявки ===");
        String name = input.askStr(MSG_NAME);
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                "Удалить заявку", "Показать заявку по id", "Показать заявки по имени",
                "Завершить программу"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}