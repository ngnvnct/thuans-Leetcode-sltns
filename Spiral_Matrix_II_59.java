import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Spiral_Matrix_II_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int counter = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // left to right
            for (int i = colBegin; i <= colEnd; i++) {
                res[rowBegin][i] = counter++;
            }
            rowBegin++;

            // top to bottom
            for (int i = rowBegin; i <= rowEnd; i++) {
                res[i][colEnd] = counter++;
            }
            colEnd--;

            // right to left
            for (int i = colEnd; i >= colBegin; i--) {
                res[rowEnd][i] = counter++;
            }
            rowEnd--;

            // bottom to top
            for (int i = rowEnd; i >= rowBegin; i--) {
                res[i][colBegin] = counter++;
            }
            colBegin++;
        }
        return res;
    }

    @Test
    public void testGenerateSpiralMatrix() {
        int[][] exampleOneExpectedResult = new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
        int[][] exampleTwoExpectedResult = new int[][] { { 1 } };

        assertArrayEquals(exampleOneExpectedResult, generateMatrix(3));
        assertArrayEquals(exampleTwoExpectedResult, generateMatrix(1));
    }
}

/*
 * https://leetcode.com/problems/spiral-matrix-ii/
 * Explanation
 * 
 * Similar to Spiral Matrix I https://leetcode.com/problems/spiral-matrix/
 * Traverse the layer by layer in spiral form, because we are creating a n x n
 * matrix, we don't need to check if the row and column still exist to prevent
 * duplication like in spiral matrix i
 * 
 * Time: O(m * n)
 * Space: O(1)
 */