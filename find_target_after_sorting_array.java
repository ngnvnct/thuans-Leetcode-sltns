import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class find_target_after_sorting_array {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> targetIndicesNoSort(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int lessThanTarget = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
            if (num < target) {
                lessThanTarget++;
            }
        }

        for (int i = 0; i < count; i++) {
            res.add(lessThanTarget++);
        }
        return res;
    }

    @Test
    public void testFind() {
        int[] one = {1,2,5,2,3};
        List<Integer> expectedOne = new ArrayList<>(Arrays.asList(1,2));
        int[] two = {1,2,5,2,3};
        List<Integer> expectedTwo = new ArrayList<>(Arrays.asList(3));
        int[] three = {1,2,5,2,3};
        List<Integer> expectedThree = new ArrayList<>(Arrays.asList(4));
        assertEquals(expectedOne, targetIndicesNoSort(one, 2));
        assertEquals(expectedTwo, targetIndicesNoSort(two, 3));
        assertEquals(expectedThree, targetIndicesNoSort(three, 5));
        assertEquals(expectedOne, targetIndices(one, 2));
        assertEquals(expectedTwo, targetIndices(two, 3));
        assertEquals(expectedThree, targetIndices(three,5));
    }
}


/*abstract
Explanation

Naive way, sort the array then if the element matches the target then add it into the result

Time: O(nlogn)
Space: O(1), output doesn't count

Big Brain way
[1,2,5,2,3] target = 3
we have a count and a less than target variable, if the num matches the target, we increment count, if the num is smaller than target, we update less than
3 variables less than 3, less than = 3

That means if we were to "sort it", there will be 3 elements that come before the target, and the value of less than will be the index that we will insert the "target" value
[1,2,2,3,5], since we loop from 0 to count-1, we can update the according index correctly

Time: O(n)
Space: O(1)
*/