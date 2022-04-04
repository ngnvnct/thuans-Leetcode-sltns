import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class two_sum_less_than_k {
    public int twoSumLessThanKBruteForce(int[] nums, int k) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum < k) {
                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }

    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int res = -1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                res = Math.max(res, sum);
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
    
    @Test
    public void testSumK() {
        int[] one = {34, 23, 1, 24, 75, 33, 54, 8};
        int[] two = {10, 20, 30};
        assertEquals(58, twoSumLessThanK(one, 60));
        assertEquals(-1, twoSumLessThanK(two, 15));
    }
}

/*
Explanation

The idea is that we sort the pointer, and we use two pointer approach. If the number is less than k, we ask which is bigger the currentSum, or the previousSum
and update the left pointer, if sum is bigger than k, decrement the right pointer

Time: O(n log n)
Space: O(n) or O(1) depends on sorting implementation
*/