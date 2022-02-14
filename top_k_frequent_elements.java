import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

public class top_k_frequent_elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
            new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }
        return res;
    }

    @Test
    public void testTopK() {
        int[] exampleOne = {1,1,1,2,2,3};
        int[] expectedOne = {1,2};
        int[] exampleTwo = {1};
        assertArrayEquals(expectedOne, topKFrequent(exampleOne, 2));
        assertArrayEquals(exampleTwo, topKFrequent(exampleTwo, 1));
    }
}

/*abstract
Explanation
We use a max heap and a hash map to store the value. The hashmap will store the number of occurence, while the maxHeap will store the key/value pair, when we poll it it will get the largest value

Time: O(nlogn)
Space: O(n)

There is a better method, TBD
*/