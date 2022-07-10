import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class Backspace_String_Compare_844 {
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
        assertTrue(backspaceCompare("ab#c", "ad#c"));
        assertTrue(backspaceCompare("ab##", "c#d#"));
        assertFalse(backspaceCompare("a#c", "b"));
        assertTrue(backspacePointers("ab#c", "ad#c"));
        assertTrue(backspacePointers("ab##", "c#d#"));
        assertFalse(backspacePointers("a#c", "b"));
    }
}

/*
https://leetcode.com/problems/backspace-string-compare/
Explanation



*/