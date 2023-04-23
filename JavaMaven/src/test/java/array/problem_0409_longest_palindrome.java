/*
 * https://leetcode.com/problems/longest-palindrome/
 * Explanation:
 * 
 * Set solution adds everything in, if we encounter a duplicate, we increment
 * pairCount by 2 and remove it from the set
 * Map solution we don't have to do any computation for remove, we just check if
 * the value is even or odd, if it is even we add the value from the key into
 * the pairCount
 * if it is odd, we add the value from the key and minus 1, and we make our
 * odd = 1 for the one character center in the middle
 * 
 * Time: O(n)
 * Space: O(n)
 */

package array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class problem_0409_longest_palindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int pairCount = 0;
        int odd = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                pairCount += entry.getValue();
            } else if (entry.getValue() % 2 != 0) {
                pairCount += entry.getValue() - 1;
                odd = 1;
            }
        }
        return pairCount + odd;
    }

    public int longestPalindrome2(String s) {
        Set<Character> set = new HashSet<>();
        int pairCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                pairCount += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) {
            return pairCount + 1;
        }
        return pairCount;
    }

    @Test
    public void testPalindromeLength() {
        String testCase1 = "abccccdd";
        int testCase1ExpectedResult = 7;

        String testCase2 = "a";
        int testCase2ExpectedResult = 1;

        String testCase3 = "";
        int testCase3ExpectedResult = 0;

        String testCase4 = "racecar";
        int testCase4ExpectedResult = 7;

        int testCase1ActualResult = longestPalindrome(testCase1);
        int testCase2ActualResult = longestPalindrome(testCase2);
        int testCase3ActualResult = longestPalindrome(testCase3);
        int testCase4ActualResult = longestPalindrome(testCase4);

        assertEquals(testCase1ExpectedResult, testCase1ActualResult);
        assertEquals(testCase2ExpectedResult, testCase2ActualResult);
        assertEquals(testCase3ExpectedResult, testCase3ActualResult);
        assertEquals(testCase4ExpectedResult, testCase4ActualResult);
    }
}