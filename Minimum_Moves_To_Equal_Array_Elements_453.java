import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Minimum_Moves_To_Equal_Array_Elements_453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }

    public int minMovesLinear(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

    @Test
    public void testMoves() {
        int[] testCase1 = new int[] {1,2,3};
        int testCase1ExpectedResult = 3;
        int[] testCase2 = new int[] {1,1,1};
        int testCase2ExpectedResult = 0;

        assertEquals(testCase1ExpectedResult, minMoves(testCase1));
        assertEquals(testCase2ExpectedResult, minMoves(testCase2));

        assertEquals(testCase1ExpectedResult, minMovesLinear(testCase1));
        assertEquals(testCase2ExpectedResult, minMovesLinear(testCase2));
    }
}

/*
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * Explanation
 * 
 * Sorting: sort and subtract by the smallest number at nums[0]
 * 
 * Linear: Adding 1 to n-1 elements is the same as subtracting 1 from one
 * element
 * So, the best way to do this is to make all elements in the array equal to the
 * min element
 * sum(array) - n * minimum
 * 
 * Time: O(nlogn)
 * Space: O(1)
 */
