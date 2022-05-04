import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class max_subarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    @Test
    public void testMaxSubarray() {
        int[] exampleOne = new int[] {-2,2,5,-11,6};
        int[] exampleTwo = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int[] exampleThree = new int[] {1};
        int[] exampleFour = new int[] {5,4,-1,7,8};
        assertEquals(7, maxSubArray(exampleOne));
        assertEquals(6, maxSubArray(exampleTwo));
        assertEquals(1, maxSubArray(exampleThree));
        assertEquals(23, maxSubArray(exampleFour));
    }
}

/*
Using Kadane's Algorithm, we loop through the array once and see if we should make a newSum or adding it to our currentSum

Time: O(n)
Space: O(1)
*/
