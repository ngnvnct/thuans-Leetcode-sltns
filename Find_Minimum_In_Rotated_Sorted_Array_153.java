import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Find_Minimum_In_Rotated_Sorted_Array_153 {
    public int findMinMethodOne(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right];

    }

    public int findMinMethodTwo(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    @Test
    public void testFindMin() {
        int[] testCase1 = { 3, 4, 5, 1, 2 };
        int testCase1ExpectedResult = 1;
        int[] testCase2 = { 4, 5, 6, 7, 0, 1, 2 };
        int testCase2ExpectedResult = 0;
        int[] testCase3 = { 11, 13, 15, 17 };
        int testCase3ExpectedResult = 11;

        assertEquals(testCase1ExpectedResult, findMinMethodOne(testCase1));
        assertEquals(testCase2ExpectedResult, findMinMethodOne(testCase2));
        assertEquals(testCase3ExpectedResult, findMinMethodOne(testCase3));

        assertEquals(testCase1ExpectedResult, findMinMethodTwo(testCase1));
        assertEquals(testCase2ExpectedResult, findMinMethodTwo(testCase2));
        assertEquals(testCase3ExpectedResult, findMinMethodTwo(testCase3));
    }
}

/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Explanation
 * 
 * Left and right both converge to min index. Main idea is to converge left and
 * right bounds on the start of the pivot. if nums[mid] > nums[right], at some
 * point to the right of mid, a pivot occur
 * use mid + 1 and never consider mid again because we know where is at least
 * one value smaller than it on the right, so we don't discard it by doing
 * mid-1, it still might have the minimum value.
 * Else, we know the pivot is at mid or to the left of mid
 * 
 * Time: O(logn)
 * Space: O(1)
 */