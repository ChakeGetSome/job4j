package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Convert2DArrayTo1DArrayTest {
    @Test
    public void Convert2DArrayTo1D() {
        Convert2DArrayTo1DArray Convert = new Convert2DArrayTo1DArray();
        int[][] input = new int[][] {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        int[] result = Convert2DArrayTo1DArray.Convert(input);
        int[] expect = new int[] {1, 2, 3, 4, 5, 6};
        assertThat(result, is(expect));
    }
}