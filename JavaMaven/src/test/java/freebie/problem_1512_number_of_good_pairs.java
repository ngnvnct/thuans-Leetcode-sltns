/*
 * https://leetcode.com/problems/number-of-good-pairs/
 * Explanation
 * 
 * Two for loops or use the math property n(n-1)/2 to determine the number of pairs of a given number of items
 * 
 * Time: O(n^2) or O(n)
 * Space: O(1) or O(100)
 */

package freebie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class problem_1512_number_of_good_pairs {
    public int numIdenticalPairs(int[] nums) {
        int identicalPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    identicalPairs++;
                }
            }
        }
        return identicalPairs;
    }

    public int numIdenticalPairs2(int[] nums) {
        int identicalPairs = 0;
        int[] countBucket = new int[101];

        for (int num : nums) {
            countBucket[num]++;
        }

        for (int n : countBucket) {
            identicalPairs += (n * (n - 1) / 2);
        }
        return identicalPairs;
    }

    @Test
    public void testPairs() {
        int[] testCase1 = new int[] { 1, 2, 3, 1, 1, 3 };
        int testCase1ExpectedResult = 4;
        int[] testCase2 = new int[] { 1, 1, 1, 1 };
        int testCase2ExpectedResult = 6;
        int[] testCase3 = new int[] { 1, 2, 3 };
        int testCase3ExpectedResult = 0;

        assertEquals(testCase1ExpectedResult, numIdenticalPairs(testCase1));
        assertEquals(testCase2ExpectedResult, numIdenticalPairs(testCase2));
        assertEquals(testCase3ExpectedResult, numIdenticalPairs(testCase3));

        assertEquals(testCase1ExpectedResult, numIdenticalPairs2(testCase1));
        assertEquals(testCase2ExpectedResult, numIdenticalPairs2(testCase2));
        assertEquals(testCase3ExpectedResult, numIdenticalPairs2(testCase3));
    }
}