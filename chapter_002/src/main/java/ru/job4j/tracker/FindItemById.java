package ru.job4j.tracker;

public class FindItemById implements UserAction{
    private final int find;
    private String message;

    public FindItemById(int findById, String message) {
        this.find = findById;
        this.message = message;
    }
    @Override
    public int key() {
        return find;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Finding item by id--------------");
        String id = input.ask("Please, provide item Id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(String.format("------------ Item with Id : %s, Name : %s, Description : %s",id, item.getName(), item.getDesc()));

        } else {
            System.out.println("------------ There is no item with such id --------------");
        }
    }

    @Override
    public String info() {
        return message;
    }
}