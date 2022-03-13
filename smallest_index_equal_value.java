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
        int[] one = {0,1,2};
        int[] two = {4,3,2,1};
        int[] three = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(0, smallestEqual(one));
        assertEquals(2, smallestEqual(two));
        assertEquals(-1, smallestEqual(three));
    }
}

/*abstract
Explanation

It is as simple as it gets. the first index % 10 == nums[i] is the smallest index

Time: O(n)
Space: O(1)
*/