import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class two_sum_closest_to_zero {
    public int twoSumClosest(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (Math.abs(minSum) > Math.abs(sum)) {
                    minSum = sum;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return minSum;
    }

    public int twoSumClosestSort(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int left = 0;
        int right = nums.length-1;
        int minSum = Integer.MAX_VALUE;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (Math.abs(minSum) > Math.abs(sum)) {
                minSum = sum;
                res[0] = left;
                res[1] = right;
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        return minSum;
    }

    @Test (timeout = 100)
    public void testTwoSumClosest() {
        int[] testCase1 = {1, 60, -10, 70, -80, 85};
        int[] testCase2 = {-8, -66, -60};
        int[] testCase3 = {-21,-67,-37,-18,4,-65};
        assertEquals(5, twoSumClosest(testCase1));
        assertEquals(-68, twoSumClosest(testCase2));
        assertEquals(-14, twoSumClosest(testCase3));
        assertEquals(5, twoSumClosestSort(testCase1));
        assertEquals(-68, twoSumClosestSort(testCase2));
        assertEquals(-14, twoSumClosestSort(testCase3));
    }
}

/*abstract
Explanation

Brute Force: two for loops and check for every two sum target, if the absolute value of minSum is less than currentSum, replace it
the result array is just if the question is about getting the two target index that has their sum closest to 0

Time: O(n ^2)
Space: O(1)

Optimmal Way: Sort the array and use two pointers technique, use the same absolute value technique, if sum is negative, move the left pointer, else move the right pointer

Time: O(n log n)
Space: O(n), some sorting has aux space, else O(1)
*/