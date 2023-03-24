import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class max_erasure_value {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int currSum = 0;
        int maxSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                currSum -= nums[left];
                set.remove(nums[left++]);
            }
            currSum += nums[right];
            maxSum = Math.max(currSum, maxSum);
            set.add(nums[right]);
        }
        return maxSum;
    }

    public int maximumUniqueSubarray2(int[] nums) {
        int left = 0;
        int right = 0;
        int currSum = 0;
        int maxSum = 0;
        Set<Integer> set = new HashSet<>();
        while (right < nums.length) {
            if (set.contains(nums[right])) {
                currSum -= nums[left];
                set.remove(nums[left++]);
            } else {
                currSum += nums[right];
                set.add(nums[right++]);
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    public int maximumUniqueSubarrayBoolen(int[] nums) {
        int maxSum = 0;
        int currSum = 0;
        int k = 10001;
        boolean[] isPresent = new boolean[k];
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (isPresent[nums[right]]) {
                isPresent[nums[left]] = false;
                currSum -= nums[left];
                left++;
            }
            isPresent[nums[right]] = true;
            currSum += nums[right];
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    @Test
    public void testErasure() {
        assertEquals(17, maximumUniqueSubarray(new int[] {4,2,4,5,6}));
        assertEquals(8, maximumUniqueSubarray(new int[] {5,2,1,2,5,2,1,2,5}));
        assertEquals(17, maximumUniqueSubarray2(new int[] {4,2,4,5,6}));
        assertEquals(8, maximumUniqueSubarray2(new int[] {5,2,1,2,5,2,1,2,5}));
        assertEquals(17, maximumUniqueSubarrayBoolen(new int[] {4,2,4,5,6}));
        assertEquals(8, maximumUniqueSubarrayBoolen(new int[] {5,2,1,2,5,2,1,2,5}));
    }
}

/*
https://leetcode.com/problems/maximum-erasure-value/
Explanation

The main point is for the subarray to contain unique elements for each index. Only the first subarrays starting from that index have unique elements.
Similar to Longest Substring Without Repeating Characters https://leetcode.com/problems/longest-substring-without-repeating-characters/
Solve using a Set and Sliding Window technique.

Some optimized: add and remove can cost overhead, can use a boolean array to track the elements present in the current subarray. If an element is added to the current subarray, mark isPresent[i] = true
if it is removed from the current subarray, mark isPresent[i] = false, and use sliding window technique.

Time: O(n)
Space: O(k) or O(m) where k is the size of the boolean array and m is the size of unique element in the set
*/