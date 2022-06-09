import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class two_sum_sorted {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

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
        return new int[]{left+1, right+1};
    }

    @Test
    public void testTwoSum() {
        int[] exampleOne = new int[]{2,7,11,15};
        int[] expected = new int[]{1,2};
        int target = 9;
        assertArrayEquals(expected, twoSum(exampleOne, target));

        int[] exampleTwo = new int[]{2,3,4};
        expected = new int[]{1,3};
        target = 6;
        assertArrayEquals(expected, twoSum(exampleTwo, target));

        int[] exampleThree = new int[]{-1,0};
        expected = new int[]{1,2};
        target = -1;
        assertArrayEquals(expected, twoSum(exampleThree, target));
    }

}

/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Explantion:
Since the Array is sorted, we can just have a two pointers one at the front and one at the end and shrink the window

Time: O(n), looping through n elements of Array
Space: O(1),
*/