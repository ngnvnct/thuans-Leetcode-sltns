import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

public class Finding_The_Users_Active_Minutes_1817 {
    public int[] findingUAM(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] log : logs) {
            int id = log[0];
            int time = log[1];
            if (!map.containsKey(id)) {
                map.put(id, new HashSet<>());
            }
            map.get(id).add(time);
        }
        for (int id : map.keySet()) {
            int UAM = map.get(id).size();
            res[UAM - 1]++;
        }
        return res;
    }

    @Test
    public void testUAM() {
        int[][] testCase1 = { { 0, 5 }, { 1, 2 }, { 0, 2 }, { 0, 5 }, { 1, 3 } };
        int[][] testCase2 = { { 1, 1 }, { 2, 2 }, { 2, 3 } };
        assertArrayEquals(new int[] { 0, 2, 0, 0, 0 }, findingUAM(testCase1, 5));
        assertArrayEquals(new int[] { 1, 1, 0, 0 }, findingUAM(testCase2, 4));
    }
}

/*
 * https://leetcode.com/problems/finding-the-users-active-minutes/
 * Explanation
 * 
 * logs[i] = [ID, time]
 * Multiple users can perform action simultaneously, and a single user can
 * perform multiple actions in the same minute
 * REMEMBER, calculate a 1-indexed (meaning have to 0 index is 1)
 * 
 * Need a map and a hash set
 * For each log, grab the id as the key, and the time as the value, we put it in
 * the hash set because we only want one unit count
 * 
 * Now we loop through this key set, and UAM will be the size of of the id key
 * 1-indexed array answer of size k such that, for each j (1 <= j <= k),
 * answer[j] is the number of users whose UAM equals j
 * 
 * So for user with UAM of 2, meaning we have to increment the value at the 1
 * index in the array (2 in this case)
 * [0,1,0,0,0], then we get the next key 1, and it also have a UAM of 2, we
 * increment it again
 * [0,2,0,0,0]
 * 
 * Time: O(n)
 * Space: O(n)
 */