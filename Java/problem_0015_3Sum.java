/*
 * https://leetcode.com/problems/3sum/
 * Explanation:
 * 
 * Sort the array, iterate through the list and use another two pointers (two
 * sum) to apporach the target
 * 
 * In the else statement
 * It is equal to 0, we add it to the result. Then we have to update the
 * pointer.
 * [-2,-2,0,0,2,2], we find the solution already, we increment left, we find a
 * dupe, we increment left again, then our loop will shift in the if statement
 * We only have to update one pointer, and the conditions above will update the
 * other pointers
 * 
 * Time: O(n^2)
 * Space: O(1) or O(n) depend on sort library
 */

package Java;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class problem_0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) { // Skip same result
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum < target) {
                    left++;
                } else if (twoSum > target) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) { // skip same result
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum < 0) {
                    left++;
                } else if (threeSum > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void testThreeSum() {
        List<List<Integer>> testCase1ExpectedResult = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        List<List<Integer>> testCase2ExpectedResult = List.of(List.of(0, 0, 0));
        List<List<Integer>> testCase3ExpectedResult = List.of(List.of(-3, 1, 2));
        List<List<Integer>> testCase4ExpectedResult = List.of(List.of(-2, 0, 2));

        assertEquals(testCase1ExpectedResult, threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        assertEquals(testCase2ExpectedResult, threeSum(new int[] { 0, 0, 0 }));
        assertEquals(testCase3ExpectedResult, threeSum(new int[] { -3, -3, 1, 2, 3, 4 }));
        assertEquals(testCase4ExpectedResult, threeSum(new int[] { -2, -2, 0, 0, 2, 2 }));

        assertEquals(testCase1ExpectedResult, threeSum2(new int[] { -1, 0, 1, 2, -1, -4 }));
        assertEquals(testCase2ExpectedResult, threeSum2(new int[] { 0, 0, 0 }));
        assertEquals(testCase3ExpectedResult, threeSum2(new int[] { -3, -3, 1, 2, 3, 4 }));
        assertEquals(testCase4ExpectedResult, threeSum2(new int[] { -2, -2, 0, 0, 2, 2 }));
    }
}