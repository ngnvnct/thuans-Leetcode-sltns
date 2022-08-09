import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Consecutive_Characters_1446 {
    public int maxPower(String s) {
        int maxLength = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                maxLength = Math.max(count, maxLength);
                count = 1;
            }
        }
        return Math.max(maxLength, count);
    }

    @Test
    public void testConsecutive() {
        assertEquals(2, maxPower("leetcode"));
        assertEquals(5, maxPower("abbcccddddeeeeedcba"));
    }
}

/*
 * https://leetcode.com/problems/consecutive-characters/
 * Explanation
 * If they are consecutive, count the character
 * When they are not consecutive, get the max and reset the count to 1 (not 0!!)
 * 
 * Time: O(n)
 * Space: O(1) if not counting Input string O(n)
 */