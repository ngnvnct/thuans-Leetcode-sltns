import java.util.Arrays;

public class rotate_image {
    public static void main (String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate_image Solution = new rotate_image();
        Solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i< row; i++){
            for(int j = i; j < col; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i =0 ; i < row; i++){
            for(int j = 0; j < row/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][row-1-j];
                matrix[i][row-1-j] = temp;
            }
        } 
    }
}

/*
Explanation

1 2 3
4 5 6
7 8 9

First, we transpose the matrix, this only works with a perfect square
1 4 7
2 5 8
3 6 9

then we do two pointer approach and swap the first element of a row with the last element of the row
7 4 1
8 5 2
9 6 3

= Rotate
7 4 1
8 5 2
9 6 3

Time: O(M +M) = O(M). Transposing the matrix has a cost of O(M) because we're moving the value of each cell once. 
Reversing each row also has a cost of O(M), because again we're moving the value of each cell once.
Space: O(1)
*/