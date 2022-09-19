import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Maximum_Nesting_Depth_Of_The_Parentheses_1614 {

    public static void main(String[] args) {
        String exampleOne = "(1+(2*3)+((8)/4))+1";
        String exampleTwo = "(1)+((2))+(((3)))";
        String exampleThree = "8*((1*(5+6))*(8/6))";

        Maximum_Nesting_Depth_Of_The_Parentheses_1614 sol = new Maximum_Nesting_Depth_Of_The_Parentheses_1614();
        System.out.println(sol.maxDepth(exampleOne));
        System.out.println(sol.maxDepth(exampleTwo));
        System.out.println(sol.maxDepth(exampleThree));
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
        assertEquals(3, maxDepth("(1+(2*3)+((8)/4))+1"));
        assertEquals(3, maxDepth("(1)+((2))+(((3)))"));
        assertEquals(3, maxDepth("8*((1*(5+6))*(8/6))"));
        assertEquals(-1, maxDepth("((())"));
    }
}

/*
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 * Explanation
 * 
 * Ask by Facebook Phone
 * A naive solution is to use a stack, don't do that.
 * Just ignore digits and signs and only count the ( or )
 * Keep a variable currMax that is the Math.max of current max and max depth,
 * everytime you see an open, you increment currMax and update a new max
 * If you see a close parentheses, decrement curr max
 * 
 * Not on leetcode, a facebook constraint is if a parentheses is unbalance,
 * return -1, we have that if condition in the loop to terminate early
 * At the end of the loop, we have to check if currMax is 0, if it is not zero
 * that means it is unbalance, return -1
 * 
 * Time: O(n)
 * Space: O(1)
 */