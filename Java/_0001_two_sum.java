package Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class _0001_two_sum {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        _0001_two_sum solution = new _0001_two_sum();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }

    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
            }
            map.put(target - nums[i], i);
        }
        return ans;
    }

    @Test
    public void testTwoSum() {
        int[] testCase1 = new int[] { 2, 7, 11, 15 };
        int[] testCase1ExpectedResult = new int[] { 0, 1 };
        int[] testCase2 = new int[] { 3, 2, 4 };
        int[] testCase2ExpectedResult = new int[] { 1, 2 };
        int[] testCase3 = new int[] { 3, 3 };
        int[] testCase3ExpectedResult = new int[] { 0, 1 };

        assertArrayEquals(testCase1ExpectedResult, twoSum(testCase1, 9));
        assertArrayEquals(testCase2ExpectedResult, twoSum(testCase2, 6));
        assertArrayEquals(testCase3ExpectedResult, twoSum(testCase3, 6));

        assertArrayEquals(testCase1ExpectedResult, twoSumBruteForce(testCase1, 9));
        assertArrayEquals(testCase2ExpectedResult, twoSumBruteForce(testCase2, 6));
        assertArrayEquals(testCase3ExpectedResult, twoSumBruteForce(testCase3, 6));
    }
}

/*
 * https://leetcode.com/problems/two-sum/
 * Explantion
 * 
 * We want to make a HashMap to keep trace of the difference of the element.
 * First, we have an if-statement asking is the HashMap contains this element
 * If yes, we return the value of the key-value pair, along with the current
 * index
 * Else, we put the key as the difference (target-nums[i]), and the value is the
 * current index
 * 
 * Line 18 and 19 can be replace by return new int[] {map.get(nums[i]), i};
 * 
 * Brute Force way is two nested loop then check each one, O(n^2) time and O(1)
 * space
 * 
 * Time: O(n), looping through n elements of Array
 * Space: O(n), storing the Array in HashMap
 */