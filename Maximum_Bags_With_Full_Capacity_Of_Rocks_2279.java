import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class Maximum_Bags_With_Full_Capacity_Of_Rocks_2279 {
    public int maximumBagsHeap(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] fill = new int[capacity.length];
        int count = 0;

        for (int i = 0; i < fill.length; i++) {
            fill[i] = capacity[i] - rocks[i];
            if (fill[i] == 0) {
                count++;
            } else {
                minHeap.add(fill[i]);
            }
        }

        while (additionalRocks != 0 && !minHeap.isEmpty()) {
            int placement = minHeap.poll();
            int place = Math.min(placement, additionalRocks);
            additionalRocks -= place;
            placement -= place;
            if (placement == 0) {
                count++;
            } else {
                minHeap.add(placement);
            }
        }
        return count;
    }

    @Test
    public void testRocks() {
        assertEquals(3, maximumBagsHeap(new int[] {2,3,4,5}, new int[] {1,2,4,4}, 2));
        assertEquals(3, maximumBagsHeap(new int[] {10,2,2}, new int[] {2,2,0}, 100));
    }
}

/*
 * https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
 * Explanation
 * 
 * 
 */