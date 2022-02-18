import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class min_value_positive_step {
    public int minStartValue(int[] nums) {
        int x = 1;
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            if (currSum < 1) {
                x = Math.max(x, -currSum+1);
            }
        }
        return x;
    }

    @Test
    public void testMinStartValue() {
        int[] exampleOne = {-3,2,-3,4,2};
        int[] exampleTwo = {1,2};
        int[] exampleThree = {1,-2,-3};
        assertEquals(5, minStartValue(exampleOne));
        assertEquals(1, minStartValue(exampleTwo));
        assertEquals(5, minStartValue(exampleThree));
    }
}

/*
Explanation
Loop through the array and get the current Sum. if current Sum is less than 1 (non positive), take the max of -currentSum + 1 and assign to x

Time: O(n)
Space: O(1)
Asked by Galileo
*/