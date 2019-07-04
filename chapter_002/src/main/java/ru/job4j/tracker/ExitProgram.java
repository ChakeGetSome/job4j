package ru.job4j.tracker;

public class ExitProgram implements UserAction{
    private final int EXIT;
    private String message;

    public ExitProgram(int EXIT, String message) {
        this.EXIT = EXIT;
        this.message = message;
    }
    @Override
    public int key() {
        return EXIT;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------EXIT--------------");
    }

    @Override
    public String info() {
        return message;
    }
}