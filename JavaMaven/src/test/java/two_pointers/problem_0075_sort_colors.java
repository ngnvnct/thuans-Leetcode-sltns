/*
 * https://leetcode.com/problems/sort-colors/
 * Explanation:
 * 
 * The two passes solution use counting sort, count the number of 0 and 1 and
 * fill the array with it.
 * 
 * The one pass solution uses two pivot point. We have a current index, a zero
 * index and a two index (end of the array, decrement each time)
 * if the current num is 0, we swap it with the element at zero index and
 * increment both current and zero
 * else if the current num is 2, we swap it with the element at two index (end
 * of the array) and ONLY decrement the two index
 * else the current num is 1, we just increment the current index
 * 
 * Time: O(n)
 * Space: O(n) if count input array, O(1) otherwise
 */

package two_pointers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class problem_0075_sort_colors {
    public void sortColors(int[] nums) {
        int countZero = 0;
        int countOne = 0;

        for (int num : nums) {
            if (num == 0) {
                countZero++;
            } else if (num == 1) {
                countOne++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < countZero) {
                nums[i] = 0;
            } else if (i < countZero + countOne) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public int[] testSortColor(int[] nums) {
        sortColors(nums);
        return nums;
    }

    public void sortColorsOnePass(int[] nums) {
        int zeroIndex = 0;
        int currIndex = 0;
        int twoIndex = nums.length - 1;

        while (currIndex <= twoIndex) {
            if (nums[currIndex] == 0) {
                int temp = nums[currIndex];
                nums[currIndex++] = nums[zeroIndex];
                nums[zeroIndex++] = temp;
            } else if (nums[currIndex] == 2) {
                int temp = nums[currIndex];
                nums[currIndex] = nums[twoIndex];
                nums[twoIndex--] = temp;
            } else {
                currIndex++;
            }
        }
    }

    public int[] testSortColorOnePass(int[] nums) {
        sortColorsOnePass(nums);
        return nums;
    }

    @Test
    public void testSortColor() {
        int[] testCase1 = { 2, 0, 1, 0, 1, 2 };
        int[] testCase1ExpectedResult = { 0, 0, 1, 1, 2, 2 };
        int[] testCase2 = { 2, 1, 0 };
        int[] testCase2ExpectedResult = { 0, 1, 2 };

        assertArrayEquals(testCase1ExpectedResult, testSortColor(testCase1));
        assertArrayEquals(testCase2ExpectedResult, testSortColor(testCase2));
    }

    @Test
    public void testSortColorOnePass() {
        int[] testCase1 = { 2, 0, 1, 0, 1, 2 };
        int[] testCase1ExpectedResult = { 0, 0, 1, 1, 2, 2 };
        int[] testCase2 = { 2, 1, 0 };
        int[] testCase2ExpectedResult = { 0, 1, 2 };

        assertArrayEquals(testCase1ExpectedResult, testSortColorOnePass(testCase1));
        assertArrayEquals(testCase2ExpectedResult, testSortColorOnePass(testCase2));
    }
}