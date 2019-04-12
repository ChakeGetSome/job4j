package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = new String[]{"Array", "Duplicate", "Test", "Java", "Duplicate", "Array", "Test", "Duplicate"};
        String[] result = arrayDuplicate.remove(array);
        String[] expected = new String[]{"Array", "Duplicate", "Test", "Java"};
        assertThat(result, is(expected));
    }
}
