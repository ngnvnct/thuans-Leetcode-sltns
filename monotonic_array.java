import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class monotonic_array {
    public boolean isMonotonic(int[] nums) {
        if (nums == null || nums.length == 1) {
            return true;
        }
        boolean increase = true;
        boolean decrease = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                decrease = false;
            } else if (nums[i-1] > nums[i]) {
                increase = false;
            }
        }
        return increase || decrease;
    }
    
    @Test
    public void testMonotonic() {
        int[] one = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        int[] two = {};
        int[] three = {1};
        int[] four = {1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 7, 9, 10, 11};
        assertEquals(true, isMonotonic(one));
        assertEquals(true, isMonotonic(two));
        assertEquals(true, isMonotonic(three));
        assertEquals(false, isMonotonic(four));
    }
}

/*
Explanation

A naive solution is do two pass, but you can iterate it one pass. Just have two boolean variables to check if it is monotone increasing or monotone decreasing.
At the end returns decrease OR increase

Time: O(n)
Space: O(1)
*/