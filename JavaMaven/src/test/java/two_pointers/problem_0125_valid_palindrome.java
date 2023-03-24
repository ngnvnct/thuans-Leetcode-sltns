/*
 * https://leetcode.com/problems/valid-palindrome/
 * Explanation:
 * 
 * Method 1, replace everything to lowercase and remove space, we only need to
 * check the first half of the string, since the other half is just the reverse
 * of it, two pointer appoarch
 * Method 2, using Character.isLetterOrDigit to skip the " " space character
 * Method 3, don't have to use char array
 * 
 * A man, a plan, a canal: Panama turn into
 * a man, a plan, a canal: Panama
 * compare a and a, okay
 * space on left, increment, compare m and m
 * compare a and a
 * .....
 * return true
 * 
 * Time: O(n)
 * Space: O(1)
 */

package two_pointers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class problem_0125_valid_palindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] charArray = s.toLowerCase().toCharArray();

        while (left < right) {
            while (!Character.isLetterOrDigit(charArray[left]) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(charArray[right]) && left < right) {
                right--;
            }
            if (charArray[left++] != charArray[right--]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right--;
            }
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testPalindrome() {
        String testCase1 = "A man, a plan, a canal: Panama";
        String testCase2 = "race a car";
        String testCase3 = " ";

        assertTrue(isPalindrome(testCase1));
        assertFalse(isPalindrome(testCase2));
        assertTrue(isPalindrome(testCase3));

        assertTrue(isPalindrome2(testCase1));
        assertFalse(isPalindrome2(testCase2));
        assertTrue(isPalindrome2(testCase3));

        assertTrue(isPalindrome3(testCase1));
        assertFalse(isPalindrome3(testCase2));
        assertTrue(isPalindrome3(testCase3));
    }
}