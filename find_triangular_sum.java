import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class find_triangular_sum {
    public int triangularSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        while (nums.length != 1) {
            int[] newNums = new int[nums.length-1];
            for (int i = 0; i < newNums.length; i++) {
                newNums[i] = (nums[i] + nums[i+1]) % 10;
            }
            nums = newNums;
        }
        return nums[0];
    }

    public int triangularSum2(int[] nums) {
        int n = nums.length;
        while (n != 1) {
            for (int i = 0; i < n-1; i++) {
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            n--;
        }
        return nums[0];
    }

    @Test
    public void testTriangle() {
        assertEquals(8, triangularSum(new int[] {1,2,3,4,5}));
        assertEquals(5, triangularSum(new int[] {5}));
        assertEquals(8, triangularSum2(new int[] {1,2,3,4,5}));
        assertEquals(5, triangularSum2(new int[] {5}));
    }
}

/*
https://leetcode.com/problems/find-triangular-sum-of-an-array/
Explanation

Method 2 modify the input in-place, might not be ideal. Other than that just follow the simulation explain in the problem.

Time: O(n^2)
Space: O(n) or O(1)
*/