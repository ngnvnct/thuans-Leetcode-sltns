/*
 * Explanation
 * 
 * Similar to https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://www.geeksforgeeks.org/print-longest-substring-without-repeating-characters/
 * 
 * Except this time we return an unique string instead
 * 
 * Time: O(n)
 * Space: O(min(m,n)). O(k) space for sliding window, where k is the size of the
 * Set. The size of the set is upper bounded by the size of the string n and the
 * size of the alphabet m
 */

package sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class problem_9999_longest_substring_without_repeating_characters {
    public String longestSubStringWithoutDuplication(String s) {
        if (s == null)
            return null;
        if (s.length() == 0)
            return s;

        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int leftSubstring = 0;
        int rightSubstring = 1;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen.containsKey(c)) {
                left = Math.max(left, lastSeen.get(c) + 1);
            }
            if (rightSubstring - leftSubstring < right + 1 - left) {
                leftSubstring = left;
                rightSubstring = right + 1;
            }
            lastSeen.put(c, right);
        }
        String res = s.substring(leftSubstring, rightSubstring);
        return res;
    }

    @Test
    public void testLongestSubStringWithoutDuplication() {
        String testCase1 = "abcabcbb";
        String testCase1ExpectedResult = "abc";
        assertEquals(testCase1ExpectedResult, longestSubStringWithoutDuplication(testCase1));

        String testCase2 = "bbbbb";
        String testCase2ExpectedResult = "b";
        assertEquals(testCase2ExpectedResult, longestSubStringWithoutDuplication(testCase2));

        String testCase3 = "pwwkew";
        String testCase3ExpectedResult = "wke";
        assertEquals(testCase3ExpectedResult, longestSubStringWithoutDuplication(testCase3));

        String testCase4 = "";
        String testCase4ExpectedResult = "";
        assertEquals(testCase4ExpectedResult, longestSubStringWithoutDuplication(testCase4));

        String testCase5 = "abcdefg";
        String testCase5ExpectedResult = "abcdefg";
        assertEquals(testCase5ExpectedResult, longestSubStringWithoutDuplication(testCase5));
    }
}