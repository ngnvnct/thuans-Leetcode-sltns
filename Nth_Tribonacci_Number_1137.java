import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Nth_Tribonacci_Number_1137 {
    public int tribonacciSequence(int n) {
        int[] dp = new int[] { 0, 1, 1 };
        for (int i = 3; i <= n; i++) {
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        }
        return dp[n % 3];
    }

    @Test
    public void testTribonacci() {
        assertEquals(4, tribonacciSequence(4));
        assertEquals(1389537, tribonacciSequence(25));
    }
}

/*
 * https://leetcode.com/problems/n-th-tribonacci-number/
 * Explanation
 * 
 * The naive method is we create an array with n size, and write a loop where
 * you set F[n+3] = F[n] + F[n+1] + F[n+2] and return F[n].
 * The better solution is using dynamic programming and we set dp[0] = a, dp[1]
 * = b, dp[2] = c, then we loop from 3 to n
 * we use % to store the next iteration, so F(N+3) value would be store in
 * dp[0], after we calculate it, and F(N+4) would be store in dp[1], and F(N+5)
 * would be store in dp[2]
 * 
 * Time: O(n)
 * Space: O(1)
 * 
 */