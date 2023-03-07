import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class remove_duplicate_sorted {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int insertPos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[insertPos]) {
                nums[++insertPos] = nums[i];
            }
        }
        return insertPos+1;
    }

    @Test
    public void testRemoveDuplicate() {
        int[] testCase1 = new int[] {1,1,2};
        assertEquals(2, removeDuplicates(testCase1));

        int[] testCase2 = new int[] {0,0,1,1,1,2,2,3,3,4};
        assertEquals(5, removeDuplicates(testCase2));
    }
}

/*
Explanation
Two Pointers approach, have a pointer starting at index 0, if the current element is not the same as the current Pointer element, increment the pointer by one and swap the place

Time: O(n)
Space: O(1), modifying the input array in-place

*/
