import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class Ransom_Note_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            alphabet[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int wordConstruct = alphabet[ransomNote.charAt(i) - 'a'];

            if (wordConstruct <= 0) {
                return false;
            }
            alphabet[ransomNote.charAt(i) - 'a']--;
        }
        return true;
    }

    public boolean canConstructMap(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int wordConstruct = map.getOrDefault(c, 0);

            if (wordConstruct == 0) {
                return false;
            }

            map.put(c, wordConstruct - 1);
        }
        return true;
    }
    
    @Test
    public void testRansomNote() {
        assertEquals(false, canConstruct("a", "b"));
        assertEquals(false, canConstructMap("a", "b"));
        assertEquals(false, canConstruct("aa", "ab"));
        assertEquals(false, canConstructMap("aa", "ab"));
        assertEquals(true, canConstruct("aa", "aab"));
        assertEquals(true, canConstructMap("aa", "aab"));
    }
}

/*
 * https://leetcode.com/problems/ransom-note/
 * Explanation
 * 
 * Using the bucket to count the alphabet, assuming all lower case
 * then loop over to ransom and get the value, if it is <0, return false, we
 * can't construct, else subtract the character by one. When the loop ends
 * return true
 * 
 * Time: O(m) where m is the length of the magazine, if magazine length is less than ransom length we turn false so the worst case occurs when m >= r
 * Space: O(26)
 * 
 * Two Hash Map ways: one for ransom and one for magazine
 * Loop over each cahracter of the ransomnote, and check how many exists in the magazine
 * if it isn't in the magazine, return false, if the count of magazine char is smaller than count of ransom note char, return false, else return true after loop
 * 
 * 
 * One Hash Map (Optimal)
 * Build it with magazine frequency, then subtract character from the ransom note.If the character isn't in the hashmap, assign it the value of 0
 * if it is 0, return false
 */