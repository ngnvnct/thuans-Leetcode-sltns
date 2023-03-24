import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class Word_Pattern_290 {
    public boolean wordPattern(String pattern, String s) {
        String[] word = s.split(" ");
        if (pattern.length() != word.length) {
            return false;
        }
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < word.length; i++) {
            String currentWord = word[i];
            char currentPattern = pattern.charAt(i);
            if (map.containsKey(currentWord)) {
                if (!map.get(currentWord).equals(currentPattern)) {
                    return false;
                }
            } else {
                if (map.containsValue(currentPattern)) {
                    return false;
                }
                map.put(currentWord, currentPattern);
            }
        }
        return true;
    }

    @Test
    public void testPattern() {
        assertTrue(wordPattern("abba", "dog cat cat dog"));
        assertFalse(wordPattern("abba", "dog cat cat fish"));
        assertFalse(wordPattern("aaaa", "dog cat cag dog"));
    }
}

/*
 * https://leetcode.com/problems/word-pattern/
 * Explanation
 * 
 * Similar to the pattern matching problem, but this time it is two strings
 * 
 * Similarly, build a hashmap of word : pattern, and check if the map already
 * contains the key, if it does check to see if it the same as the current
 * pattern
 * return false if not
 * else the key is not in the map, but we have to check if the values are
 * already being map somewhere, return false if it is
 * else put it in the map
 * 
 * Time: O(n)
 * Space: O(n)
 */