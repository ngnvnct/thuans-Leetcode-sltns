import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Spiral_Matrix_54 {

    public static void main(String[] args) {
        Spiral_Matrix_54 Solution = new Spiral_Matrix_54();
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Solution.spiralOrder(matrix).toString());

        int[][] matrixTwo = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(Solution.spiralOrder(matrixTwo).toString());

    }

    List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // left to right
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // top to bottom
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            // right to left
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // bottom to top
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }

    @Test
    public void testSpiralMatrix() {
        List<Integer> testCase1ExpectedResult = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
        List<Integer> testCase2ExpectedResult = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));

        assertEquals(testCase1ExpectedResult, spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
        assertEquals(testCase2ExpectedResult,
                spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
    }
}

/*
 * https://leetcode.com/problems/spiral-matrix/
 * Explanation
 * 
 * Think of it as the constraint shrinking
 * First, we move from left to right, so it will be rowBegin = 0
 * matrix[rowBegin][i], and i is the column that we want to move. Then we
 * increase the row begin
 * Then, we want to go from rowBegin to rowEnd (down), so it will be
 * matrix[i][colEnd] (because we want to do the last column). Then we decrease
 * the col end
 * When you traverse left or up, you need to check whether the row or col still
 * exists to prevent duplicates.
 * 
 * Time: O(m x n) where m is the number of rows and n is the number of columns
 * Space: O(1)
 */