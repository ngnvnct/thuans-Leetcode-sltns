import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class longest_palindromic_subsequence {
    
    public int longestPalindromeSubseq(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int[][] dp = new int[s.length()+1][s.length()+1];
        StringBuilder sbr = new StringBuilder(s);
        String rs = sbr.reverse().toString();

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= rs.length(); j++) {
                if (s.charAt(i-1) == rs.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][rs.length()];
    }

    public int longestPalindromeSubseq2(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        StringBuilder sbr = new StringBuilder(s);
        String rs = sbr.reverse().toString();
        int[] previous = new int[s.length()+1];
        int[] current = new int[s.length()+1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= rs.length(); j++) {
                if (s.charAt(i-1) == rs.charAt(j-1)) {
                    current[j] = 1 + previous[j-1];
                } else {
                    current[j] = Math.max(previous[j], current[j-1]);
                }
            }
            int[] temp = previous;
            previous = current;
            current = temp;
        }
        return previous[s.length()];
    }

    @Test
    public void testPalindrome() {
        assertEquals(4, longestPalindromeSubseq("bbbab0"));
        assertEquals(0, longestPalindromeSubseq(""));
        assertEquals(2, longestPalindromeSubseq("cbbd"));
        assertEquals(4, longestPalindromeSubseq2("bbbab0"));
        assertEquals(0, longestPalindromeSubseq2(""));
        assertEquals(2, longestPalindromeSubseq2("cbbd"));
    }
}

/*
https://leetcode.com/problems/longest-palindromic-subsequence/
Explanation
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements

Easy way to solve this problem is by turning it into a longest common subsequence problem.
A palindrome reads the same forward as backward, so if we reversed the string, we can do LCS and find the longest LCS using Dynamic Programming

Time: O(n^2)
Space: O(n^2) or O(n) with Space optimized
*/