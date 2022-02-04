import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class binary_search {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

    @Test
    public void testBinarySearch() {
        int[] exampleOne = new int[] {-1,0,3,5,9,12};
        int target = 9;
        assertEquals(4, binarySearch(exampleOne, target));

        int[] exampleTwo = new int[] {-1,0,3,5,9,12};
        target = 2;
        assertEquals(-1, binarySearch(exampleTwo, target));
    }
}
