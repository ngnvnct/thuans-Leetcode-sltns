/*
 * https://leetcode.com/problems/valid-anagram/
 * Explanation:
 * 
 * Make a alphabet array of 26 elements. Take the current character subtract by
 * 'a' to get the ASCII code value of that letter. For example, 'a' is 97 and
 * 'z' is 122, 122-97 = 25, the last element
 * in the alphabet array. Loop through the string and increment the alphabet
 * element, then loop through the 2nd string and decrement the alphabet element.
 * If the array element is negative, it is not an anagram.
 * 
 * Sorting: O(n log n) time, in Java toCharArray makes a copy so it will be O(n)
 * space, otherwise it is O(1) space (language dependent detail)
 * 
 * Time: O(2n) -> O(n)
 * Space: O(26) -> O(1)
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you adapt
 * your solution to such a case?
 * 
 * Make a hash map with similar concept to the bucket, and loop throught the
 * values if it is negative it is not an anagram
 * 
 * Time: O(n)
 * Space: O(n)
 */

package Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class problem_0242_valid_anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
            if (alphabet[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sortS = s.toCharArray();
        char[] sortT = t.toCharArray();
        Arrays.sort(sortS);
        Arrays.sort(sortT);
        return Arrays.equals(sortS, sortT);
    }

    public boolean isAnagramFollowUp(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testAnagram() {
        assertTrue(isAnagram("anagram", "nagaram"));
        assertFalse(isAnagram("rat", "cat"));
        assertFalse(isAnagram("anagram", "agaram"));

        assertTrue(isAnagramSort("anagram", "nagaram"));
        assertFalse(isAnagramSort("rat", "cat"));
        assertFalse(isAnagramSort("anagram", "agaram"));
    }
}