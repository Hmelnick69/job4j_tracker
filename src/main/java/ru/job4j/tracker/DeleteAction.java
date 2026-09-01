package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private static final String MSG_ID = "Введите id: ";

    @Override
    public String name() {
        return "Удаление заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        int id = input.askInt(MSG_ID);
        if (!tracker.delete(id)) {
            System.out.println("Ошибка удаления заявки.");
            return false;
        }
        System.out.println("Заявка удалена успешно.");
        return true;
    }
}
