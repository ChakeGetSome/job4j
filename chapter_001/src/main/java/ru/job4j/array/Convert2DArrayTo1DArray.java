package ru.job4j.array;
/**
 * @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */
public class Convert2DArrayTo1DArray {

    public static int []  Convert (int [][] oldarr) {
        int[] newArr = new int[oldarr.length * oldarr[0].length];
        for (int i = 0, index = 0; i < oldarr.length; i++) {
            for (int j = 0; j < oldarr[i].length; j++) {
                newArr[index++] = oldarr[i][j];
            }
        }
        return newArr;
    }
}
