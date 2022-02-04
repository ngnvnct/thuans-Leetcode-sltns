import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class fibonacci_number {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int sum  = 0;
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

    @Test
    public void testFib() {
        int expected = 1;
        assertEquals(expected, fib(2));

        expected = 2;
        assertEquals(expected, fib(3));

        expected = 3;
        assertEquals(expected, fib(4));

        expected = 832040;
        assertEquals(832040, fib(30));
    }
}

/*
Explantion:

Use Dynamic Programming to store expensive calculation (memoization). Have a base case, then start with smaller values, and build a larger value using them.

Time: O(n),
Space: O(1),

*/
