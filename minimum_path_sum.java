import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class minimum_path_sum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            int sum = dp[i-1][0] + grid[i][0];
            dp[i][0] = sum;
        }

        for (int i = 1; i < col; i++) {
            int sum = dp[0][i-1] + grid[0][i];
            dp[0][i] = sum;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    @Test
    public void testMinPathSum() {
        int[][] exampleOne = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] exampleTwo = {{1,2,3}, {4,5,6}};
        assertEquals(7, minPathSum(exampleOne));
        assertEquals(12, minPathSum(exampleTwo));
    }
}

/*abstract
Explanation
Similar to Unique Path. We filled the left side and down with its sum. Since you can only go left all the way, or down all the way for those column. Then, we loop i and j at 1, and take the minimum value
either we take the top cell or the cell to the left, finally our dp will contain the minimum path
1 3 1
1 5 1
4 2 1
Become
1 4 5
2
6

Finally
1 4 5
2 7 6
6 8 7

Time: O(n)
Space: O(n)
*/