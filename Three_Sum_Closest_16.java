import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Three_Sum_Closest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length && diff != 0; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                int closestThreeSum = target - threeSum;
                if (Math.abs(diff) > Math.abs(closestThreeSum)) {
                    diff = closestThreeSum;
                }
                if (threeSum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return target-diff;
    }

    @Test
    public void testThreeSumClosest() {
        assertEquals(-2, threeSumClosest(new int[] {-1,2,1-4}, 1));
        assertEquals(0, threeSumClosest(new int[] {0,0,0}, 1));
    }
}

/*
https://leetcode.com/problems/3sum-closest/
Explanation

Similar to three sum

Time: O(n^2)
Space: O(log n) or O(n), depends on sorting
*/