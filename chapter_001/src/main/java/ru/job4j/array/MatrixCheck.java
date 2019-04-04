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
        int x = 1;
        for (int index = 1; index < data.length; index++) {
            if (data[0][0] != data[index][index]) {
                result = false;
                break;
            }
            if (data[data.length - 1][0] != data[data.length - index - 1][x]) {
                result = false;
            }
            x++;

        }
        return result;
    }
}