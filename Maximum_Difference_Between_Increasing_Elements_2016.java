import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Maximum_Difference_Between_Increasing_Elements_2016 {
    public int maximumDiff(int[] nums) {
        int min = nums[0];
        int diff = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                diff = Math.max(diff, nums[i] - min);
            } else {
                min = nums[i];
            }
        }
        return diff == 0 ? -1 : diff;
    }

    @Test
    public void testMaxDiff() {
        assertEquals(4, maximumDiff(new int[] { 7, 1, 5, 4 }));
        assertEquals(-1, maximumDiff(new int[] { 9, 4, 3, 2 }));
        assertEquals(9, maximumDiff(new int[] { 1, 5, 2, 10 }));
    }
}

/*
 * https://leetcode.com/problems/maximum-difference-between-increasing-elements/
 * Explanation
 * 
 * Keep a minimum value as we traverse through the array, if we find a new min,
 * we update it, if current num is bigger than the min, we subtract it from the
 * min, if diff doesn't change, return
 * 
 * Time: O(n)
 * Space: O(1)
 */