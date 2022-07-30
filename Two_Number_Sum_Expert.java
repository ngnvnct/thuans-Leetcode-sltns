import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Two_Number_Sum_Expert {
    public int[] twoNumberSum(int[] nums, int targetSum) {
        Set<Integer> set = new HashSet<>();

        for (int x : nums) {
            int y = targetSum - x;
            if (set.contains((y))) {
                return new int[] {y, x};
            }
            set.add(x);
        }
        return new int[0];
    }

    public int[] twoNumberSumSort(int[] nums, int targetSum) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int currSum = nums[left] + nums[right];
            
            if (currSum == targetSum) {
                return new int[] {nums[left], nums[right]};
            } else if (currSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    @Test
    public void testSum() {
        assertArrayEquals(new int[] {11, -1}, twoNumberSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10));
        assertArrayEquals(new int[] {4, 6}, twoNumberSum(new int[] {4, 6}, 10));
        assertArrayEquals(new int[] {4,1}, twoNumberSum(new int[] {4, 6, 1}, 5));
        assertArrayEquals(new int[] {6,-3}, twoNumberSum(new int[] {4, 6, 1, -3}, 3));
        assertArrayEquals(new int[0], twoNumberSum(new int[] {3,5,-4,8,11,1,-1,6}, 15));

        assertArrayEquals(new int[] {-1, 11}, twoNumberSumSort(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10));
        assertArrayEquals(new int[] {4, 6}, twoNumberSumSort(new int[] {4, 6}, 10));
        assertArrayEquals(new int[] {1,4}, twoNumberSumSort(new int[] {4, 6, 1}, 5));
        assertArrayEquals(new int[] {-3,6}, twoNumberSumSort(new int[] {4, 6, 1, -3}, 3));
    }
}

/*
 * This is the exact problem as Two Sum 1
 * https://leetcode.com/problems/two-sum/
 * Explanation
 * 
 * The only difference is that you find the element instead of the index, so you use a HashSet instead of a HashMap
 * Or sort it and use two pointers
 * 
 * Time: O(n) or O(n log n)
 * Space: O(n) or O(1)
 */