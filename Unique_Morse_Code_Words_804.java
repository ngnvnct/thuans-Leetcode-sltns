import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Unique_Morse_Code_Words_804 {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> seen = new HashSet<>();
        String[] morseAlphabet = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morseAlphabet[word.charAt(i) - 'a']);
            }
            seen.add(sb.toString());
        }
        return seen.size();
    }

    @Test
    public void testMorse() {
        assertEquals(2, uniqueMorseRepresentations(new String[] { "gin", "zen", "gig", "msg" }));
        assertEquals(1, uniqueMorseRepresentations(new String[] { "a" }));
    }
}

/*
 * https://leetcode.com/problems/unique-morse-code-words/
 * 
 * Put morse code out of the word in a string then add it to a hash set, return
 * the size of the hash set is the unique morse code words
 * 
 * Time: O(n)
 * Space: O(n)
 */