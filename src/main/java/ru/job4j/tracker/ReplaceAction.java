package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private static final String MSG_ID = "Введите id: ";
    private static final String MSG_NAME = "Введите имя: ";

    @Override
    public String name() {
        return "Редактирование заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Редактирование заявки ===");
        int id = input.askInt(MSG_ID);
        String name = input.askStr(MSG_NAME);
        Item item = new Item(name);
        if (!tracker.replace(id, item)) {
            System.out.println("Ошибка замены заявки.");
            return false;
        }
        System.out.println("Заявка изменена успешно.");
        return true;
    }
}
