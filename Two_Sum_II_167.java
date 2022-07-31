import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class Two_Sum_II_167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { left + 1, right + 1 };
    }

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[] { 1, 2 }, twoSum(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 3 }, twoSum(new int[] { 2, 3, 4 }, 6));
        assertArrayEquals(new int[] { 1, 2 }, twoSum(new int[] { -1, 0 }, -1));
    }

}

/*
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Explantion:
 * Since the Array is sorted, we can just have a two pointers one at the front
 * and one at the end and shrink the window
 * 
 * Time: O(n), looping through n elements of Array
 * Space: O(1),
 */