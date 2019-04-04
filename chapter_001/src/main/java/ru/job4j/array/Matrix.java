package ru.job4j.array;

/**
 * @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */

public class Matrix {
    /**
     * @param size размер матрицы.
     * @return Матрица с элементами таблици умножения.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}