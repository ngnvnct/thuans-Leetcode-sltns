import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class Top_K_Frequent_Elements_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(map.get(b), map.get(a)));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int n : map.keySet()) {
            maxHeap.add(n);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b)));

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : map.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    @Test
    public void testTopK() {
        assertArrayEquals(new int[] { 1, 2 }, topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
        assertArrayEquals(new int[] { 1 }, topKFrequent(new int[] { 1 }, 1));

        assertArrayEquals(new int[] { 1, 2 }, topKFrequent2(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
        assertArrayEquals(new int[] { 1 }, topKFrequent2(new int[] { 1 }, 1));

        assertArrayEquals(new int[] { 1, 2 }, topKFrequent3(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
        assertArrayEquals(new int[] { 1 }, topKFrequent3(new int[] { 1 }, 1));
    }
}

/*
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Explanation
 * We use a max heap and a hash map to store the value. The hashmap will store
 * the number of occurence, while the maxHeap will store the key/value pair,
 * when we poll it it will get the largest value
 * 
 * For the Min Heap method, we write our own compare function, we want to put
 * the least amount of element at the front, and the most at the back, and
 * everytime the heap size is larger than k, we poll it
 * That way we only keep O (n log k) element
 * 
 * Time: O(nlogn) or O(n log k) if k < n and O(n) if n = k for min heap. O(n log
 * k) > O(n log n)
 * Space: O(n + n) to store n element hash map and a heap with n elements or O(n
 * + k) to store the map with n element and a heap with k,
 */