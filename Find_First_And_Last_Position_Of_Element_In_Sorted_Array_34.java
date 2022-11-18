import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Find_First_And_Last_Position_Of_Element_In_Sorted_Array_34 {
    public int[] searchRange(int[] nums, int target) {
        int firstTargetIndex = firstOccur(nums, target);
        int lastTargetIndex = lastOccur(nums, target);
        if (lastTargetIndex - firstTargetIndex < 0) {
            return new int[] { -1, -1 };
        }
        return new int[] { firstTargetIndex, lastTargetIndex };
    }

    private int firstOccur(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int lastOccur(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    @Test
    public void testFirstLastPosition() {
        assertArrayEquals(new int[] { 3, 4 }, searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
        assertArrayEquals(new int[] { -1, -1 }, searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
        assertArrayEquals(new int[] { -1, -1 }, searchRange(new int[0], 0));
    }
}

/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Explanation
 * 
 * Very similar to
 * https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-
 * sorted-array/
 * Do a binary search to find the first occurence, then do a 2nd binary search
 * to find the last occurrence
 * 
 * If that target doesn't exist, doing lastTargetIndex - firstTargetIndex will
 * result in a negative number (lastTargetIndex goes to -1 (left side), and
 * firstTargetIndex goes out of bound (right side))
 * 
 * Time: O(log n)
 * Space: O(1)
 */