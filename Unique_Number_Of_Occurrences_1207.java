import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Unique_Number_Of_Occurrences_1207 {
    public boolean uniqueOccurences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }

    public boolean uniqueOccurences2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int freq : map.values()) {
            if (!set.add(freq)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testUnique() {
        int[] testCase1 = { 1, 2, 2, 1, 1, 3 };
        int[] testCase2 = { 1, 2 };
        int[] testCase3 = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };

        assertTrue(uniqueOccurences(testCase1));
        assertFalse(uniqueOccurences(testCase2));
        assertTrue(uniqueOccurences(testCase3));

        assertTrue(uniqueOccurences2(testCase1));
        assertFalse(uniqueOccurences2(testCase2));
        assertTrue(uniqueOccurences2(testCase3));
    }
}

/*
 * https://leetcode.com/problems/unique-number-of-occurrences/
 * Explanation
 * 
 * Count the frequency using a hash map, then compare the size of it with the
 * hash set size. If they are not the same, that means there are duplicate occurrences
 * 
 * Time: O(n)
 * Space: O(2n) -> O(n)
 */
