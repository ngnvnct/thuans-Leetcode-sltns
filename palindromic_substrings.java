import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class palindromic_substrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) return 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += expandAroundCenter(s, i, i);
            ans += expandAroundCenter(s, i, i + 1);
        }
        return ans;
    }

    public int countSubstrings2(String s) {
        if (s == null || s.length() < 1) return 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += expandAroundCenter2(s, i, i);
            ans += expandAroundCenter2(s, i, i + 1);
        }
        return ans;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int ans = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            ans++;
        }
        return ans;
    }
    private int expandAroundCenter2(String s, int left, int right) {
        int ans = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
            ans++;
        }
        return ans;
    }

    @Test
    public void testPalindrome() {
        assertEquals(3, countSubstrings("abc"));
        assertEquals(6, countSubstrings("aaa"));
        assertEquals(3, countSubstrings2("abc"));
        assertEquals(6, countSubstrings2("aaa"));
    }
}

/*
https://leetcode.com/problems/palindromic-substrings/
Explanation

Simliar to longest palindromic substring, expand outward from the center

"aaab", need to do odd length and even length
Odd Length, Left = Right
Even Length, Right = Left + 1

Time: O(n^2)
Space: O(1)
*/