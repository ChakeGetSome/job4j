package ru.job4j.array;
/**
 * @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */
public class Merge {
    /**
     * Метод для слияния двух отсортированных массивов
     * @param left первый отсортированный массив
     * @param right второй отсортированный массив
     * @return массив, получившийся в результате слияия первого и второго массива
     */
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int res = rsl.length;
        int one = left.length - 1;
        int two = right.length - 1;
        while (res-- > 0) {
            if (one == -1) {
                rsl[res] = right[two--];
            } else if ((two == -1) || (left[one] > right[two])) {
                rsl[res] = left[one--];
            } else {
                rsl[res] = right[two--];
            }
        }
        return rsl;
    }
}