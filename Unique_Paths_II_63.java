import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Unique_Paths_II_63 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int[][] grid2 = { { 0, 1 }, { 0, 0 } };
        int[][] grid3 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        Unique_Paths_II_63 sol = new Unique_Paths_II_63();
        System.out.println("Print grid " + Arrays.deepToString(grid));
        System.out.println(sol.uniquePathsWithObstacles(grid));
        System.out.println(sol.uniquePathsWithObstacles(grid2));
        System.out.println(sol.uniquePathsWithObstacles(grid3));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else { // this is optional, in Java this cell is already 0, don't have to set it to 0
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void testGrid() {
        assertEquals(2, uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
        assertEquals(1, uniquePathsWithObstacles(new int[][] { { 0, 1 }, { 0, 0 } }));
    }
}

/*
 * https://leetcode.com/problems/unique-paths-ii/
 * Explanation
 * 
 * Very similar to unique path. It is essentialy a DP problem.
 * 
 * Using DP bottom up, sub-problem, how many way way starting [0][0] you can
 * move right, and move down.
 * {1,1,1,1,1}
 * {1,0,0,0,0}
 * {1,0,0,0,0}
 * First loop, going down, fill cell with 1
 * Second loop, going right, fill cell with 1
 * 
 * If there is an obstacle going right or going down, we break from the loop.
 * 
 * Third loop, do the calculation
 * dp[i-1][j] cell above
 * dp[i][j-1] cell to the left
 * 
 * But, the difference is that we have to check if the obstacle grid has a 1 in
 * it, if it exists a 1 then that cell has a solution of 0
 * In Java when you initialize an array, it fills with 0, by doing a check to
 * see if the obstacle grid is not 1, we can do the calculation, and doesn't
 * have to set that cell to 0
 * 
 * Time: O(m * n)
 * Space: O(m * n)
 */