import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.Test;

public class max_product_two_elements {
    public int maxProductHeap(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.add(num);
        }
        int largest = maxHeap.poll()-1;
        int secondLargest = maxHeap.poll()-1;
        return largest * secondLargest;
    }

    public int maxProductSort(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]-1) * (nums[nums.length-2]-1);
    }

    public int maxProductSpace(int[] nums) {
        int m = Integer.MIN_VALUE;
        int n = m;
        for (int num : nums) {
            if (num >= m) {
                n = m;
                m = num;
            } else if (num > n) {
                n = num;
            }
        }
        return (m-1) * (n-1);
    }

    @Test
    public void testMaxProduct() {
        int[] exampleOne = {3,4,5,2};
        int[] exampleTwo = {1,5,4,5};
        int[] exampleThree = {3,7};
        assertEquals(12, maxProductHeap(exampleOne));
        assertEquals(12, maxProductSort(exampleOne));
        assertEquals(12, maxProductSpace(exampleOne));

        assertEquals(16, maxProductHeap(exampleTwo));
        assertEquals(16, maxProductSort(exampleTwo));
        assertEquals(16, maxProductSpace(exampleTwo));

        assertEquals(12, maxProductHeap(exampleThree));
        assertEquals(12, maxProductSort(exampleThree));
        assertEquals(12, maxProductSpace(exampleThree));
    }
}

/*
Explanation
There are multiple ways to solve this. We can use a heap to store and pick out the two largest value then get the requirement max product.
Time: O(nlogn)
Space: O(n)

We can sort it and return the last and 2nd last element
Time: O(nlogn)
Space: O(1) or O(n) depends on sorting library

Use two variable and keep track of the largest and 2nd largest one in one pass
Time: O(n)
Space: O(1)

*/