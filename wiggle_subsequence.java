import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class wiggle_subsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int prevDiff = 0;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            int currDiff = nums[i] - nums[i - 1];
            if (prevDiff >= 0 && currDiff < 0 || prevDiff <= 0 && currDiff > 0) {
                prevDiff = currDiff;
                count++;
            }
        }
        return count;
    }

    public int wiggleMaxLengthDP(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int up = 1, down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            } else if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
        }
        return Math.max(up, down);
    }

    @Test
    public void testWiggle() {
        assertEquals(7, wiggleMaxLength(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }));
        assertEquals(1, wiggleMaxLength(new int[] { 0, 0, 0 }));
        assertEquals(2, wiggleMaxLength(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
        assertEquals(6, wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 }));
        assertEquals(6, wiggleMaxLength(new int[] { 2, 4, 5, 7, 5, 5, 7, 1, 2, 3 }));

        assertEquals(7, wiggleMaxLengthDP(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }));
        assertEquals(1, wiggleMaxLengthDP(new int[] { 0, 0, 0 }));
        assertEquals(2, wiggleMaxLengthDP(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
        assertEquals(6, wiggleMaxLengthDP(new int[] { 1, 7, 4, 9, 2, 5 }));
        assertEquals(6, wiggleMaxLengthDP(new int[] { 2, 4, 5, 7, 5, 5, 7, 1, 2, 3 }));
    }
}

/*
 * https://leetcode.com/problems/wiggle-subsequence/
 * Explanation
 * 
 * The greedy solution is just have a prevDiff and check the condition given by
 * the problem and update the count accordingly
 * 
 * The DP solution looks like this
 * 
 * [2, 4, 5, 7, 5, 5, 7, 1, 2, 3]
 * at 2 up = down = 1
 * at 4 up = down + 1 = 2 (increasing)
 * at 5, 7 up = down + 1 = 2
 * at 5 down = up + 1 = 3 (decreasing)
 * at 7 up = down + 1 = 4 (increasing)
 * at 1 down = up + 1 = 5 (decreasing)
 * at 2 up = down + 1 = 6 (increasing)
 * at 3 up = down + 1 = 6 (increasing)
 * 
 * return max(up, down) = max(6,5) = 6;
 * 
 * Time: O(n)
 * Space: O(1)
 */