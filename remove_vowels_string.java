import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class remove_vowels_string {
    public String removeVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                continue;
            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }

    public String removeVowels2(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                continue;
            }
            res += s.charAt(i);
        }
        return res;
    }

    public boolean isVowel(char vowel) {
        return vowel == 'a' || vowel == 'e' || vowel == 'i' || vowel == 'o' || vowel == 'u';
    }

    public String removeVowels3(String s) {
        return s.replaceAll("[aeiou]", "");
    }

    @Test
    public void testRemoveVowels() {
        String exampleOne = "leetcodeisacommunityforcoders";
        String expectedOne = "ltcdscmmntyfrcdrs";
        String exampleTwo = "aeiou";
        String expectedTwo = "";

        assertEquals(expectedOne, removeVowels(exampleOne));
        assertEquals(expectedTwo, removeVowels(exampleTwo));
        assertEquals(expectedOne, removeVowels2(exampleOne));
        assertEquals(expectedTwo, removeVowels2(exampleTwo));
        assertEquals(expectedOne, removeVowels3(exampleOne));
        assertEquals(expectedTwo, removeVowels3(exampleTwo));
    }
}

/*
Explanation

We can make a set of vowels, then at each character, check if it is in the set, continue if it is, else add it to the result string

Time: O(n)
Space: O(5)
*/