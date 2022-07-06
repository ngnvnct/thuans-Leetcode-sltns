import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class fibonacci_number {
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
        return fib(n-1) + fib(n-2);
    }

    public int fibMath(int n) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(goldenRatio, n) / Math.sqrt(5));
    }

    @Test
    public void testFib() {
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));
        assertEquals(3, fib(4));
        assertEquals(832040, fib(30));
        assertEquals(1, fib2(2));
        assertEquals(2, fib2(3));
        assertEquals(3, fib2(4));
        assertEquals(832040, fib2(30));
        assertEquals(1, fibMath(2));
        assertEquals(2, fibMath(3));
        assertEquals(3, fibMath(4));
        assertEquals(832040, fibMath(30));
        assertEquals(1, fibRecursion(2));
        assertEquals(2, fibRecursion(3));
        assertEquals(3, fibRecursion(4));
        assertEquals(832040, fibRecursion(30));
    }
}

/*
 * https://leetcode.com/problems/fibonacci-number/
 * Explanation:
 * 
 * Use Dynamic Programming to store expensive calculation (memoization). Have a
 * base case, then start with smaller values, and build a larger value using
 * them.
 * 
 * The math solution is about some guy name Binet's and the golden ratio
 * 
 * Time: O(n)
 * Space: O(1)
 */
