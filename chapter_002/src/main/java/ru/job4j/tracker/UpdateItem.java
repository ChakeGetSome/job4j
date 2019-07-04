package ru.job4j.tracker;

public class UpdateItem implements UserAction{
    private final int UPDATE;
    private String message;

    public UpdateItem(int UPDATE, String message) {
        this.UPDATE = UPDATE;
        this.message = message;
    }
    @Override
    public int key() {
        return UPDATE;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Update item --------------");
        String id = input.ask("Please, provide item Id: ");
        if(tracker.findById(id) != null) {
            String name = input.ask("Please, provide new item's name: ");
            String desc = input.ask("Please, provide new item's description: ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.replace(id, item);
            System.out.println(String.format("------------ Item with Id : %s was updated.", id));
        } else {
            System.out.println("------------ There is no item with such id --------------");
        }
    }

    @Override
    public String info() {
        return message;
    }
}