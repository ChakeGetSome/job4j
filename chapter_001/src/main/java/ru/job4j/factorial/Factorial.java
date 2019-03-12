package ru.job4j.factorial;

/**
 * @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */
public class Factorial {

    /**
     * @param n - число факториал которого надо вычислить
     * @return - факториал числа
     */

    public int calc(int n) {

        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}