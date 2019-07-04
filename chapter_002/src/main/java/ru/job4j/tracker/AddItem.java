package ru.job4j.tracker;

public class AddItem implements UserAction {
    private final int ADD;
    private String message;

    public AddItem(int ADD, String message) {
        this.ADD = ADD;
        this.message = message;
    }
    @Override
    public int key() {
        return ADD;
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

    @Override
    public String info() {
        return message;
    }
}