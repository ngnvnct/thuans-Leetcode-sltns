/*
 * https://leetcode.com/problems/consecutive-characters/
 * Explanation:
 * 
 * If they are consecutive, count the character
 * When they are not consecutive, get the max and reset the count to 1 (not 0!!)
 * 
 * Time: O(n)
 * Space: O(1) if not counting Input string O(n)
 */

package string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class problem_1446_consecutive_characters {
    public static int maxPower(String s) {
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
        String testCase1 = "leetcode";
        int testCase1ExpectedResult = 2;
        String testCase2 = "abbcccddddeeeeedcba";
        int testCase2ExpectedResult = 5;
        String testCase3 = "a";
        int testCase3ExpectedResult = 1;
        String testCase4 = "abc";
        int testCase4ExpectedResult = 1;
        String testCase5 = "aaabbbbcccccc";
        int testCase5ExpectedResult = 6;
        String testCase6 = "aaaabbbbcccccc";
        int testCase6ExpectedResult = 6;
        String testCase7 = "abbbbcccccc";
        int testCase7ExpectedResult = 6;

        assertEquals(testCase1ExpectedResult, maxPower(testCase1));
        assertEquals(testCase2ExpectedResult, maxPower(testCase2));
        assertEquals(testCase3ExpectedResult, maxPower(testCase3));
        assertEquals(testCase4ExpectedResult, maxPower(testCase4));
        assertEquals(testCase5ExpectedResult, maxPower(testCase5));
        assertEquals(testCase6ExpectedResult, maxPower(testCase6));
        assertEquals(testCase7ExpectedResult, maxPower(testCase7));
    }
}

