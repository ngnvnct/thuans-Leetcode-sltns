import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class search_insert_position {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return left;
    }

    @Test
    public void testSearchInsert() {
        int[] exampleOne = {1,3,5,6};
        assertEquals(2, searchInsert(exampleOne, 5));
        assertEquals(1, searchInsert(exampleOne, 2));
        assertEquals(4, searchInsert(exampleOne, 7));
    }
}

/*
Explanation
Similar to Binary Search

Time: O(logn)
Space: O(1)
*/