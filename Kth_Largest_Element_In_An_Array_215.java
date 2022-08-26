import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class Kth_Largest_Element_In_An_Array_215 {
    public int findKthLargestSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargestHeap(int[] nums, int k) {
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : nums) {
            minHeap.offer(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    @Test
    public void testKLargest() {
        assertEquals(5, findKthLargestHeap(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
        assertEquals(4, findKthLargestHeap(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
    }
}

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Explanation
 * 
 * we can sort it and return length-k to get the element. Time O(nlogn), space
 * O(1)
 * 
 * We can keep a min heap to store the k-th largest values. For min heap, the
 * big value will be in the back, and we poll the heap if the size is equal to k
 * [3,2,1,5,6,4], k = 2
 * [3]
 * [2,3]
 * [1,2,3], poll 1
 * [2,3,5], poll 2
 * [3,5,6], poll 3
 * [4,5,6], poll 4
 * At the end only [5,6] are left, and 5 is the 2nd largest element in the
 * array.
 * 
 * TIme: O(n log k)
 * Space: O(k)
 */