import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class max_nesting_depth_parentheses {

    public static void main(String[] args) {
        String one = "(1+(2*3)+((8)/4))+1";
        String two = "(1)+((2))+(((3)))";
        String three = "8*((1*(5+6))*(8/6))";
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



*/