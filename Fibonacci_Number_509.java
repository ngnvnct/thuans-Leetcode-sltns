import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Fibonacci_Number_509 {
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
        int exampleOne = 2;
        int exampleOneExpectedResult = 1;
        int exampleTwo = 3;
        int exampleTwoExpectedResult = 2;
        int exampleThree = 4;
        int exampleThreeExpectedResult = 3;
        int exampleFour = 30;
        int exampleFourExpectedResult = 832040;

        assertEquals(exampleOneExpectedResult, fib(exampleOne));
        assertEquals(exampleTwoExpectedResult, fib(exampleTwo));
        assertEquals(exampleThreeExpectedResult, fib(exampleThree));
        assertEquals(exampleFourExpectedResult, fib(exampleFour));

        assertEquals(exampleOneExpectedResult, fib2(exampleOne));
        assertEquals(exampleTwoExpectedResult, fib2(exampleTwo));
        assertEquals(exampleThreeExpectedResult, fib2(exampleThree));
        assertEquals(exampleFourExpectedResult, fib2(exampleFour));

        assertEquals(exampleOneExpectedResult, fibMath(exampleOne));
        assertEquals(exampleTwoExpectedResult, fibMath(exampleTwo));
        assertEquals(exampleThreeExpectedResult, fibMath(exampleThree));
        assertEquals(exampleFourExpectedResult, fibMath(exampleFour));

        assertEquals(exampleOneExpectedResult, fibRecursion(exampleOne));
        assertEquals(exampleTwoExpectedResult, fibRecursion(exampleTwo));
        assertEquals(exampleThreeExpectedResult, fibRecursion(exampleThree));
        assertEquals(exampleFourExpectedResult, fibRecursion(exampleFour));
    }
}

/*
 * Also appears on AlgoExpert and Leetcode75
 * https://leetcode.com/problems/fibonacci-number/
 * Explanation
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
