package ru.job4j.array;
import java.util.Arrays;
/**
 * @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */
public class Convert2DArrayTo1DArray {

    public static void main(String[] args) {
        int[][] oldarr = {{1, 2}, {3, 4}, {5, 6}};
        int[] newArr = new int[oldarr.length * oldarr[0].length];
        for (int i = 0, index = 0; i < oldarr.length; i++) {
            for (int j = 0; j < oldarr[i].length; j++) {
                newArr[index++] = oldarr[i][j];
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}
