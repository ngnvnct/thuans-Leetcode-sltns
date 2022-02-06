import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class sorted_square {
    public int[] sortedSquare(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[nums.length];
        int resIndex = nums.length-1;

        while (left <= right) {
            int leftPointer = Math.abs(nums[left]);
            int rightPointer = Math.abs(nums[right]);
            if (leftPointer < rightPointer) {
                res[resIndex--] = rightPointer * rightPointer;
                right--;
            } else {
                res[resIndex--] = leftPointer * leftPointer;
                left++;
            }
        }
        return res;
    }

    @Test
    public void testSortedSquare() {
        int[] exampleOne = new int[] {-4,-1,0,3,10};
        int[] expected = new int[] {0,1,9,16,100};
        assertArrayEquals(expected, sortedSquare(exampleOne));

        int[] exampleTwo = new int[] {-7,-3,2,3,11};
        expected = new int[] {4,9,9,49,121};
        assertArrayEquals(expected, sortedSquare(exampleTwo));
    }
}
