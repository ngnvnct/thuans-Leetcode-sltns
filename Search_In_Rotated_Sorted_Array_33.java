import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Search_In_Rotated_Sorted_Array_33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            // left sorted portion
            if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public int searchMethod2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int searchMethod3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    @Test
    public void testSearch() {
        int[] testCase1 = { 4, 5, 6, 7, 0, 1, 2 };
        int[] testCase2 = { 1 };
        
        assertEquals(4, search(testCase1, 0));
        assertEquals(-1, search(testCase1, 3));
        assertEquals(-1, search(testCase2, 0));
        assertEquals(4, searchMethod2(testCase1, 0));
        assertEquals(-1, searchMethod2(testCase1, 3));
        assertEquals(-1, searchMethod2(testCase2, 0));
    }
}

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Explanation
 * [4,5,6,7,0,1,2], we want to perform a binary search on it. Since it is
 * rotated sorted array, we know that there will be an ascending left portion,
 * and an ascending right portion.
 * In this example, nums[mid] = 7, then we check if nums[left] <= nums[mid], if
 * it is then we are searching the left portion
 * if target is bigger than or equal to nums[left], and smaller than mid,
 * meaning we don't care about the right portion, we shrink the window
 * 
 * Search 2, If nums[mid] == target, the job is done, return mid
 * Pivot element is larger than the first element in the array, i.e. the
 * subarray from the first element to the pivot is non-rotated, as shown in the
 * following graph.
 * If the target is located in the non-rotated subarray:
 * go left: `right = mid - 1`.
 * else go right left = mid + 1
 * Pivot element is smaller than the first element of the array, i.e. the
 * rotation index is somewhere between 0 and mid.
 * It implies that the sub-array from the pivot element to the last one is
 * non-rotated, as shown in the following graph.
 * - If the target is located in the non-rotated subarray:
 * go right: `start = mid + 1`.
 * 
 * - Otherwise: go left: `end = mid - 1`.
 * Time: O(log n)
 * Space: O(1)
 */