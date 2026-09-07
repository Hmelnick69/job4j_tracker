package ru.job4j.action;

import ru.job4j.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.output.Output;
import ru.job4j.tracker.Tracker;

public class ReplaceAction implements UserAction {
    private final Output output;
    private static final String MSG_ID = "Введите id: ";
    private static final String MSG_NAME = "Введите имя: ";

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Редактирование заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Редактирование заявки ===");
        int id = input.askInt(MSG_ID);
        String name = input.askStr(MSG_NAME);
        Item item = new Item(name);
        if (!tracker.replace(id, item)) {
            output.println("Ошибка замены заявки.");
            return false;
        }
        output.println("Заявка изменена успешно.");
        return true;
    }
}
