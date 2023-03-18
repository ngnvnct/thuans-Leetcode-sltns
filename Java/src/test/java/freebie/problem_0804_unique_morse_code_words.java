/*
 * https://leetcode.com/problems/unique-morse-code-words/
 * Explanation:
 * 
 * Put morse code out of the word in a string then add it to a hash set, return
 * the size of the hash set is the unique morse code words
 * 
 * Time: O(n)
 * Space: O(n)
 */

package freebie;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_0804_unique_morse_code_words {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> uniqueTransformation = new HashSet<>();
        String[] morseAlphabet = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morseAlphabet[word.charAt(i) - 'a']);
            }
            uniqueTransformation.add(sb.toString());
        }
        return uniqueTransformation.size();
    }

    @Test
    public void testMorse() {
        String[] testCase1 = new String[] { "gin", "zen", "gig", "msg" };
        int testCase1ExpectedResult = 2;
        String[] testCase2 = new String[] { "a" };
        int testCase2ExpectedResult = 1;

        assertEquals(testCase1ExpectedResult, uniqueMorseRepresentations(testCase1));
        assertEquals(testCase2ExpectedResult, uniqueMorseRepresentations(testCase2));
    }
}