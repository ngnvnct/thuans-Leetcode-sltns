import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class unique_number_of_occurerences {
    public boolean uniqueOccurences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }

    @Test
    public void testUnique() {
        int[] one = {1,2,2,1,1,3};
        int[] two = {1,2};
        int[] three = {-3,0,1,-3,1,1,1,-3,10,0};

        assertEquals(true, uniqueOccurences(one));
        assertEquals(false, uniqueOccurences(two));
        assertEquals(true, uniqueOccurences(three));
    }
}

/*
Explanation

Count the frequency using a hash map, then compare the size of it with the hash set size. If they are not the same, that means there are duplicate occurrences

Time: O(n)
Space: O(2n) -> O(n)
*/
