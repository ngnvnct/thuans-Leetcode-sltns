import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class Number_Of_Matching_Subsequences_792 {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<String, Boolean> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                int sIndex = 0;
                int wIndex = 0;
                while (sIndex < s.length() && wIndex < word.length()) {
                    if (word.charAt(wIndex) == s.charAt(sIndex)) {
                        wIndex++;
                    }
                    sIndex++;
                }
                if (wIndex == word.length()) {
                    count++;
                    map.put(word, true);
                } else {
                    map.put(word, false);
                }
            } else {
                if (map.get(word)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void testMatchingSubsequences() {
        assertEquals(3, numMatchingSubseq("abcde", new String[] { "a", "bb", "acd", "ace" }));
        assertEquals(2, numMatchingSubseq("dsahjpjauf", new String[] { "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax" }));
        assertEquals(11, numMatchingSubseq("wwwwwwwwwwwwp",
                new String[] { "wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp" }));
    }
}

/*
 * https://leetcode.com/problems/number-of-matching-subsequences/
 * Explanation
 * Similar to https://leetcode.com/problems/is-subsequence/
 * Using two pointers easy mode, grab each string element and use two pointers
 * to compare if it is a subsequence of S. If we exhaust the String word, it
 * means it is a subsequence
 * we increment our result and add it to our hash map. This take care of
 * duplicate string, we don't have to re-compute it.
 * 
 * This does the job but there are an advance way to solve this
 * 
 * Time: O(words.length * s.length + sum of words[i].length)
 * Space: O(n) where n is the number of unique in the words array
 */