import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Concatenation_Of_Array_1929 {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i % nums.length];
        }
        return res;
    }

    public int[] getConcatenation2(int[] nums) {
        int[] res = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i + nums.length] = nums[i];
        }
        return res;
    }

    @Test
    public void testConcatenation() {
        assertArrayEquals(new int[] { 1, 2, 1, 1, 2, 1 }, getConcatenation(new int[] { 1, 2, 1 }));
        assertArrayEquals(new int[] { 1, 3, 2, 1, 1, 3, 2, 1 }, getConcatenation(new int[] { 1, 3, 2, 1 }));
        assertArrayEquals(new int[] { 1, 2, 1, 1, 2, 1 }, getConcatenation2(new int[] { 1, 2, 1 }));
        assertArrayEquals(new int[] { 1, 3, 2, 1, 1, 3, 2, 1 }, getConcatenation2(new int[] { 1, 3, 2, 1 }));
    }
}

/*
 * https://leetcode.com/problems/concatenation-of-array/
 * Explanation
 * 
 * Method 1: Simlar to the N-th Tribonacci Number Problem
 * https://leetcode.com/problems/n-th-tribonacci-number/
 * We juse use mod to get the correct index.
 * 0 mod 3 = 0, 1 mod 3 = 1, 2 mod 3 = 2
 * 3 mod 3 = 0, 4 mod 3 = 1, 5 mod 3 = 2
 * This method will have O(n) time where n is the length of the result array
 * 
 * Method 2: This method will have O(n) time where n is the length of the input
 * array
 * We loop through the input array, then set current index = current element at
 * input array, then we also set the next set of index (i + nums.length) to be
 * the same
 * 
 * Space: O(n) for output array
 */