/*
 * https://leetcode.com/problems/jewels-and-stones/
 * Explanation:
 * 
 * A Set problem. Store the set and check if stones contain it.
 * 
 * Time: O(m+n)
 * Space: O(n) where N i the jewels
 */

package freebie;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class problem_0771_jewels_and_stones {
    public int numJewelsInStonesSet(String jewels, String stones) {
        int jewelsCount = 0;
        Set<Character> bagOfJewels = new HashSet<>();
        for (Character jewel : jewels.toCharArray()) {
            bagOfJewels.add(jewel);
        }
        for (Character stone : stones.toCharArray()) {
            if (bagOfJewels.contains(stone)) {
                jewelsCount++;
            }
        }
        return jewelsCount;
    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (jewels.contains(stone + "")) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void testJewels() {
        String jewelsTestCase1 = "aA";
        String stonesTestCase1 = "aAAbbbb";
        String jewelsTestCase2 = "z";
        String stonesTestCase2 = "ZZ";

        assertEquals(3, numJewelsInStones(jewelsTestCase1, stonesTestCase1));
        assertEquals(0, numJewelsInStones(jewelsTestCase2, stonesTestCase2));
        assertEquals(3, numJewelsInStonesSet(jewelsTestCase1, stonesTestCase1));
        assertEquals(0, numJewelsInStonesSet(jewelsTestCase2, stonesTestCase2));

    }
}