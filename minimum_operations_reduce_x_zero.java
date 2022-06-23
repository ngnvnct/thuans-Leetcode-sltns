import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class minimum_operations_reduce_x_zero {
    public int minOperations(int[] nums, int x) {
        int totalSum = Arrays.stream(nums).sum();
        int target = totalSum - x;

        if (target == 0) {
            return nums.length;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int len = -1;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            map.put(prefixSum, i);
            if (map.containsKey(prefixSum-target)) {
                int currLen = i-map.get(prefixSum-target);
                len = Math.max(len, currLen);
            }
        }
        if (len == -1) {
            return len;
        }
        return nums.length-len;
    }

    @Test
    public void testMinimum() {
        assertEquals(2, minOperations(new int[] {1,1,4,2,3}, 5));
        assertEquals(-1, minOperations(new int[] {5,6,7,8,9}, 4));
        assertEquals(5, minOperations(new int[] {3,2,20,1,1,3}, 10));
    }
}

/*
https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
Explanation

Learn about array streams. Array streams are a more declarative style and more expressive style. 
Streams have a strong affinity with functions. Java 8 introduces lambdas and functional interfaces.
Streams encrouages less mutability. 

This question is asking what's the length of the longest subarray that adds up to the total sum, minus x.

Map stores prefix sum to the index where it occurs. How many elements in a row from the left side do i need to grab to get a sum adding up to k
map.get(k) will get the answer.

Going left to right, at index i adding to a sum, and find the longest subarray. On each step i, the current sum is the equivalent of considering a range of elements
where all elements to the right of i have been excluded from our current subarray.

Still very confusing.

Time: O(n)
Space: O(n)
*/