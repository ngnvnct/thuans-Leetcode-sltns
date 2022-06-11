import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class max_abs_sum_subarray {
    public int maxAbsoluteSum(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSum = nums[0];
        int minEndingHere = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSum = Math.max(maxSum, maxEndingHere);
            minEndingHere = Math.min(nums[i], minEndingHere + nums[i]);
            minSum = Math.min(minSum, minEndingHere);
        }
        return Math.max(Math.abs(minSum), Math.abs(maxSum));
    }

    public int maxAbsoluteSumMath(int[] nums) {
        int currSum = 0;
        int min = 0;
        int max = 0;

        for (int num : nums) {
            currSum += num;
            min = Math.min(min, currSum);
            max = Math.max(max, currSum);
        }
        return max-min;
    }

    @Test
    public void testSum() {
        assertEquals(5, maxAbsoluteSum(new int[] {1,-3,2,3,-4}));
        assertEquals(8, maxAbsoluteSum(new int[] {2,-5,1,-4,3,-2}));
        assertEquals(5, maxAbsoluteSumMath(new int[] {1,-3,2,3,-4}));
        assertEquals(8, maxAbsoluteSumMath(new int[] {2,-5,1,-4,3,-2}));
    }
}

/*
https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
Explanation

It is a standard Kadane's algorithm problem that calculate max subarray. The key idea is the max absolute sum will be either the max sum or the min sum. 

There is also a math equation, Abs Subarray Sum = One Prefix Sum - the other prefix sum <= max prefix sum - min prefix sum

Time: O(n)
Space: O(1)
*/