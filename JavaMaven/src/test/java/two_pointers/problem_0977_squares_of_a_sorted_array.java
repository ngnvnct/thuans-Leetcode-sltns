/*
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 * Explanation:
 * 
 * The key take away is the array is sorted. So the start and the end element
 * have the potential to be the largest.
 * We take the absolute value of the start and end element and use Two Pointers
 * approach
 * Then we compare it with each other, and insert the bigger one square at the
 * end of our result array.
 * 
 * Time: O(n), where n is the array
 * Space: O(n), where n is the array input
 */

package two_pointers;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class problem_0977_squares_of_a_sorted_array {
    public int[] sortedSquare(int[] nums) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int[] sortedSquareArray = new int[nums.length];
        int sortedSquareIndex = nums.length - 1;
        while (leftPointer <= rightPointer) {
            int currLeftValue = Math.abs(nums[leftPointer]);
            int currRightValue = Math.abs(nums[rightPointer]);
            if (currLeftValue < currRightValue) {
                sortedSquareArray[sortedSquareIndex--] = currRightValue * currRightValue;
                rightPointer--;
            } else {
                sortedSquareArray[sortedSquareIndex--] = currLeftValue * currLeftValue;
                leftPointer++;
            }
        }
        return sortedSquareArray;
    }

    @Test
    public void testSortedSquare() {
        int[] testCase1 = new int[] { -4, -1, 0, 3, 10 };
        int[] testCase1ExpectedResult = new int[] { 0, 1, 9, 16, 100 };
        int[] testCase2 = new int[] { -7, -3, 2, 3, 11 };
        int[] testCase2ExpectedResult = new int[] { 4, 9, 9, 49, 121 };

        assertArrayEquals(testCase1ExpectedResult, sortedSquare(testCase1));
        assertArrayEquals(testCase2ExpectedResult, sortedSquare(testCase2));
    }
}