import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Climbing_Stairs_70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int sum = 0;
        while (n > 2) {
            sum = a + b;
            a = b;
            b = sum;
            n--;
        }
        return sum;
    }

    public int climbStairsRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairsDP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    @Test
    public void testClimbStairs() {
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
        assertEquals(1836311903, climbStairs(45));
    }
}

/*
 * https://leetcode.com/problems/climbing-stairs/
 * Explantion:
 * Use Dynamic Programming to store expensive calculation (memoization). Have a
 * base case, then start with smaller values, and build a larger value usingthem.
 * 
 * Time: O(n), n is input
 * Space: O(1)
 * 
 * Dynamic Programming: O(n) time, O(n) space
 * Recursion: O(2^n) time, Space O(n)
 */
