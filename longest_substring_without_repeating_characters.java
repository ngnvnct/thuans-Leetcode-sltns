import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int count = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            count = Math.max(count, right-left+1);
            //count = Math.max(count, set.size());
        }
        return count;
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = 0;
        int longestSubstring = 0;
        while (right < s.length()) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            right++;
            longestSubstring = Math.max(longestSubstring, window.size());
        }
        return longestSubstring;
    }

    public int lengthOfLongestSubstring3(String s) {
        Set<Character> window = new HashSet<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < s.length()) {
            if (!window.contains(s.charAt(end))) {
                window.add(s.charAt(end++));
                max = Math.max(max, window.size());
            } else {
                window.remove(s.charAt(start++));
            }
        }
        return max;
    }

    @Test
    public void testLongestSubstring() {
        String exampleOne = "abcabcbb";
        String exampleTwo = "bbbbb";
        String exampleThree = "pwwkew";
        String exampleFour = "abcbza";
        assertEquals(3, lengthOfLongestSubstring(exampleOne));
        assertEquals(1, lengthOfLongestSubstring(exampleTwo));
        assertEquals(3, lengthOfLongestSubstring(exampleThree));
        assertEquals(4, lengthOfLongestSubstring(exampleFour));
        assertEquals(3, lengthOfLongestSubstring2(exampleOne));
        assertEquals(1, lengthOfLongestSubstring2(exampleTwo));
        assertEquals(3, lengthOfLongestSubstring2(exampleThree));
        assertEquals(4, lengthOfLongestSubstring2(exampleFour));
        assertEquals(3, lengthOfLongestSubstring3(exampleOne));
        assertEquals(1, lengthOfLongestSubstring3(exampleTwo));
        assertEquals(3, lengthOfLongestSubstring3(exampleThree));
        assertEquals(4, lengthOfLongestSubstring3(exampleFour));
    }
}

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Explanation
Sliding Window technique. "abcabcbb", we start at "a", then go to b and c, on the next a we know that it is in the set, we remove the left most character then move the window to the right, then add a new "a" in
Then we update the max result

The reason we want to use a while loop is something like this "qrsvbspk"

qrsvb is the longest substring without repeating character, we have to keep looping until remove "s" from our set, so the new substring will be "vbs", and then "vbspk"

Time: O(n)
Space: O(min(m,n)). O(k) space for sliding window, where k is the size of the Set. The size of the set is upper bounded by the size of the string n and the size of the alphabet m
*/