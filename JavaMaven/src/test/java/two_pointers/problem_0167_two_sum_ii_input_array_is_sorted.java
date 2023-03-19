/*
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Explantion:
 * 
 * Since the Array is sorted, we can just have a two pointers one at the front
 * and one at the end and shrink the window
 * 
 * Time: O(n), looping through n elements of Array
 * Space: O(1)
 */

package two_pointers;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class problem_0167_two_sum_ii_input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;
        while (leftPointer < rightPointer) {
            int currSum = numbers[leftPointer] + numbers[rightPointer];
            if (currSum == target) {
                break;
            } else if (currSum < target) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return new int[] { leftPointer + 1, rightPointer + 1 };
    }

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[] { 1, 2 }, twoSum(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 3 }, twoSum(new int[] { 2, 3, 4 }, 6));
        assertArrayEquals(new int[] { 1, 2 }, twoSum(new int[] { -1, 0 }, -1));
    }
}