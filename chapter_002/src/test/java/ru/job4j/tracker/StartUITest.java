package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StartUITest {
    private PrintStream stdout = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    Tracker tracker = new Tracker();
    StringBuilder menu = new StringBuilder()
            .append("0. Add item")
            .append(System.lineSeparator())
            .append("1. Show all items")
            .append(System.lineSeparator())
            .append("2. Update item")
            .append(System.lineSeparator())
            .append("3. Delete item")
            .append(System.lineSeparator())
            .append("4. Find item by id")
            .append(System.lineSeparator())
            .append("5. Find items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program")
            .append(System.lineSeparator());

    @Before
    public void init() {
        this.tracker.add(new Item("test name1", "desc1", System.currentTimeMillis()));
        this.tracker.add(new Item("test name2", "desc2", System.currentTimeMillis()));
        this.tracker.add(new Item("test name3", "desc3", System.currentTimeMillis()));
        System.setOut(new PrintStream(out));
    }
    @After
    public void back() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAskToShowAllItems() {
        StubInput input = new StubInput(new String[] {"1", "y"});
        new StartUI(input, this.tracker).init();
        Item[] items = tracker.findAll();
        StringBuilder expect = new StringBuilder();
        expect
                .append(this.menu.toString())
                .append("------------ All items --------------")
                .append(System.lineSeparator());
        for (int i = 0; i < items.length; i++) {
            expect
                    .append("------------ Item with Id : " + items[i].getId() + ", Name : " + items[i].getName() + ", Description : " + items[i].getDesc())
                    .append(System.lineSeparator());
        }
        assertThat(out.toString(), is(expect.toString()));
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item[] items = this.tracker.findAll();
        StubInput input = new StubInput(new String[] {"2", items[0].getId(), "test replace", "testing replace", "y"});
        new StartUI(input, this.tracker).init();
        StringBuilder expect = new StringBuilder();
        expect
                .append(this.menu.toString())
                .append("------------ Update item --------------")
                .append(System.lineSeparator())
                .append("------------ Item with Id : " + items[0].getId() + " was updated.")
                .append(System.lineSeparator());
        assertThat(out.toString(), is(expect.toString()));
    }

    @Test
    public void whenDeleteThenTrackerHasNoId() {
        Item[] items = this.tracker.findAll();
        String id = items[0].getId();
        StubInput input = new StubInput(new String[] {"3", id, "y"});
        new StartUI(input, this.tracker).init();
        StringBuilder expect = new StringBuilder();
        expect
                .append(this.menu.toString())
                .append("------------ Delete item --------------")
                .append(System.lineSeparator())
                .append("------------ Item with Id : " + id + " was deleted.")
                .append(System.lineSeparator());
        assertThat(out.toString(), is(expect.toString()));
    }
    @Test
    public void whenItemHasCurrentIdThenTrackerHasItem() {
        Item[] items = this.tracker.findAll();
        StubInput input = new StubInput(new String[] {"4", items[0].getId(), "y"});
        new StartUI(input, this.tracker).init();
        StringBuilder expect = new StringBuilder();
        expect
                .append(this.menu.toString())
                .append("------------ Finding item by id--------------")
                .append(System.lineSeparator())
                .append("------------ Item with Id : " + items[0].getId() + ", Name : " + items[0].getName() + ", Description : " + items[0].getDesc())
                .append(System.lineSeparator());
        assertThat(out.toString(), is(expect.toString()));
    }
    @Test
    public void whenItemsHaveCurrentNameThenTrackerReturnsItems() {
        StubInput input = new StubInput(new String[] {"5", "test name2", "y"});
        new StartUI(input, this.tracker).init();
        Item[] items = tracker.findByName("test name2");
        StringBuilder expect = new StringBuilder();
        expect
                .append(this.menu.toString())
                .append("------------ Finding items by name--------------")
                .append(System.lineSeparator())
                .append("------------ All items with name test name2--------------")
                .append(System.lineSeparator());
        for (int i = 0; i < items.length; i++) {
            expect
                    .append("------------ Item with Id : " + items[i].getId() + ", Name : " + items[i].getName() + ", Description : " + items[i].getDesc())
                    .append(System.lineSeparator());
        }
        assertThat(out.toString(), is(expect.toString()));
    }

}