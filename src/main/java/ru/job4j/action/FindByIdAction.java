package ru.job4j.action;

import ru.job4j.input.Input;
import ru.job4j.output.Output;
import ru.job4j.tracker.*;

public class FindByIdAction implements UserAction {
    private final Output output;
    private static final String MSG_ID = "Введите id: ";

    public FindByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Вывод заявки по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt(MSG_ID);
        Item item = tracker.findById(id);
        if (item == null) {
            output.println("Заявка с введенным id: " + id + " не найдена.");
            return false;
        }
        output.println(item);
        return true;
    }
}
