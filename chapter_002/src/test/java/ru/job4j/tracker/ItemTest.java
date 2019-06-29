package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemTest {
    @Test
    public void whenNameTest() {
        Item item = new Item("Test", "test", System.currentTimeMillis());
        String result = item.getName();
        assertThat(result, is("Test"));
    }
    @Test
    public void whenNameNotMatch() {
        Item item = new Item("Test", "test", System.currentTimeMillis());
        Boolean result = item.getName().equals("t");
        assertThat(result, is(false));
    }
    @Test
    public void whenDescTest() {
        Item item = new Item("Test", "test", System.currentTimeMillis());
        String result = item.getDesc();
        assertThat(result, is("test"));
    }
    @Test
    public void whenDescNotMatch() {
        Item item = new Item("Test", "test", System.currentTimeMillis());
        Boolean result = item.getDesc().equals("t");
        assertThat(result, is(false));
    }
    @Test
    public void whenTimeTest() {
        Item item = new Item("Test", "test", System.currentTimeMillis());
        long result = item.getTime();
        assertThat(result, is(System.currentTimeMillis()));
    }
    @Test
    public void whenTimeNotMatch() {
        Item item = new Item("Test", "test", System.currentTimeMillis());
        Boolean result = item.getTime() == System.currentTimeMillis() + 1L;
        assertThat(result, is(false));
    }
}