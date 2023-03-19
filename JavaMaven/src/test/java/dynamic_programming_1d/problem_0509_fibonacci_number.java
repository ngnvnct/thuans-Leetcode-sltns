
/*
 * https://leetcode.com/problems/fibonacci-number/
 * Explanation:
 * 
 * Use Dynamic Programming to store expensive calculation (memoization). Have a
 * base case, then start with smaller values, and build a larger value using
 * them. You only need the previous two values so you don't need to store all of them
 * 
 * 
 * Time: O(n)
 * Space: O(1)
 */

package dynamic_programming_1d;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_0509_fibonacci_number {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int sum = 0;
        int[] memo = new int[2];
        memo[0] = 0;
        memo[1] = 1;
        while (n > 1) {
            sum = memo[0] + memo[1];
            memo[0] = memo[1];
            memo[1] = sum;
            n--;
        }
        return sum;
    }

    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = 0;
        while (n > 1) {
            sum = a + b;
            a = b;
            b = sum;
            n--;
        }
        return sum;
    }

    public int fibRecursion(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fibMath(int n) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(goldenRatio, n) / Math.sqrt(5));
    }

    @Test
    public void testFib() {
        int testCase1 = 2;
        int testCase1ExpectedResult = 1;
        int testCase2 = 3;
        int testCase2ExpectedResult = 2;
        int testCase3 = 4;
        int testCase3ExpectedResult = 3;
        int testCase4 = 30;
        int testCase4ExpectedResult = 832040;

        assertEquals(testCase1ExpectedResult, fib(testCase1));
        assertEquals(testCase2ExpectedResult, fib(testCase2));
        assertEquals(testCase3ExpectedResult, fib(testCase3));
        assertEquals(testCase4ExpectedResult, fib(testCase4));

        assertEquals(testCase1ExpectedResult, fib2(testCase1));
        assertEquals(testCase2ExpectedResult, fib2(testCase2));
        assertEquals(testCase3ExpectedResult, fib2(testCase3));
        assertEquals(testCase4ExpectedResult, fib2(testCase4));

        assertEquals(testCase1ExpectedResult, fibMath(testCase1));
        assertEquals(testCase2ExpectedResult, fibMath(testCase2));
        assertEquals(testCase3ExpectedResult, fibMath(testCase3));
        assertEquals(testCase4ExpectedResult, fibMath(testCase4));

        assertEquals(testCase1ExpectedResult, fibRecursion(testCase1));
        assertEquals(testCase2ExpectedResult, fibRecursion(testCase2));
        assertEquals(testCase3ExpectedResult, fibRecursion(testCase3));
        assertEquals(testCase4ExpectedResult, fibRecursion(testCase4));
    }
}
