import java.util.Arrays;
import java.util.PriorityQueue;

public class kth_largest_element_in_array {
    public int findKthLargestSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargestHeap(int[] nums, int k) {
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int val : nums) {
            minHeap.offer(val);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}

/*
Explanation

we can sort it and return length-k to get the element. Time O(nlogn), space O(1)

We can keep a min heap to store the k-th largest values. O(n log k) and O(k) memory

Space Optimization TBD
*/