package ru.job4j.tracker;

public class DeleteItem implements UserAction{
    private final int DELETE;
    private String message;

    public DeleteItem(int DELETE, String message) {
        this.DELETE = DELETE;
        this.message = message;
    }
    @Override
    public int key() {
        return DELETE;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Delete item --------------");
        String id = input.ask("Please, provide item Id: ");
        if(tracker.delete(id)) {
            System.out.println(String.format("------------ Item with Id : %s was deleted.", id));
        } else {
            System.out.println("------------ There is no item with such id --------------");
        }
    }

    @Override
    public String info() {
        return message;
    }
}