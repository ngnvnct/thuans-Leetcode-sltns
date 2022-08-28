import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class Last_Stone_Weight_1046 {
    public int lastStoneWeight(int[] stones) {
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            int stoneOne = maxHeap.poll();
            int stoneTwo = maxHeap.poll();
            if (stoneOne != stoneTwo) {
                maxHeap.add(stoneOne - stoneTwo);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public int lastStoneWeightList(List<Integer> stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            int stoneOne = maxHeap.remove();
            int stoneTwo = maxHeap.remove();
            if (stoneOne != stoneTwo) {
                maxHeap.add(stoneOne - stoneTwo);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.remove();
    }

    @Test
    public void testLastStoneWeight() {
        List<Integer> exampleOne = Arrays.asList(2, 7, 4, 1, 8, 1);
        int[] arrayOne = { 2, 7, 4, 1, 8, 1 };
        List<Integer> exampleTwo = Arrays.asList(1);
        int[] arrayTwo = { 1 };
        assertEquals(1, lastStoneWeight(arrayOne));
        assertEquals(1, lastStoneWeightList(exampleOne));
        assertEquals(1, lastStoneWeight(arrayTwo));
        assertEquals(1, lastStoneWeightList(exampleTwo));
    }
}

/*
 * Part of Leetcode75
 * https://leetcode.com/problems/last-stone-weight/
 * Explanation
 * 
 * Java PriorityQueue uses Min-Heap by default, so we have to use
 * Collections.reverseOrder() to turn it into a maxHeap.
 * Data Structure: a max-heap is a complete binary tree in which the value in
 * each internal node is greater than or equal to the values in the children of
 * that node. The root is the largest element
 * when Queue is empty, poll return null, remove will throw an exception. In our
 * example the loop will terminate before it becomes empty so poll and remove
 * work
 * 
 * We just put the element into the priority queue and take two element out, if
 * they are not the same, we add back in the diff value
 * 
 * Any method to reverse the natural ordering of the heap will work
 * 
 * Time: O(nlogn), maxHeap runtime
 * Space: O(n), maxHeap
 */