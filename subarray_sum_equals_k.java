import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class subarray_sum_equals_k {
    public int subArraySum(int[] nums, int k) {
        int currSum = 0, result = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);

        for (int num : nums) {
            currSum += num;
            int diff = currSum - k;
            result += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }
        return result;
    }

    public int subArraySpace(int[] nums, int k) {
        int result = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public int subArrayEasy(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                res += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }

    @Test
    public void testSum() {
        int[] one = {1,1,1};
        int[] two = {1,2,3};
        int[] three = {3,4,7,2,-3,1,4,2};

        assertEquals(2, subArrayEasy(one, 2));
        assertEquals(2, subArraySpace(one, 2));
        assertEquals(2, subArraySum(one, 2));
        assertEquals(2, subArrayEasy(two, 3));
        assertEquals(2, subArraySpace(two, 3));
        assertEquals(2, subArraySum(two, 3));
        assertEquals(4, subArrayEasy(three, 7));
        assertEquals(4, subArraySpace(three, 7));
        assertEquals(4, subArraySum(three, 7));
    }
}

/*
Explanation

Array [1,2,3,4]
Sub Array: {}, {1}, {2}, {3}, {4}, {1,2}, {2,3}, {3,4}
{3,4}, {1,2,3,4}

Brute Force
Find the sum on the go while considering different end points.
Whenever sum equals k, update result.

Time: O(n^2)
Space: O(1)

If the diff does not exist, add a default value of 0. 
Store the current Sum in a hash map with a counter, then add to the result if there is a current sum - k target key.
[3,4,7,2,-3,1,4,2]
7
Res = 4
Sub Array [3,4], [7], [7,2,-3,1] and [1,4,2] are subarrays add up to k

Time: O(n)
Space: O(n)
*/