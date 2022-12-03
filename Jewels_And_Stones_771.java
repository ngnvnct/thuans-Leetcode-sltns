import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Jewels_And_Stones_771 {
    public int numJewelsInStonesSet(String jewels, String stones) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (Character j : jewels.toCharArray()) {
            set.add(j);
        }
        for (Character s : stones.toCharArray()) {
            if (set.contains(s)) {
                count++;
            }
        }
        return count;
    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (jewels.contains(c + "")) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void testJewels() {
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        String jewels2 = "z";
        String stones2 = "ZZ";
        assertEquals(3, numJewelsInStones(jewels1, stones1));
        assertEquals(0, numJewelsInStones(jewels2, stones2));
        assertEquals(3, numJewelsInStonesSet(jewels1, stones1));
        assertEquals(0, numJewelsInStonesSet(jewels2, stones2));

    }
}

/*
 * https://leetcode.com/problems/jewels-and-stones/
 * Explanation
 * 
 * A Set problem. Store the set and check if stones contain it.
 * 
 * Time: O(m+n)
 * Space: O(n) where N i the jewels
 */