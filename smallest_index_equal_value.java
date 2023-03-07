import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class smallest_index_equal_value {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 10) {
                continue;
            }
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void testSmallest() {
        int[] testCase1 = {0,1,2};
        int[] testCase2 = {4,3,2,1};
        int[] testCase3 = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(0, smallestEqual(testCase1));
        assertEquals(2, smallestEqual(testCase2));
        assertEquals(-1, smallestEqual(testCase3));
    }
}

/*abstract
Explanation

It is as simple as it gets. the first index % 10 == nums[i] is the smallest index
One thing to is optimize is if the number is greater than 9, we can just skip it

Time: O(n)
Space: O(1)
*/