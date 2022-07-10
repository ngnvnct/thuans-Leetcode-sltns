import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Binary_Search_704 {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void testBinarySearch() {
        assertEquals(4, binarySearch(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
        assertEquals(-1, binarySearch(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
    }
}

/*
 * https://leetcode.com/problems/binary-search/
 * Explanation
 * 
 * Textbook algorithm based on the idea to compare the target value ot the middle elemnt of the array.
 * If the target value is equal to the middle element - we're done
 * if the target value is smaller - search on the left
 * if the target value is larger - search on the right
 * 
 * Works best when the array is SORTED.
 * Use mid = left + (right - left) / 2 to avoid integer overflow vs left + right / 2
 * 
 * Time: O(log n)
 * Space: O(1)
 */