package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    PrintStream stdout = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    StringBuilder menu = new StringBuilder()
            .append("Меню:")
            .append(System.lineSeparator())
            .append("0. Add new Item")
            .append(System.lineSeparator())
            .append("1. Show all Items")
            .append(System.lineSeparator())
            .append("2. Edit Item")
            .append(System.lineSeparator())
            .append("3. Delete Item")
            .append(System.lineSeparator())
            .append("4. Find Item by id")
            .append(System.lineSeparator())
            .append("5. Find Items by name")
            .append(System.lineSeparator())
            .append("6. Exit program")
            .append(System.lineSeparator());

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc2", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();

        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder(menu)
                                .append("------------ Все заявки --------------")
                                .append(System.lineSeparator())
                                .append("Name: " + item1.getName())
                                .append("  Description: " + item1.getDesc())
                                .append("  Create Time: " + item1.getTime())
                                .append(System.lineSeparator())
                                .append("Name: " + item2.getName())
                                .append("  Description: " + item2.getDesc())
                                .append("  Create Time: " + item2.getTime())
                                .append(System.lineSeparator())
                                .append(menu)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc2", System.currentTimeMillis()));
        Item item3 = tracker.add(new Item("test name1", "desc3", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", "test name1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder(menu)
                                .append("------------ Поиск заявок по имени --------------")
                                .append(System.lineSeparator())
                                .append("Name : " + item1.getName())
                                .append("    Description: " + item1.getDesc())
                                .append("    Create Time: " + item1.getTime())
                                .append(System.lineSeparator())
                                .append("Name : " + item3.getName())
                                .append("    Description: " + item3.getDesc())
                                .append("    Create Time: " + item3.getTime())
                                .append(System.lineSeparator())
                                .append(menu)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}