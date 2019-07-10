package ru.job4j.tracker;

public class ExitProgram extends BaseAction {
    private final StartUI ui;

    public ExitProgram(int exit, String message, StartUI ui) {
        super(exit, message);
        this.ui = ui;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------EXIT--------------");
        this.ui.stop();
    }
}