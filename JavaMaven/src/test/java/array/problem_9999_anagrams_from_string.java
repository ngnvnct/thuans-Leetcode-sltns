/*
 * Explanation:
 * 
 * Keep a boolean flag and use a bucket to keep track of frequency, then loop
 * through the string of array
 * clone the bucket at each element, and then compare the word with the number
 * of character in the bucket
 * if it is not an anagram, set the flag to be false, and adds it to our result
 * if it is a anagram
 * 
 * clone(), it justs simple allocates new memory space and assigns the objects
 * to it.
 * 
 * If the constraint is both Upper Case and Lower Case
 * 0-25 is A-Z (65-90)
 * 
 * ([,\,],^,-,`)
 * (26,27,28,29,30,31)
 * 91,92,93,94,95,96
 * 
 * 32-57 is a-z
 * 
 * if the interview ask for lowercase, then it would be an array of 57
 * 
 * Time: O(nm) where n is length of the array, and m is the maximum length of
 * the string
 * Space: O(1)
 */

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class problem_9999_anagrams_from_string {
    public List<String> findAnagram(String anagram, String[] words) {
        List<String> res = new ArrayList<>();
        boolean notAnagram = false;

        int[] alphabet = new int[26];
        for (int i = 0; i < anagram.length(); i++) {
            alphabet[anagram.charAt(i) - 'A']++;
        }

        for (String word : words) {
            if (word.length() != anagram.length()) {
                continue;
            }
            int[] clone = alphabet.clone();
            notAnagram = false;
            for (int i = 0; i < word.length(); i++) {
                clone[word.charAt(i) - 'A']--;
                if (clone[word.charAt(i) - 'A'] < 0) {
                    notAnagram = true;
                    break;
                }
            }
            if (!notAnagram) {
                res.add(word);
            }
        }
        return res;
    }

    public List<String> findAnagramSort(String anagram, String[] words) {
        List<String> res = new ArrayList<>();
        char[] c = anagram.toCharArray();
        Arrays.sort(c);
        anagram = new String(c);

        for (String word : words) {
            if (word.length() != anagram.length()) {
                continue;
            }
            c = word.toCharArray();
            Arrays.sort(c);
            String temp = new String(c);
            if (anagram.equals(temp)) {
                res.add(word);
            }
        }
        return res;
    }

    @Test
    public void testAnagram() {
        String[] testCase1 = { "ACT", "TAC", "DOGG", "TCA", "BOB", "JUM" };
        List<String> testCase1ExpectedResult = new ArrayList<>(Arrays.asList("ACT", "TAC", "TCA"));

        assertEquals(testCase1ExpectedResult, findAnagram("CAT", testCase1));
        assertEquals(testCase1ExpectedResult, findAnagramSort("CAT", testCase1));
    }
}