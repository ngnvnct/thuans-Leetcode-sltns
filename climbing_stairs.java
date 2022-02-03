import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class climbing_stairs {
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

    @Test
    public void testClimbStairs() {
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
        assertEquals(1836311903, climbStairs(45));
    }
}

/*
Explantion:
Use Dynamic Programming to store expensive calculation (memoization). Have a base case, then start with smaller values, and build a larger value using them.

Time: O(n), n is input
Space: O(1)
*/
