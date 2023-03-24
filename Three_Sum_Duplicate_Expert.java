import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Three_Sum_Duplicate_Expert {
    public static void main(String[] args) {
        int[][] testCase1ExpectedResult = { { -8, 2, 6 }, { -8, 3, 5 }, { -6, 1, 5 } };
        List<int[]> testCase1 = new ArrayList<>(Arrays.asList(testCase1ExpectedResult));
        Three_Sum_Duplicate_Expert sol = new Three_Sum_Duplicate_Expert();
        System.out.println(Arrays.deepToString(testCase1ExpectedResult));
        System.out.println(Arrays.deepToString(testCase1.toArray(new int[testCase1.size()][])));
        System.out.println(Arrays.deepToString(sol.threeSum(new int[] { 12, 3, 1, 2, -6, 5, -8, 6 }, 0).toArray((new int[testCase1ExpectedResult.length][]))));
    }

    public List<int[]> threeSum(int[] nums, int targetSum) {
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > targetSum) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];
                if (currSum == targetSum) {
                    int[] triplets = { nums[i], nums[left], nums[right] };
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
        int[][] testCase1ExpectedResult = { { -8, 2, 6 }, { -8, 3, 5 }, { -6, 1, 5 } };
        int[][] testCase2ExpectedResult = { { -8, 2, 6 }, { -8, 3, 5 }, { -6, 0, 6 }, { -6, 1, 5 }, { -1, 0, 1 } };
        int[][] testCase3ExpectedResult = new int[0][0];

        assertArrayEquals(testCase1ExpectedResult, threeSum(new int[] { 12, 3, 1, 2, -6, 5, -8, 6 }, 0).toArray((new int[testCase1ExpectedResult.length][])));
        assertArrayEquals(testCase2ExpectedResult, threeSum(new int[] { 12, 3, 1, 2, -6, 5, 0, -8, -1, 6 }, 0).toArray((new int[testCase2ExpectedResult.length][])));
        assertArrayEquals(testCase3ExpectedResult, threeSum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 15 }, 33).toArray((new int[testCase3ExpectedResult.length][])));
    }
}

/*
 * AlgoExpert
 * Explanation
 * 
 * Not the same as three sum on leetcode, this should find all triplets in the
 * array that sum up to the target sum.
 * Most important thing from this file is converting list to array
 * 
 * Otherwise same deal, sort the array and use two pointers
 * 
 * TIme: O(n^2)
 * Space: O(n) where n in the input array, also the output array, and sorting
 */