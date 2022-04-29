import static org.junit.Assert.assertArrayEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class three_sum_duplicate {
    public static void main(String[] args) {
        int[][] expectedOne = {{-8, 2, 6}, {-8, 3, 5},{-6, 1, 5}};
        List<int[]> exampleOne = new ArrayList<>(Arrays.asList(expectedOne));
        three_sum_duplicate sol = new three_sum_duplicate();
        System.out.println(Arrays.deepToString(expectedOne));
        System.out.println(Arrays.deepToString(exampleOne.toArray(new int[exampleOne.size()][])));
        System.out.println(Arrays.deepToString(sol.threeSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0).toArray((new int[expectedOne.length][]))));
    }
    public List<int[]> threeSum(int[] nums, int targetSum) {
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > targetSum) {
                break;
            }
            int left = i + 1;
            int right = nums.length-1;
            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];
                if (currSum == targetSum) {
                    int[] triplets = {nums[i], nums[left], nums[right]};
                    res.add(triplets);
                    left++;
                    right--;
                } else if (currSum < targetSum) {
                    left++;
                } else if (currSum > targetSum) {
                    right--;
                }
            }
        }
        return res;
    }

    @Test
    public void testThreeSumDuplicate() {
        int[][] expected1 = {{-8, 2, 6}, {-8, 3, 5},{-6, 1, 5}};
        int[][] expected2 = {{-8, 2, 6},{-8, 3, 5},{-6, 0, 6}, {-6, 1, 5},{-1, 0, 1}};
        int[][] expected3 = new int[][] {};
        assertArrayEquals(expected1, threeSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0).toArray((new int[expected1.length][])));
        assertArrayEquals(expected2, threeSum(new int[] {12, 3, 1, 2, -6, 5, 0, -8, -1, 6}, 0).toArray((new int[expected2.length][])));
        assertArrayEquals(expected3, threeSum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 15}, 33).toArray((new int[expected3.length][])));
    }
}

/*abstract
Explanation
Not the same as three sum on leetcode, this should find all triplets in the array that sum up to the target sum.
Most important thing from this file is converting list to array

Otherwise same deal, sort the array and use two pointers

TIme: O(n^2)
Space: O(n) where n in the input array, also the output array, and sorting
*/