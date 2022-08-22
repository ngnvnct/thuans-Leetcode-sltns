import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class Two_Sum_1 {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        Two_Sum_1 solution = new Two_Sum_1();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }

    public int[] twoSumBF(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
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
        assertArrayEquals(new int[] { 0, 1 }, twoSum(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 2 }, twoSum(new int[] { 3, 2, 4 }, 6));
        assertArrayEquals(new int[] { 0, 1 }, twoSum(new int[] { 3, 3, }, 6));
        assertArrayEquals(new int[] { 0, 1 }, twoSumBF(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 2 }, twoSumBF(new int[] { 3, 2, 4 }, 6));
        assertArrayEquals(new int[] { 0, 1 }, twoSumBF(new int[] { 3, 3, }, 6));
    }
}

/*
 * Part of Leetcode75
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