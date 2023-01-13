/*
 * https://leetcode.com/problems/binary-search/
 * Explanation:
 * 
 * Textbook algorithm based on the idea to compare the target value ot the middle elemnt of the array.
 * If the target value is equal to the middle element - we're done
 * if the target value is smaller - search on the left
 * if the target value is larger - search on the right
 * 
 * Works best when the array is SORTED.
 * Use mid = left + (right - left) / 2 to avoid integer overflow vs left + right / 2
 * 
 * Time: O(log n)
 * Space: O(1)
 */

package Java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_0704_binary_search {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void testBinarySearch() {
        int[] testCase1 = new int[] { -1, 0, 3, 5, 9, 12 };
        int testCase1Target = 9;
        int testCase1ExpectedResult = 4;
        int[] testCase2 = new int[] { -1, 0, 3, 5, 9, 12 };
        int testCase2Target = 2;
        int testCase2ExpectedResult = -1;

        int[] testCase3 = new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 };
        int testCase3Target = 33;
        int testCase3ExpectedResult = 3;
        int[] testCase4 = new int[] { 1, 5, 23, 111 };
        int testCase4Target = 111;
        int testCase4ExpectedResult = 3;

        int[] testCase5 = new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 };
        int testCase5Target = 5;
        int testCase5ExpectedResult = -1;
        int[] testCase6 = new int[] { 1, 5, 23, 111 };
        int testCase6Target = 35;
        int testCase6ExpectedResult = -1;

        int[] testCase7 = new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 };
        int testCase7Target = 0;
        int testCase7ExpectedResult = 0;
        int[] testCase8 = new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 };
        int testCase8Target = 1;
        int testCase8ExpectedResult = 1;

        assertEquals(testCase1ExpectedResult, binarySearch(testCase1, testCase1Target));
        assertEquals(testCase2ExpectedResult, binarySearch(testCase2, testCase2Target));
        assertEquals(testCase3ExpectedResult, binarySearch(testCase3, testCase3Target));
        assertEquals(testCase4ExpectedResult, binarySearch(testCase4, testCase4Target));
        assertEquals(testCase5ExpectedResult, binarySearch(testCase5, testCase5Target));
        assertEquals(testCase6ExpectedResult, binarySearch(testCase6, testCase6Target));
        assertEquals(testCase7ExpectedResult, binarySearch(testCase7, testCase7Target));
        assertEquals(testCase8ExpectedResult, binarySearch(testCase8, testCase8Target));
    }
}