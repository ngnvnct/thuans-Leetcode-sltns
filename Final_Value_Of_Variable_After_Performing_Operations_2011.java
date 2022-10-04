import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Final_Value_Of_Variable_After_Performing_Operations_2011 {
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
        String[] exampleOne = {"--X","X++","X++"};
        int exampleOneExpectedResult = 1;
        String[] exampleTwo = {"++X","++X","X++"};
        int exampleTwoExpectedResult = 3;
        String[] exampleThree = {"X++","++X","--X","X--"};
        int exampleThreeExpectedResult = 0;

        assertEquals(exampleOneExpectedResult, finalValueAfterOperations(exampleOne));
        assertEquals(exampleTwoExpectedResult, finalValueAfterOperations(exampleTwo));
        assertEquals(exampleThreeExpectedResult, finalValueAfterOperations(exampleThree));

        assertEquals(exampleOneExpectedResult, finalValueAfterOperations2(exampleOne));
        assertEquals(exampleTwoExpectedResult, finalValueAfterOperations2(exampleTwo));
        assertEquals(exampleThreeExpectedResult, finalValueAfterOperations2(exampleThree));
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
