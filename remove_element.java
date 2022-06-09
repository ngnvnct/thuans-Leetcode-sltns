import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class remove_element {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[insertPos++] = nums[i];
            }
        }
        return insertPos;
    }

    @Test
    public void testRemoveDuplicate() {
        int[] exampleOne = new int[] {3,2,2,3};
        assertEquals(2, removeElement(exampleOne,3));

        int[] exampleTwo = new int[] {0,1,2,2,3,0,4,2};
        assertEquals(5, removeElement(exampleTwo,2));
    }
}

/*
https://leetcode.com/problems/remove-element/
Explanation
Two Pointers approach, have a pointer starting at index 0, if the current element is not the same as the val, swap the element and increment the pointer

Time: O(n)
Space: O(1), modifying the input array in-place
*/
