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
        int CurrentArrayLenght = array.length - 1;
        while (CurrentArrayLenght > 0) {
            for (int i = 0; i < CurrentArrayLenght; i++) {
                for (int j = 0; j <= i; j++) {
                    if (array[i] > array[i + 1]) {
                        int tmp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = tmp;
                    }

                }
            }
            CurrentArrayLenght--;
        }
        return array;
    }
}