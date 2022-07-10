import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class How_Many_Apples_Can_You_Put_Into_The_Basket_1196 {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int apples = 0;
        int max = 5000;
        for (int i = 0; i < weight.length; i++) {
            max = max - weight[i];
            if (max >= 0) {
                apples++;
            }
        }
        return apples;
    }

    public int maxNumberOfApplesHeap(int[] weight) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : weight) {
            minHeap.add(num);
        }
        int apples = 0;
        int currentWeight = 0;

        while (!minHeap.isEmpty() && currentWeight + minHeap.peek() <= 5000) {
            currentWeight += minHeap.remove();
            apples++;
        }
        return apples;
    }

    @Test
    public void testApple() {
        assertEquals(4, maxNumberOfApples(new int[] {100,200,150,1000}));
        assertEquals(5, maxNumberOfApples(new int[] {900,950,800,1000,700,800}));
        assertEquals(4, maxNumberOfApplesHeap(new int[] {100,200,150,1000}));
        assertEquals(5, maxNumberOfApplesHeap(new int[] {900,950,800,1000,700,800}));
    }
}

/*
https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/
Explanation

Greedy approach, sort the array and take the smallest weight until you reach the max
Min Heap approach, similar to the sort

Time: O(nlogn), O(N + klogN) where k is the number of apples that will be put into the basket, N is length of the array
Space: O(1), O(n) for min heap
*/