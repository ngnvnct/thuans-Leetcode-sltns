public class transpose_matrix {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[col][row];
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int colIndex = 0; colIndex < col; colIndex++) {
                res[rowIndex][colIndex] = matrix[colIndex][rowIndex];
            }
        }
        return res;
    }
}

/*
https://leetcode.com/problems/transpose-matrix/
Explanation
    [1 -2]
A = [3  0]
    [7  5]
A has 3 rows and 2 columns, 3x2 matrix

A(T) = 2 (rows) x 3 (cols) matrix 

A(T) = [1   3   7]
       [-2   0  5] 
can take 1 3 7 from the column and put them into the row

Transpose of a matrix = rows becomes columns, and columns become rows

Time: O(R x C) rows and cols
Space: O(R x C) row and cols
*/