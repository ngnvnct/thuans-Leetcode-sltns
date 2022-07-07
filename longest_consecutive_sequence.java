import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int streak = 1;
        int longest = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    streak++;
                } else {
                    longest = Math.max(longest, streak);
                    streak = 1;
                }
            }
        }
        return Math.max(longest, streak);
    }

    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int streak = 1;
        int longest = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                if (nums[i] + 1 == nums[i + 1]) {
                    streak++;
                } else {
                    longest = Math.max(longest, streak);
                    streak = 1;
                }
            }
        }
        return Math.max(longest, streak);
    }

    public int longestConsecutiveSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int currLength = 0;
        int longest = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                while (set.contains(num + currLength)) {
                    currLength++;
                }
                longest = Math.max(longest, currLength);
                currLength = 0;
            }
        }
        return longest;
    }

    @Test
    public void testLongestSequence() {
        assertEquals(4, longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
        assertEquals(3, longestConsecutive(new int[] { 1, 2, 0, 1 }));
        assertEquals(9, longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
        assertEquals(4, longestConsecutive2(new int[] { 100, 4, 200, 1, 3, 2 }));
        assertEquals(3, longestConsecutive2(new int[] { 1, 2, 0, 1 }));
        assertEquals(9, longestConsecutive2(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
        assertEquals(4, longestConsecutiveSet(new int[] { 100, 4, 200, 1, 3, 2 }));
        assertEquals(3, longestConsecutiveSet(new int[] { 1, 2, 0, 1 }));
        assertEquals(9, longestConsecutiveSet(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
    }
}

/*
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Explanation
 * 
 * For the two sort solutions, just sort it and have two variables to keep track
 * of the current length and the longest consecutive sequence
 * 
 * For the set solution, think of it like a sequence
 * 1,2,3,4 100, 200
 * We use a set to track all the element in the array, and at each iteration we
 * check to see if its left neighbor exist, if its left neighbor doesn't exist
 * it means it is the start of the sequence, and we increment the length as long
 * as we see the right neighbor in the set
 * 
 * Time: O(n log n) or O(n + n) = O(n), the while loop is only run if it is the
 * beginning of a sequence, it can only run for n iterations throughout the
 * entire runtime
 * Space: O(1) or O(n)
 */