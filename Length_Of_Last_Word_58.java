import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Length_Of_Last_Word_58 {
    public int lengthOfLastWord(String s) {
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }

        int length = 0;
        while (p >= 0 && s.charAt(p) != ' ') {
            p--;
            length++;
        }
        return length;
    }

    public int lengthOfLastWord2(String s) {
        s = s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

    public int lengthOfLastWord3(String s) {
        int p = s.length();
        int length = 0;
        while (p > 0) {
            p--;
            if (s.charAt(p) != ' ') {
                length++;
            } else if (length > 0) {
                return length;
            }
        }
        return length;
    }

    @Test
    public void testLength() {
        String testCase1 = "Hello World";
        int testCase1ExpectedResult = 5;
        String testCase2 = "   fly me   to   the moon  ";
        int testCase2ExpectedResult = 4;
        String testCase3 = "luffy is still joyboy";
        int testCase3ExpectedResult = 6;

        assertEquals(testCase1ExpectedResult, lengthOfLastWord(testCase1));
        assertEquals(testCase2ExpectedResult, lengthOfLastWord(testCase2));
        assertEquals(6, lengthOfLastWord(testCase3));

        assertEquals(testCase1ExpectedResult, lengthOfLastWord2(testCase1));
        assertEquals(testCase2ExpectedResult, lengthOfLastWord2(testCase2));
        assertEquals(testCase3ExpectedResult, lengthOfLastWord2(testCase3));

        assertEquals(testCase1ExpectedResult, lengthOfLastWord3(testCase1));
        assertEquals(testCase2ExpectedResult, lengthOfLastWord3(testCase2));
        assertEquals(testCase3ExpectedResult, lengthOfLastWord3(testCase3));
    }
}

/*
 * https://leetcode.com/problems/length-of-last-word/
 * Explanation
 * 
 * Trim trailing white spaces with the first loop (if trim() is not allowed),
 * then just loop until you find the next whitespace
 * 
 * One loop
 * "   fly me   to   the moon  "
 * we set p equals to the length of the string, and we decrement every time, we
 * have and if and an else if
 * if it is not a white space, that means we are in the present of the last
 * word, increment count, if we see a white space and length > 0, we are done,
 * return it
 * 
 * Time: O(n)
 * Space: O(1)
 */