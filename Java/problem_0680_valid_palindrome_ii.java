/*
 * https://leetcode.com/problems/valid-palindrome-ii/
 * Explanation:
 * 
 * We want to have a helper function that can perform a palindrome check on our
 * sub string
 * isPalindrome(s, i+1, j) or isPalindrome(s, i, j-1)
 * 
 * "abccbxa"
 * "bccbx", delete b
 * verify that "ccbx" is a palindrome (left+1)
 * "bccbx", delete x
 * verify that "bccb" is a palindrome (right-1)
 * Return false if neither gives us what we want
 * 
 * Meta Follow Up: Valid Palindrome III
 * 
 * Time: O(n), because we are only allowed up to one deleetion, isPalindrome()
 * will never be called more than twice
 * Space: O(1)
 */

package Java;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class problem_0680_valid_palindrome_ii {
    public boolean validPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        while (leftPointer < rightPointer) {
            if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                return isPalindrome(s, leftPointer + 1, rightPointer) || isPalindrome(s, leftPointer, rightPointer - 1);
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int leftPointer, int rightPointer) {
        while (leftPointer < rightPointer) {
            if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    @Test
    public void testPalindrome() {
        String testCase1 = "aba";
        String testCase2 = "abca";
        String testCase3 = "abc";
        String testCase4 = "abccbxa";

        assertTrue(validPalindrome(testCase1));
        assertTrue(validPalindrome(testCase2));
        assertFalse(validPalindrome(testCase3));
        assertTrue(validPalindrome(testCase4));
    }
}