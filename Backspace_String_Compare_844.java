import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Test;

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
        String testCase1 = "ad#c";
        String testCase1ExpectedResult = "ab#c";
        String testCase2 = "c#d#";
        String testCase2ExpectedResult = "ab##";
        String testCase3 = "b";
        String testCase3ExpectedResult = "a#c";

        assertTrue(backspaceCompare(testCase1ExpectedResult, testCase1));
        assertTrue(backspaceCompare(testCase2ExpectedResult, testCase2));
        assertFalse(backspaceCompare(testCase3ExpectedResult, testCase3));

        assertTrue(backspacePointers(testCase1ExpectedResult, testCase1));
        assertTrue(backspacePointers(testCase2ExpectedResult, testCase2));
        assertFalse(backspacePointers(testCase3ExpectedResult, testCase3));
    }
}

/*
Leetcode75
https://leetcode.com/problems/backspace-string-compare/
Explanation

wee

*/