package ru.job4j.array;
/**
 * @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    public int[] back(int[] array) {
        int n = array.length;
        for (int i = 0; i < n/2; i++) {
           int temp = array[n-i-1];
            array[n-i-1] = array[i];
            array[i] = temp;
        }
        return array;
    }
}