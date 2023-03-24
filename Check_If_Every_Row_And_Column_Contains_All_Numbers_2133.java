import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class Check_If_Every_Row_And_Column_Contains_All_Numbers_2133 {
    public boolean checkValid(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length; // it doesn't matter since it is n x 2

        for (int i = 0; i < row; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < col; j++) {
                if (!rowSet.add(matrix[i][j]) || !colSet.add(matrix[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkValid2(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            rowSet = new HashSet<>();
            for (int j = 0; j < col; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != matrix.length) {
                return false;
            }
        }

        for (int i = 0; i < col; i++) {
            colSet = new HashSet<>();
            for (int j = 0; j < row; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() != matrix.length) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testMatrix() {
        int[][] testCase1 = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };
        int[][] testCase2 = { { 1, 1, 1 }, { 1, 2, 3 }, { 1, 2, 3 } };

        assertTrue(checkValid(testCase1));
        assertFalse(checkValid(testCase2));
        
        assertTrue(checkValid2(testCase1));
        assertFalse(checkValid2(testCase2));
    }
}

/*
 * https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
 * Explanation
 * 
 * 1. Make a row set and a col set and add the element at the row col index into
 * the hash set, if it sees a duplicate it won't add it, so we return false
 * 2. Method 2 might be easier to read, at each row or col we add all the
 * element in it, and at the end we check if it equals to the length, return
 * false if it is not
 * 
 * There is a bit set method to be revisit at another time
 * 
 * Time: O(m + n)
 * Space: O(n)
 */