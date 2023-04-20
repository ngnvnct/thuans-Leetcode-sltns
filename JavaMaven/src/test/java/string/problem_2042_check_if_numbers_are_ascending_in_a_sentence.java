/*
 * https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
 * Explanation:
 * 
 * Multiple ways to do it, tokenization or just loop through the string
 * normally, and get the num using our favorite formular
 * num = num * 10 + (currentChar - '0');
 * 
 * then check with the previous, if it is smaller or equal to previousNum,
 * return false, else make previousNum becomes currentNum
 * return true when the loop terminate
 * 
 * Time: O(n)
 * Space: O(1) not counting input string
 */
package string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class problem_2042_check_if_numbers_are_ascending_in_a_sentence {
    public static boolean areNumbersAscending(String s) {
        int i = 0;
        int num = 0;
        int prev = 0;

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }
                if (num <= prev) {
                    return false;
                }
                prev = num;

            } else {
                i++;
            }
        }
        return true;
    }

    public boolean areNumbersAscending2(String s) {
        int num = 0;
        int prev = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = 0;
                while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }
                if (num <= prev) {
                    return false;
                }
                prev = num;
            } else {
                i++;
            }
        }
        return true;
    }

    @Test
    public void testAscending() {
        String testCase1 = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        String testCase2 = "hello world 5 x 5";
        String testCase3 = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        String testCase4 = "this 1 is 2 an 3 ascending 4 sentence";
        String testCase5 = "10 9 8 7 6 5 4 3 2 1";
        String testCase6 = "3 5 1 7 9 2 6 8 10";
        String testCase7 = "1 1 1 1 1 1 1 1 1";

        assertTrue(areNumbersAscending(testCase1));
        assertFalse(areNumbersAscending(testCase2));
        assertFalse(areNumbersAscending(testCase3));
        assertTrue(areNumbersAscending(testCase4));
        assertFalse(areNumbersAscending(testCase5));
        assertFalse(areNumbersAscending(testCase6));
        assertFalse(areNumbersAscending(testCase7));

        assertTrue(areNumbersAscending2(testCase1));
        assertFalse(areNumbersAscending2(testCase2));
        assertFalse(areNumbersAscending2(testCase3));
        assertTrue(areNumbersAscending2(testCase4));
        assertFalse(areNumbersAscending2(testCase5));
        assertFalse(areNumbersAscending2(testCase6));
        assertFalse(areNumbersAscending2(testCase7));
    }
}