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
        String testCase1 = "leetcodeisacommunityforcoders";
        String testCase1ExpectedResult = "ltcdscmmntyfrcdrs";
        String testCase2 = "aeiou";
        String testCase2ExpectedResult = "";

        assertEquals(testCase1ExpectedResult, removeVowels(testCase1));
        assertEquals(testCase2ExpectedResult, removeVowels(testCase2));

        assertEquals(testCase1ExpectedResult, removeVowels2(testCase1));
        assertEquals(testCase2ExpectedResult, removeVowels2(testCase2));

        assertEquals(testCase1ExpectedResult, removeVowels3(testCase1));
        assertEquals(testCase2ExpectedResult, removeVowels3(testCase2));
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