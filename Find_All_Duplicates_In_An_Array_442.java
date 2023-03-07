import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Find_All_Duplicates_In_An_Array_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                res.add(num);
            }
            set.add(num);
        }
        return res;
    }

    public List<Integer> findDuplicatesSort(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                res.add(nums[i]);
                i++;
            }
        }
        return res;
    }

    public List<Integer> findDuplicates3(int[] nums) {
        int[] copy = nums.clone();
        List<Integer> res = new ArrayList<>();

        for (int num : copy) {
            copy[Math.abs(num) - 1] *= -1;
        }

        for (int num : copy) {
            if (copy[Math.abs(num) - 1] > 0) {
                res.add(Math.abs(num));
                copy[Math.abs(num) - 1] *= -1;
            }
        }
        return res;
    }

    public List<Integer> findDuplicates4(int[] nums) {
        int[] copy = nums.clone();
        List<Integer> res = new ArrayList<>();

        for (int num : copy) {
            if (copy[Math.abs(num) - 1] < 0) {
                res.add(Math.abs(num));
            }
            copy[Math.abs(num) - 1] *= -1;
        }
        return res;
    }

    @Test
    public void testDuplicate() {
        int[] testCase1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> testCase1ExpectedResult = new ArrayList<>(Arrays.asList(2, 3));
        int[] testCase2 = { 1, 1, 2 };
        List<Integer> testCase2ExpectedResult = new ArrayList<>(Arrays.asList(1));
        int[] testCase3 = { 1 };
        List<Integer> testCase3ExpectedResult = new ArrayList<>();

        assertEquals(testCase1ExpectedResult, findDuplicates(testCase1));
        assertEquals(testCase2ExpectedResult, findDuplicates(testCase2));
        assertEquals(testCase3ExpectedResult, findDuplicates(testCase3));

        assertEquals(testCase1ExpectedResult, findDuplicatesSort(testCase1));
        assertEquals(testCase2ExpectedResult, findDuplicatesSort(testCase2));
        assertEquals(testCase3ExpectedResult, findDuplicatesSort(testCase3));

        assertEquals(testCase1ExpectedResult, findDuplicates3(testCase1));
        assertEquals(testCase2ExpectedResult, findDuplicates3(testCase2));
        assertEquals(testCase3ExpectedResult, findDuplicates3(testCase3));

        assertEquals(testCase1ExpectedResult, findDuplicates4(testCase1));
        assertEquals(testCase2ExpectedResult, findDuplicates4(testCase2));
        assertEquals(testCase3ExpectedResult, findDuplicates4(testCase3));
    }
}

/*
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Explanation
 * 
 * Constraints: all num is positive
 * Each element appears once or twice
 * 
 * 
 * Sort Solution
 * Time: O(n log n)
 * Space: O(n) if count result, O(1)
 * Works for both negative and positive
 * 
 * Set, List Solution
 * Time: O(n), it can be O(n^2), look up is constant, but it can degrade to
 * linear
 * Space: O(n)
 * Set list works for both negative and positive value
 * 
 * 
 * Mark Visited Elements as Negative
 * We are using abs is because checking for nums[-1] doesn't make any sense
 * When we see an element for the first time, we negate it
 * If it is negative the next time we see it, it is a duplicate so we add it to
 * the result
 * 
 * Time: O(n)
 * Space: O(n) if count output, else O(1), we re-use the input array
 * 
 * 
 * JUnit Test: Using a copy so i don't modify the array
 */