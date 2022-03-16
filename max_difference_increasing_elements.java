import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class max_difference_increasing_elements {
    public int maximumDiff(int[] nums) {
        int min = nums[0];
        int diff = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                diff = Math.max(diff, nums[i]-min);
            } else {
                min = nums[i];
            }
        }
        return diff == 0 ? -1 : diff;
    }

    @Test
    public void testMaxDiff() {
        int[] one = {7,1,5,4};
        int[] two = {9,4,3,2};
        int[] three = {1,5,2,10};
        assertEquals(4, maximumDiff(one));
        assertEquals(-1, maximumDiff(two));
        assertEquals(9, maximumDiff(three));
    }
}

/*
Explanation
Keep a minimum value as we traverse through the array, if we find a new min, we update it, if current num is bigger than the min, we subtract it from the min
if diff doesn't change, return 

Time: O(n)
Space: O(1)
*/