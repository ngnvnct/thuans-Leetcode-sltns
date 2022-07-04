import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class is_subsequence {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        if (s.isEmpty()) {
            return true;
        }

        while (tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
            if (sIndex == s.length()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubsequence2(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }

    public boolean is_subsequenceDP(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int col = 1; col <= t.length(); col++) {
            for (int row = 1; row <= s.length(); row++) {
                if (s.charAt(row - 1) == t.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
                }
            }
            if (dp[s.length()][t.length()] == s.length()) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testIsSubsequence() {
        assertTrue(isSubsequence("abc", "ahbgdc"));
        assertFalse(isSubsequence("axc", "ahbgdc"));
        assertTrue(isSubsequence2("abc", "ahbgdc"));
        assertFalse(isSubsequence2("axc", "ahbgdc"));
        assertTrue(is_subsequenceDP("abc", "ahbgdc"));
        assertFalse(is_subsequenceDP("axc", "ahbgdc"));
    }
}

/*
 * https://leetcode.com/problems/is-subsequence/
 * Explanation
 * 
 * This can be solve with two pointers, if source string matches, then increment
 * both index of source and target, if the index is equal to the length of the
 * source string, return true, when the loop ends
 * return false
 * 
 * The DP solution is practice for Edit Distance problem
 * 
 * Time: O(n)
 * Space: O(1) or O(n) for dp
 */