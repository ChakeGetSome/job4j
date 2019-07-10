package ru.job4j.tracker;

public class AddItem extends BaseAction {

    public AddItem(int add, String message) {
        super(add, message);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name: ");
        String desc = input.ask("Please, provide item description: ");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        System.out.println(String.format("------------ New Item with Id : %s, Name : %s, Description : %s",item.getId(), item.getName(), item.getDesc()));
    }
}