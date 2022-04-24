import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class max_nesting_depth_parentheses {

    public static void main(String[] args) {
        String one = "(1+(2*3)+((8)/4))+1";
        String two = "(1)+((2))+(((3)))";
        String three = "8*((1*(5+6))*(8/6))";

        max_nesting_depth_parentheses sol = new max_nesting_depth_parentheses();
        System.out.println(sol.maxDepth(one));
        System.out.println(sol.maxDepth(two));
        System.out.println(sol.maxDepth(three));
    }

    public int maxDepth(String s) {
        int currMax = 0;
        int maxDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                currMax++;
                maxDepth = Math.max(currMax, maxDepth);
            } else if (c == ')') {
                currMax--;
                if (currMax < 0) {
                    return -1;
                }
            }
        }
        if (currMax != 0) {
            return -1;
        }
        return maxDepth;
    }

    @Test
    public void testDepth() {
        String one = "(1+(2*3)+((8)/4))+1";
        String two = "(1)+((2))+(((3)))";
        String three = "8*((1*(5+6))*(8/6))";
        String four = "((())";

        assertEquals(3, maxDepth(one));
        assertEquals(3, maxDepth(two));
        assertEquals(3, maxDepth(three));
        assertEquals(-1, maxDepth(four));
    }
}

/*
Explanation
Ask by Facebook Phone
A naive solution is to use a stack, don't do that.
Just ignore digits and signs and only count the ( or )
Keep a variable currMax that is the Math.max of current max and max depth, everytime you see an open, you increment currMax and update a new max
If you see a close parentheses, decrement curr max

Not on leetcode, a facebook constraint is if a parentheses is unbalance, return -1, we have that if condition in the loop to terminate early
At the end of the loop, we have to check if currMax is 0, if it is not zero that means it is unbalance, return -1

Time: O(n)
Space: O(1)
*/