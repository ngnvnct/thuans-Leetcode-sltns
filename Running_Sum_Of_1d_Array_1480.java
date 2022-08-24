import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Running_Sum_Of_1d_Array_1480 {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }

    public int[] runningSum2(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] += res[i - 1] + nums[i];
        }
        return res;
    }

    @Test
    public void testRunningSum() {
        assertArrayEquals(new int[] { 1, 3, 6, 10 }, runningSum(new int[] { 1, 2, 3, 4 }));
        assertArrayEquals(new int[] { 1, 3, 6, 10 }, runningSum2(new int[] { 1, 2, 3, 4 }));
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, runningSum(new int[] { 1, 1, 1, 1, 1 }));
        assertArrayEquals(new int[] { 3, 4, 6, 16, 17 }, runningSum2(new int[] { 3, 1, 2, 10, 1 }));
    }
}

/*
 * Part of Leetcode75
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * Explanation
 * 
 * There is a solution which use the input array and modify it, not ideal. Can
 * start the loop at 0 or 1 it doesn't matter
 * For solution 1 there is one extra calculation, other than that pretty
 * obvious.
 * 
 * Time: O(n)
 * Space: O(1) if we don't care about output array, O(n) otherwise
 */