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

    public int minStartValuePrefix(int[] nums) {
        int x = 0;
        int total = 0;
        for (int num : nums) {
            total += num;
            x = Math.min(x, total);
        }
        return -x+1;
    }

    @Test
    public void testMinStartValue() {
        int[] testCase1 = {-3,2,-3,4,2};
        int[] testCase2 = {1,2};
        int[] testCase3 = {1,-2,-3};
        assertEquals(5, minStartValue(testCase1));
        assertEquals(1, minStartValue(testCase2));
        assertEquals(5, minStartValue(testCase3));
    }
}

/*
Explanation
Loop through the array and get the current Sum. if current Sum is less than 1 (non positive), take the max of -currentSum + 1 and assign to x

Time: O(n)
Space: O(1)
Asked by Galileo
*/