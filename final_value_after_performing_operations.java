import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class final_value_after_performing_operations {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            char[] c = operation.toCharArray();
            if (c[1] == '-') {
                x--;
            } else {
                x++;
            }
        }
        return x;
    }

    public int finalValueAfterOperations2(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

    @Test
    public void testOperations() {
        String[] one = {"--X","X++","X++"};
        String[] two = {"++X","++X","X++"};
        String[] three = {"X++","++X","--X","X--"};

        assertEquals(1, finalValueAfterOperations(one));
        assertEquals(3, finalValueAfterOperations(two));
        assertEquals(0, finalValueAfterOperations(three));
        assertEquals(1, finalValueAfterOperations2(one));
        assertEquals(3, finalValueAfterOperations2(two));
        assertEquals(0, finalValueAfterOperations2(three));
    }
}

/*
Explanation

operations[i] will be either "++X", "X++", "--X", or "X--"

Because of this constraint, it will always be a valid input. Therefore, we can just check the 1st index whether it is '-' or '+', then update accordingly
Or, just take care of one operation "++X", "X++" using equals() method

Time: O(n)
Space: O(1)
*/
