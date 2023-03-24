import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class Check_If_A_Number_Is_Majority_Element_In_A_Sorted_Array_1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        int counter = 0;
        int k = nums.length / 2;
        for (int num : nums) {
            if (num == target) {
                counter++;
            }
        }
        return counter > k;
    }

    public boolean isMajorityElementHash(int[] nums, int target) {
        int k = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.containsKey(target) ? map.get(target) > k : false;
    }

    public boolean isMajorityElementBinarySearch(int[] nums, int target) {
        int firstTargetIndex = firstOccur(nums, target);
        int lastTargetIndex = lastOccur(nums, target);
        int k = nums.length / 2;
        int numOfOccurence = lastTargetIndex - firstTargetIndex + 1;
        return numOfOccurence > k;
    }

    private int firstOccur(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
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
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return right;
    }

    @Test
    public void testMajority() {
        int[] testCase1 = { 2, 4, 5, 5, 5, 5, 5, 6, 6 };
        int[] testCase2 = { 10, 100, 101, 101 };

        assertTrue(isMajorityElement(testCase1, 5));
        assertFalse(isMajorityElement(testCase2, 101));

        assertTrue(isMajorityElementHash(testCase1, 5));
        assertFalse(isMajorityElementHash(testCase2, 101));

        assertTrue(isMajorityElementBinarySearch(testCase1, 5));
        assertFalse(isMajorityElementBinarySearch(testCase2, 101));
    }
}

/*
 * https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
 * Explanation
 * 
 * First method, linear search and get a counter. Return counter > nums.length /
 * 2
 * Second method, put it in a hash map and gets the number of occurence
 * Third method, we do a binary search, get the first occurence and the last
 * occurence. Then from there we can get the range of occurence then check for
 * majority
 * 
 * Time: O(n), O(n), O(logn)
 * Space: O(1), O(n), O(1)
 */