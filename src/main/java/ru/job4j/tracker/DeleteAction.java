package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private static final String MSG_ID = "Введите id: ";
    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удаление заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Удаление заявки ===");
        int id = input.askInt(MSG_ID);
        if (!tracker.delete(id)) {
            output.println("Ошибка удаления заявки.");
            return false;
        }
        System.out.println("Заявка удалена успешно.");
        return true;
    }
}
