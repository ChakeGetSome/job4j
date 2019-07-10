package ru.job4j.tracker;

public class UpdateItem extends BaseAction {

    public UpdateItem(int update, String message) {
        super(update, message);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Update item --------------");
        String id = input.ask("Please, provide item Id: ");
        if (tracker.findById(id) != null) {
            String name = input.ask("Please, provide new item's name: ");
            String desc = input.ask("Please, provide new item's description: ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.replace(id, item);
            System.out.println(String.format("------------ Item with Id : %s was updated.", id));
        } else {
            System.out.println("------------ There is no item with such id --------------");
        }
    }
}