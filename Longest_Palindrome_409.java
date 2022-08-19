import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Longest_Palindrome_409 {
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
        assertEquals(7, longestPalindrome("abccccdd"));
        assertEquals(1, longestPalindrome("a"));
        assertEquals(7, longestPalindrome2("abccccdd"));
        assertEquals(1, longestPalindrome2("a"));
    }
}

/*
 * Part of Leetcode75
 * https://leetcode.com/problems/longest-palindrome/
 * Explanation
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
