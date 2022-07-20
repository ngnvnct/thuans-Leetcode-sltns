import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Generate_Document_Expert {
    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> charFrequencies = new HashMap<>();

        for (int i = 0; i < characters.length(); i++) {
            char c = characters.charAt(i);
            charFrequencies.put(c, charFrequencies.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < document.length(); i++) {
            char d = document.charAt(i);
            int wordConstruct = charFrequencies.getOrDefault(d, 0);

            // if (!charFrequencies.containsKey(d) || charFrequencies.get(d) == 0) {
            // return false;
            // }

            if (wordConstruct == 0) {
                return false;
            }

            charFrequencies.put(d, charFrequencies.get(d) - 1);
        }
        return true;
    }

    public boolean generateDocument2(String characters, String document) {
        Map<Character, Integer> charFrequencies = new HashMap<>();

        for (int i = 0; i < characters.length(); i++) {
            char c = characters.charAt(i);
            charFrequencies.put(c, charFrequencies.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < document.length(); i++) {
            char d = document.charAt(i);

            if (charFrequencies.containsKey(d)) {
                charFrequencies.put(d, charFrequencies.get(d) - 1);
                if (charFrequencies.get(d) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testDocument() {
        assertTrue(generateDocument("a", "a"));
        assertTrue(generateDocument("a hsgalhsa sanbjksbdkjba kjx", ""));
        assertTrue(generateDocument("     ", "     "));
        assertTrue(generateDocument("aheaollabbhb", "hello"));
        assertTrue(generateDocument("helloworld0 ", "hello w0rld"));
        assertTrue(generateDocument("&*&you^a%^&8766 _=-09     docanCMakemthisdocument", "Can you make this document &"));
        assertTrue(generateDocument("abcabcabcacbcdaabc", "bacaccadac"));
        assertFalse(generateDocument("A", "a"));
        assertFalse(generateDocument(" ", "hello"));
        assertFalse(generateDocument("aheaolabbhb", "hello"));
        assertFalse(generateDocument("estssa", "testing"));
        assertFalse(generateDocument("helloworld ", "hello w0rld"));
        assertFalse(generateDocument("helloword0", "hello w0rld"));

        assertTrue(generateDocument2("a", "a"));
        assertTrue(generateDocument2("a hsgalhsa sanbjksbdkjba kjx", ""));
        assertTrue(generateDocument2("     ", "     "));
        assertTrue(generateDocument2("aheaollabbhb", "hello"));
        assertTrue(generateDocument2("helloworld0 ", "hello w0rld"));
        assertTrue(generateDocument2("&*&you^a%^&8766 _=-09     docanCMakemthisdocument", "Can you make this document &"));
        assertTrue(generateDocument2("abcabcabcacbcdaabc", "bacaccadac"));
        assertFalse(generateDocument2("A", "a"));
        assertFalse(generateDocument2(" ", "hello"));
        assertFalse(generateDocument2("aheaolabbhb", "hello"));
        assertFalse(generateDocument2("estssa", "testing"));
        assertFalse(generateDocument2("helloworld ", "hello w0rld"));
        assertFalse(generateDocument2("helloword0", "hello w0rld"));
    }
}

/*
 * The exact problem as Ransom Note 383, AlgoExpert
 * https://leetcode.com/problems/ransom-note/
 * Explanation
 * 
 * The only difference is that this problem you can construct a space ""
 * character, and if the character string doesn't contain space character you
 * can't generate the document.
 * Build a hash map of character frequencies then loop through the String
 * document and check to see if it is in the hash map, if the value is greater
 * than 0, decrement it
 * if it is in the hash map but the value is 0 OR it is not in the hash map,
 * return false
 * if the loop finishes return true
 * 
 * Uncomment Line 22-24 replace by Line 26-28 show case that you can solve with Ransom Note method
 * 
 * Time: O(m + n) because the constraints show that they have to be equal to
 * each other
 * Space: O(n)
 */