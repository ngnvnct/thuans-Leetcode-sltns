/*
 * https://leetcode.com/problems/reverse-string/
 * Explanation:
 * 
 * Two pointer approach, keep the left index and the right index, loop to the
 * half way point and swap the element
 * 
 * Time: O(n)
 * Space: O(1)
 * 
 * Recursion with Two Pointers
 * Base Case: if start is greater than or equal to end, do nothing
 * else swap character at start index and character at end index, and call the
 * helper function at start+1 and end-1
 * 
 * TIme: O(n)
 * Space: O(n) to keep the recursion stack
 * 
 * Testing: reverseStringTest and reverseStringRecursionTest are just method to test the reverse methods
 */

package two_pointers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class problem_0344_reverse_string {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    public char[] reverseStringTest(char[] s) {
        reverseString((s));
        return s;
    }
    
    public void reverseStringRecursion(char[] s) {
        helper(0, s.length - 1, s);
    }

    public char[] reverseStringRecursionTest(char[] s) {
        reverseStringRecursion(s);
        return s;
    }

    public void helper(int start, int end, char[] s) {
        if (start >= end) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        helper(start + 1, end - 1, s);
    }

    @Test
    public void testReverseString() {
        char[] testCase1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
        char[] testCase1ExpectedResult = new char[] { 'o', 'l', 'l', 'e', 'h' };
        char[] testCase2 = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
        char[] testCase2ExpectedResult = new char[] { 'h', 'a', 'n', 'n', 'a', 'H' };

        reverseStringTest(testCase1);
        reverseStringTest(testCase2);
        assertArrayEquals(testCase1ExpectedResult, testCase1);
        assertArrayEquals(testCase2ExpectedResult, testCase2);
    }

    @Test
    public void testReverseStringRecursion() {
        char[] testCase1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
        char[] testCase1ExpectedResult = new char[] { 'o', 'l', 'l', 'e', 'h' };
        char[] testCase2 = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
        char[] testCase2ExpectedResult = new char[] { 'h', 'a', 'n', 'n', 'a', 'H' };

        reverseStringRecursion(testCase1);
        reverseStringRecursion(testCase2);
        assertArrayEquals(testCase1ExpectedResult, testCase1);
        assertArrayEquals(testCase2ExpectedResult, testCase2);
    }
}
