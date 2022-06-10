import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class unique_paths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsTwo(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsMath(int m, int n) {
        int N = m + n - 2;
        int K = m < n ? m - 1 : n - 1;

        long res = 1;
        for(int i = 1; i <= K; i++)
            res = res * (N - i + 1) / i;
        return (int) res;
    }

    public int uniquePathsBruteForce(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        int downMove = uniquePaths(m-1,n);
        int rightMove = uniquePaths(m, n-1);
        return downMove + rightMove;
    }

    @Test
    public void testPath() {
        assertEquals(3, uniquePaths(3, 2));
        assertEquals(28, uniquePaths(3, 7));
        assertEquals(3, uniquePathsTwo(3, 2));
        assertEquals(28, uniquePathsTwo(3, 7));

        assertEquals(3, uniquePathsMath(3, 2));
        assertEquals(28, uniquePathsMath(3, 7));
        assertEquals(3, uniquePathsBruteForce(3, 2));
        assertEquals(28, uniquePathsBruteForce(3, 7));
    }
}

/*
https://leetcode.com/problems/unique-paths/
Explanation
Using DP bottom up, sub-problem, how many way way starting [0][0] you can move right, and move down. 
{1,1,1,1,1}
{1,0,0,0,0}
{1,0,0,0,0}
First loop, going down, fill cell with 1
Second loop, going right, fill cell with 1
Third loop, do the calculation
dp[i-1][j] cell above
dp[i][j-1] cell to the left

Time: O(m * n)
Space: O(m * n)
*/