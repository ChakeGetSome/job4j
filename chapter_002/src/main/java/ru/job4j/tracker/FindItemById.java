package ru.job4j.tracker;

public class FindItemById extends BaseAction {

    public FindItemById(int findById, String message) {
        super(findById, message);
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
}