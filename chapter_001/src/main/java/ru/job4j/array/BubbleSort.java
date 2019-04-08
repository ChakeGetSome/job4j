package ru.job4j.array;
/**
 * @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * @param array массив который нужно отсортировать.
     * @return отсортированный массив.
     */
    public int[] sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = 1; i < array.length - j; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array [i - 1];
                    array[i - 1] = temp;
                }
            }
        }
        return array;
    }
}