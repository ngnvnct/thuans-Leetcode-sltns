import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Pattern_Matching {
    public static void main(String[] args) {
        String[] exampleTwo = { "hat", "mat", "kick" };
        char[] patternTwo = { 'a', 'b', 'a' };
        Pattern_Matching sol = new Pattern_Matching();
        System.out.println(sol.patternMatching(exampleTwo, patternTwo));
    }

    public boolean patternMatching(String[] words, char[] pattern) {
        if (words.length != pattern.length) {
            return false;
        }
        Map<String, Character> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (map.containsKey(currentWord)) {
                if (!map.get(currentWord).equals(pattern[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(pattern[i])) {
                    return false;
                }
                map.put(currentWord, pattern[i]);
            }

        }
        return true;
    }

    @Test
    public void testPattern() {
        String[] exampleOne = { "cat", "dog", "dog" };
        char[] patternOne = { 'a', 'b', 'b' };
        String[] exampleTwo = { "hat", "mat", "kick" };
        char[] patternTwo = { 'a', 'b', 'a' };

        assertTrue(patternMatching(exampleOne, patternOne));
        assertFalse(patternMatching(exampleTwo, patternTwo));
    }
}

/*
 * Explanation
 * 
 * Similar to LC 290 Word Pattern https://leetcode.com/problems/word-pattern/ 
 * But this time it is two arrays instead of two String
 * 
 * Keep a hash map, and loop over the array of words, first check is the
 * currentWord already in the map, if it is
 * check if the values is the same as the pattern value at index i, if they are
 * not just return false
 * 
 * else the key is not in the map yet, but we have to check is the pattern
 * values already being map somewhere else, using containsValue(pattern[i]), if
 * it is then return false
 * else put it in the map currentWord: pattern[i]
 * 
 * Time: O(n) where n is the number of words in the array
 * Space: O(n) where n is the number of unique characters in pattern
 */