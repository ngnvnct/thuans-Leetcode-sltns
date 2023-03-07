import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class k_diff_pairs {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num,0)+1);
        }
        
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (counter.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void testFindPair() {
        int[] testCase1 = {3,1,4,1,5};
        assertEquals(2, findPairs(testCase1, 2));
        int[] testCase2 = {1,2,3,4,5};
        assertEquals(4, findPairs(testCase2, 1));
        int[] testCase3 = {1,3,1,5,4};
        assertEquals(1, findPairs(testCase3, 0));
    }
}

/*
Explanation
We create a hash map and store the occurence. Then we loop through the hashmap, if k is 0 (edge case) we count the number of occurence greater than 2 and increment our count.
Else we check if there exist (a key + k) value inside our hash map, if there is we increment our count.

Time: O(n)
Space: O(n)
*/