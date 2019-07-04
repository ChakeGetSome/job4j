package ru.job4j.tracker;

public class ShowItems implements UserAction{
    private final int SHOW;
    private String message;

    public ShowItems(int SHOW, String message) {
        this.SHOW = SHOW;
        this.message = message;
    }
    @Override
    public int key() {
        return SHOW;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if(items.length > 0) {
            System.out.println("------------ All items --------------");
            for (Item item : items) {
                System.out.println(String.format("------------ Item with Id : %s, Name : %s, Description : %s", item.getId(), item.getName(), item.getDesc()));
            }
        } else {
            System.out.println("------------ There are no items --------------");
        }
    }

    @Override
    public String info() {
        return message;
    }
}