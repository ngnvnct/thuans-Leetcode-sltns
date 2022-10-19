import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Remove_Vowels_From_A_String_1119 {
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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
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
        String exampleOneExpectedResult = "ltcdscmmntyfrcdrs";
        String exampleTwo = "aeiou";
        String exampleTwoExpectedResult = "";

        assertEquals(exampleOneExpectedResult, removeVowels(exampleOne));
        assertEquals(exampleTwoExpectedResult, removeVowels(exampleTwo));

        assertEquals(exampleOneExpectedResult, removeVowels2(exampleOne));
        assertEquals(exampleTwoExpectedResult, removeVowels2(exampleTwo));

        assertEquals(exampleOneExpectedResult, removeVowels3(exampleOne));
        assertEquals(exampleTwoExpectedResult, removeVowels3(exampleTwo));
    }
}

/*
 * https://leetcode.com/problems/remove-vowels-from-a-string/ LC Premium
 * Explanation
 * 
 * We can make a set of vowels, then at each character, check if it is in the
 * set, continue if it is, else add it to the result string
 * 
 * Time: O(n)
 * Space: O(5)
 */