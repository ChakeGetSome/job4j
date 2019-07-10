package ru.job4j.tracker;

public class DeleteItem extends BaseAction {

    public DeleteItem(int delete, String message) {
        super(delete, message);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Delete item --------------");
        String id = input.ask("Please, provide item Id: ");
        if (tracker.delete(id)) {
            System.out.println(String.format("------------ Item with Id : %s was deleted.", id));
        } else {
            System.out.println("------------ There is no item with such id --------------");
        }
    }
}