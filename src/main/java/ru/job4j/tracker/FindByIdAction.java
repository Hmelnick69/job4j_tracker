package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private static final String MSG_ID = "Введите id: ";

    @Override
    public String name() {
        return "Вывод заявки по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt(MSG_ID);
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
            return false;
        }
        System.out.println(item);
        return true;
    }
}
