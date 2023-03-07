import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class First_Letter_To_Appear_Twice_2351 {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        char ch = '\0';

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return c;
            }
            set.add(c);
        }
        return ch;
    }

    public char repeatedCharacter2(String s) {
        int[] alphabet = new int[26];

        for (char c : s.toCharArray()) {
            if (++alphabet[c - 'a'] == 2) {
                return c;
            }
        }
        return 'a';
    }

    @Test
    public void testLetter() {
        String testCase1 = "abccbaacz";
        char testCase1ExpectedResult = 'c';
        String testCase2 = "abcdd";
        char testCase2ExpectedResult = 'd';

        assertEquals(testCase1ExpectedResult, repeatedCharacter(testCase1));
        assertEquals(testCase2ExpectedResult, repeatedCharacter(testCase2));

        assertEquals(testCase1ExpectedResult, repeatedCharacter2(testCase1));
        assertEquals(testCase2ExpectedResult, repeatedCharacter2(testCase2));
    }
}

/*
 * https://leetcode.com/problems/first-letter-to-appear-twice/
 * Explanation
 * 
 * Method 1: make a hash set and add each character into it, the moment you see
 * a duplicate return it
 * Method 2: since the constraint is only lower case English letters, you can
 * just make a bucket of 26 alphabet
 * and the moment the count reaches two, return it.
 * 
 * Time: O(n) where n is the length of the string
 * Space: O(n) where n is the length of the string, or O(1)
 */