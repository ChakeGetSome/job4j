package ru.job4j.array;
import java.util.Arrays;
/**
 * @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * Метод должен обрезать все дупликаты строк и вернуть массив уникальных строк
     * @param array входящий массив
     * @return  Массив без дупликатов
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}