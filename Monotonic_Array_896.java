import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Monotonic_Array_896 {
    public boolean isMonotonic(int[] nums) {
        if (nums == null || nums.length == 1) {
            return true;
        }
        boolean increase = true;
        boolean decrease = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                decrease = false;
            } else if (nums[i - 1] > nums[i]) {
                increase = false;
            }
        }
        return increase || decrease;
    }

    public boolean isMonotonicNaive(int[] nums) {
        return isIncreasing(nums) || isDecreasing(nums);
    }

    public boolean isIncreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isDecreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testMonotonic() {
        assertTrue(isMonotonic(new int[] { -1, -5, -10, -1100, -1100, -1101, -1102, -9001 }));
        assertTrue(isMonotonic(new int[0]));
        assertTrue(isMonotonic(new int[] { 1 }));
        assertTrue(isMonotonic(new int[] { 1, 2 }));
        assertTrue(isMonotonic(new int[] { 2, 1 }));
        assertFalse(isMonotonic(new int[] { 1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 7, 9, 10, 11 }));
        assertFalse(isMonotonic(new int[] { 1, 1, 1, 2, 3, 4, 1 }));
    }
}

/*
 * Also appears on AlgoExpert
 * https://leetcode.com/problems/monotonic-array/
 * Explanation
 * 
 * A naive solution is do two pass, but you can iterate it one pass. Just have
 * two boolean variables to check if it is monotone increasing or monotone
 * decreasing.
 * At the end returns decrease OR increase
 * 
 * Time: O(n)
 * Space: O(1)
 */