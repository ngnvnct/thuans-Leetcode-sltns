import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    public int maximumBagsSort(int[] capacity, int[] rocks, int additionalRocks) {
        List<Integer> requiredCapacity = new ArrayList<>();
        int res = 0;
        int count = 0;
        for (int i = 0; i < rocks.length; i++) {
            requiredCapacity.add(capacity[i] - rocks[i]);
        }

        Collections.sort(requiredCapacity);
        for (int val : requiredCapacity) {
            count += val;
            if (count > additionalRocks) {
                break;
            }
            res++;
        }
        return res;
    }

    public int maximumBagsSpace(int[] capacity, int[] rocks, int additionalRocks) {
        int count = 0;

        for (int i = 0; i < capacity.length; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);

        for (int i = 0; i < capacity.length && additionalRocks >= 0; i++) {
            if (additionalRocks >= capacity[i]) {
                count++;
            }
            additionalRocks -= capacity[i];
        }
        return count;
    }

    @Test
    public void testRocks() {
        assertEquals(3, maximumBagsHeap(new int[] { 2, 3, 4, 5 }, new int[] { 1, 2, 4, 4 }, 2));
        assertEquals(3, maximumBagsHeap(new int[] { 10, 2, 2 }, new int[] { 2, 2, 0 }, 100));

        assertEquals(3, maximumBagsSort(new int[] { 2, 3, 4, 5 }, new int[] { 1, 2, 4, 4 }, 2));
        assertEquals(3, maximumBagsSort(new int[] { 10, 2, 2 }, new int[] { 2, 2, 0 }, 100));

        assertEquals(3, maximumBagsSpace(new int[] { 2, 3, 4, 5 }, new int[] { 1, 2, 4, 4 }, 2));
        assertEquals(3, maximumBagsSpace(new int[] { 10, 2, 2 }, new int[] { 2, 2, 0 }, 100));
    }
}

/*
 * https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
 * Explanation
 * 
 * First, we want to calculate how many bags already at full capacity, and the
 * one that is not full we put it into a min heap
 * Then, as long as additionalRocks is not equal 0 and min heap is not empty, we
 * take it out and we place rock inside our bag
 * We take the minimum between the placement or the additionalRocks
 * If placement is 0 we increment the count, else we add it back into our
 * minHeap
 * The trick for the priority queue problem is we want to fill out the one that
 * is almost at full capacity (lower number of placement)
 * 
 * Greedy Solution
 * Get all the empty space for each bag and sort them from small to big, and
 * greedily fills the bag
 * 
 * In the space optimal version we modify the input
 * 
 * Time: O(n log n) for heap, O(n log n) for Greedy
 * Space: O(n) or O(1)
 */