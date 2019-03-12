package ru.job4j.counter;
/**
 * @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * method add Подсчет суммы чётных чисел в диапазоне.
     * @param start - первое число диапозона
     * @param finish - второе число диапозона
     * @return возвращает сумму
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}