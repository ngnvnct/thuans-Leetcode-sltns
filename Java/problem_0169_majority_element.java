/*
 * https://leetcode.com/problems/majority-element/
 * Explanation:
 * 
 * The Boyer-Moore voting algorithm is one of the popular optimal algorithms
 * which is used to find the majority element among the given elements that have
 * more than N/ 2 occurrences.
 * This works perfectly fine for finding the majority element which takes 2
 * traversals over the given elements, which works in O(N) time complexity and
 * O(1) space complexity.
 * 
 * First, choose a candidate from the given set of elements if it is the same as
 * the candidate element, increase the votes.
 * Otherwise, decrease the votes if votes become 0, select another new element
 * as the new candidate.
 * 
 * Sorting is sort and get the nums[nums.length/2]
 * 
 * Time: O(n) or O(n log n)
 * Space: O(1)
 */

package Java;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_0169_majority_element {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }

    public int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    @Test
    public void testMajority() {
        int[] testCase1 = { 3, 2, 3 };
        int testCase1ExpectedResult = 3;
        int[] testCase2 = { 2, 2, 1, 1, 1, 2, 2 };
        int testCase2ExpectedResult = 2;

        assertEquals(testCase1ExpectedResult, majorityElement(testCase1));
        assertEquals(testCase2ExpectedResult, majorityElement(testCase2));

        assertEquals(testCase1ExpectedResult, majorityElementSort(testCase1));
        assertEquals(testCase2ExpectedResult, majorityElementSort(testCase2));
    }
}