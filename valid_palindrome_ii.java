import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class valid_palindrome_ii {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void testPalindrome() {
        assertEquals(true, validPalindrome("aba"));
        assertEquals(true, validPalindrome("abca"));
        assertEquals(false, validPalindrome("abc"));
    }
}

/*
https://leetcode.com/problems/valid-palindrome-ii/
Explanation

We want to have a helper function that can perform a palindrome check on our sub string
isPalindrome(s, i+1, j) or isPalindrome(s, i, j-1)

"abccbxa"
"bccbx", delete b
verify that "ccbx" is a palindrome (left+1)
"bccbx", delete x
verify that "bccb" is a palindrome (right-1)
Return false if neither gives us what we want

Meta Follow Up: Valid Palindrome III

Time: O(n), because we are only allowed up to one deleetion, isPalindrome() will never be called more than twice
Space: O(1)
*/