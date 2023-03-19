/*
 * https://leetcode.com/problems/3sum-closest/description/ 
 * Explanation:
 * 
 * Similar to 3Sum, we would use the two pointers technique here. This requires a sorted Array
 * However, since this ideal triplet may not exist, we will track the smallest absolute difference
 * between the threeSum and the target
 * 
 * If diff is 0, this is our ideal triplet, break from the loop
 *
 * Time: O(n log n + n ^2) = O(n^2)
 * Space: O(log n) to O(n), depending on the implementation of the sorting algorithm
 */

package two_pointers;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_0016_3sum_closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length && diff != 0; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                int closestThreeSum = target - threeSum;
                if (Math.abs(diff) > Math.abs(closestThreeSum)) {
                    diff = closestThreeSum;
                }
                if (threeSum < target) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return target - diff;
    }

    @Test
    public void testThreeSumClosest() {
        int[] testCase1 = new int[] { -1, 2, 1 - 4 };
        int testCase1Target = 1;
        int testCase1ExpectedResult = -2;
        int[] testCase2 = new int[] { -1, 2, 1 - 4 };
        int testCase2Target = 0;
        int testCase2ExpectedResult = -2;
        int[] testCase3 = new int[] { 4, 0, 5, -5, 3, 3, 0, -4, -5 };
        int testCase3Target = -2;
        int testCase3ExpectedResult = -2;

        assertEquals(testCase1ExpectedResult, threeSumClosest(testCase1, testCase1Target));
        assertEquals(testCase2ExpectedResult, threeSumClosest(testCase2, testCase2Target));
        assertEquals(testCase3ExpectedResult, threeSumClosest(testCase3, testCase3Target));
    }
}