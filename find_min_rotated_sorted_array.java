import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class find_min_rotated_sorted_array {
    public int findMinMethodOne(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (right-left > 1) {
            int mid = left + (right-left) / 2;
            if (nums[left] > nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right];

    }

    public int findMinMethodTwo(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    @Test
    public void testFindMin() {
        int[] exampleOne = {3,4,5,1,2};
        int[] exampleTwo = {4,5,6,7,0,1,2};
        int[] exampleThree = {11,13,15,17};
        assertEquals(1, findMinMethodOne(exampleOne));
        assertEquals(1, findMinMethodTwo(exampleOne));
        assertEquals(0, findMinMethodOne(exampleTwo));
        assertEquals(0, findMinMethodTwo(exampleTwo));
        assertEquals(11, findMinMethodOne(exampleThree));
        assertEquals(11, findMinMethodTwo(exampleThree));
    }
}

/*abstract
Explanation
Left and right both converge to min index. Main idea is to converge left and right bounds on the start of the pivot. if nums[mid] > nums[right], at some point to the right of mid, a pivot occur
use mid + 1 and never consider mid again because we know where is at least one value smaller than it on the right, so we don't discard it by doing mid-1, it still might have the minimum value.
Else, we know the pivot is at mid or to the left of mid

Time: O(logn)
Space: O(1)
*/