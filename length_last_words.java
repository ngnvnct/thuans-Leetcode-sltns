import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class length_last_words {
    public int lengthOfLastWord(String s) {
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }

        int length = 0;
        while(p >= 0 && s.charAt(p) != ' ') {
            p--;
            length++;
        }
        return length;
    }

    public int lengthOfLastWord2(String s) {
        s = s.trim();
        int count = 0;
        for (int i = s.length() -1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

    @Test
    public void testLength() {
        String one = "Hello World";
        String two = "   fly me   to   the moon  ";
        String three = "luffy is still joyboy";
        assertEquals(5,lengthOfLastWord(one));
        assertEquals(5,lengthOfLastWord2(one));
        assertEquals(4,lengthOfLastWord(two));
        assertEquals(4,lengthOfLastWord2(two));
        assertEquals(6,lengthOfLastWord(three));
        assertEquals(6,lengthOfLastWord2(three));
    }
}

/*abstract
Explanation

Trim trailing white spaces with the first loop (if trim() is not allowed), then just loop until you find the next whitespace

Time: O(n)
Space: O(1)
*/