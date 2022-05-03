import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class backspace_string_compare {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stackS = new ArrayDeque<>();
        Deque<Character> stackT = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!stackS.isEmpty()) {
                    stackS.removeFirst();
                }
            } else {
                stackS.addFirst(c);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!stackT.isEmpty()) {
                    stackT.removeFirst();
                }
            } else {
                stackT.addFirst(c);
            }
        }
        if (stackS.size() != stackT.size()) {
            return false;
        }
        while (!stackS.isEmpty()) {
            if (stackS.peek() == stackT.peek()) {
                stackS.pop();
                stackT.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean backspacePointers(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    @Test
    public void testCompare() {
        assertEquals(true, backspaceCompare("ab#c", "ad#c"));
        assertEquals(true, backspaceCompare("ab##", "c#d#"));
        assertEquals(false, backspaceCompare("a#c", "b"));
        assertEquals(true, backspacePointers("ab#c", "ad#c"));
        assertEquals(true, backspacePointers("ab##", "c#d#"));
        assertEquals(false, backspacePointers("a#c", "b"));
    }
}

/*abstract
Explanation



*/