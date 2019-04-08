package ru.job4j.array;

/**
 * @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */

public class MatrixCheck {
    /**
     * @param data вадратный массив заполненный true или false.
     * @return результат проверки по диагонали.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
            if (data[0][data.length - 1] != data [i][data.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}