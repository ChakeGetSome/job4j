package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        Item next = new Item("test2", "testDescription2", 1234L);
        Item next2 = new Item("test3", "testDescription3", 12345L);
        tracker.add(previous);
        tracker.add(next);
        tracker.add(next2);
        assertThat(tracker.delete(previous.getId()), is(true));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", System.currentTimeMillis());
        Item second = new Item("test2", "testDescription2", System.currentTimeMillis());
        tracker.add(first);
        tracker.add(second);
        Item[] expect = {first, second};
        assertThat(tracker.findAll(), is(expect));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", System.currentTimeMillis());
        Item second = new Item("test2", "testDescription2", System.currentTimeMillis());
        Item third = new Item("test1", "testDescription3", System.currentTimeMillis());
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        assertThat(tracker.findByName("test1"), is(new Item[] {first, third}));
    }
}