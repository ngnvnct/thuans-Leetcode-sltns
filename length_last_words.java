import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class length_last_words {
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
        String one = "Hello World";
        String two = "   fly me   to   the moon  ";
        String three = "luffy is still joyboy";
        assertEquals(5, lengthOfLastWord(one));
        assertEquals(5, lengthOfLastWord2(one));
        assertEquals(4, lengthOfLastWord(two));
        assertEquals(4, lengthOfLastWord2(two));
        assertEquals(6, lengthOfLastWord(three));
        assertEquals(6, lengthOfLastWord2(three));
        assertEquals(5, lengthOfLastWord3(one));
        assertEquals(4, lengthOfLastWord3(two));
        assertEquals(6, lengthOfLastWord3(three));
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