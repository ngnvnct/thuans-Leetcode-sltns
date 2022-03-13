import java.util.Arrays;
import java.util.PriorityQueue;

public class apples_basket {
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
}

/*abstract
Explanation

Greedy approach, sort the array and take the smallest weight until you reach the max
Min Heap approach, similar to the sort

Time: O(nlogn), O(N + klogN) where k is the number of apples that will be put into the basket, N is length of the array
Space: O(1), O(n) for min heap
*/