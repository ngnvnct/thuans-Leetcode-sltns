import java.util.ArrayList;
import java.util.List;

public class spiral_matrix {

    public static void main (String[] args) {
        spiral_matrix Solution = new spiral_matrix();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Solution.spiralOrder(matrix).toString());

        int[][] matrixTwo = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(Solution.spiralOrder(matrixTwo).toString());

    }
    List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length-1;
        int colEnd = matrix[0].length-1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }

            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }
}

/*
Explanation
Think of it as the constraint shrinking
First, we move from left to right, so it will be rowBegin = 0 matrix[rowBegin][i], and i is the column that we want to move. Then we increase the row begin
Then, we want to go from rowBegin to rowEnd (down), so it will be matrix[i][colEnd] (because we want to do the last column). Then we decrease the col end
When you traverse left or up, you need to check whether the row or col still exists to prevent duplicates. 

*/