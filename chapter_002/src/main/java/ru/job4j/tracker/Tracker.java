package ru.job4j.tracker;
import java.util.*;

/**
 * @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int count = 0; count < this.position; count++) {
            if (this.items != null && this.items[count].getId().equals(id)) {
                this.items[count] = item;
                this.items[count].setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int count2 = 0;
        for (int count = 0; count < this.position; count++) {
            if (items[count].getName().equals(key)) {
                result[count2++] = items[count];
            }
        }
        return Arrays.copyOf(result, count2);
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int count = 0; count < this.position; count++) {
            if (this.items != null && this.items[count].getId().equals(id)) {
                System.arraycopy(this.items, count + 1, this.items, count, this.position - count - 1);
                this.items[this.position - 1] = null;
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] == null) {
                break;
            }
        }
        return Arrays.copyOf(this.items, this.position);
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }

        }
        return result;
    }
}