package ru.job4j.tracker;

public class FindItemById implements UserAction{
    private final int FIND;
    private String message;

    public FindItemById(int FIND_By_ID, String message) {
        this.FIND = FIND_By_ID;
        this.message = message;
    }
    @Override
    public int key() {
        return FIND;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Finding item by id--------------");
        String id = input.ask("Please, provide item Id: ");
        Item item = tracker.findById(id);
        if(item != null) {
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