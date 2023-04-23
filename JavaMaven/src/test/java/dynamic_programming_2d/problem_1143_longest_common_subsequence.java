/*
https://leetcode.com/problems/longest-common-subsequence/
Explanation:

Let X be “XMJYAUZ” and Y be “MZJAWXU”. The longest common subsequence between X and Y is “MJAU”
The following table shows the lengths of the longest common subsequences between prefixes of X and Y. The ith row and jth column shows the length of the LCS between X_{1..i} and Y_{1..j}
    0 1 2 3 4 5 6 7
      M Z J A W X U
0   0 0 0 0 0 0 0 0 
1 X 0 0 0 0 0 0 1 1
2 M 0 1 1 1 1 1 1 1
3 J 0 1 1 2 2 2 2 2
4 Y 0 1 1 2 2 2 2 2
5 A 0 1 1 2 3 3 3 3
6 U 0 1 1 2 3 3 3 4
7 Z 0 1 1 2 3 3 3 4

Method 3 and Method 4 are space optimized. We only look at the current column and the previous column, so instead of keeping track of the entire 2D array, we only need the last two columns.

Time: O(m * n)
Space: O(m * n) or O(min(m,n)) for method 3 and 4
*/

package dynamic_programming_2d;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class problem_1143_longest_common_subsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); ++i) {
            for (int j = 0; j < text2.length(); ++j) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j]; 
                } else {
                    dp[i + 1][j + 1] =  Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        // Just here to demonstrate the dynamic programming
        // In Java, array is fill with 0 so this is optional
        // for (int i = 0; i < text1.length(); i++) {
        //     dp[i][0] = 0;
        // }
        // for (int j = 0; j < text2.length(); j++) {
        //     dp[0][j] = 0;
        // }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequence3(String text1, String text2) {
        if (text2.length() < text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        int[] previous = new int[text1.length() + 1];
        
        for (int col = 1; col <= text2.length(); col++) {
            int[] current = new int[text1.length() + 1];
            for (int row = 1; row <= text1.length(); row++) {
                if (text1.charAt(row-1) == text2.charAt(col-1)) {
                    current[row] = 1 + previous[row - 1];
                } else {
                    current[row] = Math.max(previous[row], current[row - 1]);
                }
            }
            previous = current;
        }
        return previous[text1.length()];
    }

    public int longestCommonSubsequence4(String text1, String text2) {
        if (text2.length() < text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        int[] previous = new int[text1.length() + 1];
        int[] current = new int[text1.length() + 1];
        
        for (int col = 1; col <= text2.length(); col++) {
            for (int row = 1; row <= text1.length(); row++) {
                if (text1.charAt(row-1) == text2.charAt(col-1)) {
                    current[row] = 1 + previous[row - 1];
                } else {
                    current[row] = Math.max(previous[row], current[row - 1]);
                }
            }
            int[] temp = previous;
            previous = current;
            current = temp;
        }
        return previous[text1.length()];
    }

    @Test
    public void testLongestCommonSubsequence() {
        String testCase1Text1 = "abcde";
        String testCase1Text2 = "ace";
        int testCase1ExpectedResult = 3;

        String testCase2Text1 = "abc";
        String testCase2Text2 = "abc";
        int testCase2ExpectedResult = 3;

        String testCase3Text1 = "abc";
        String testCase3Text2 = "def";
        int testCase3ExpectedResult = 0;

        String testCase4Text1 = "XMJYAUZ";
        String testCase4Text2 = "MZJAWXU";
        int testCase4ExpectedResult = 4;

        assertEquals(testCase1ExpectedResult, longestCommonSubsequence(testCase1Text1, testCase1Text2));
        assertEquals(testCase2ExpectedResult, longestCommonSubsequence(testCase2Text1, testCase2Text2));
        assertEquals(testCase3ExpectedResult, longestCommonSubsequence(testCase3Text1, testCase3Text2));
        assertEquals(testCase4ExpectedResult, longestCommonSubsequence(testCase4Text1, testCase4Text2));

        assertEquals(testCase1ExpectedResult, longestCommonSubsequence2(testCase1Text1, testCase1Text2));
        assertEquals(testCase2ExpectedResult, longestCommonSubsequence2(testCase2Text1, testCase2Text2));
        assertEquals(testCase3ExpectedResult, longestCommonSubsequence2(testCase3Text1, testCase3Text2));
        assertEquals(testCase4ExpectedResult, longestCommonSubsequence2(testCase4Text1, testCase4Text2));

        assertEquals(testCase1ExpectedResult, longestCommonSubsequence3(testCase1Text1, testCase1Text2));
        assertEquals(testCase2ExpectedResult, longestCommonSubsequence3(testCase2Text1, testCase2Text2));
        assertEquals(testCase3ExpectedResult, longestCommonSubsequence3(testCase3Text1, testCase3Text2));
        assertEquals(testCase4ExpectedResult, longestCommonSubsequence3(testCase4Text1, testCase4Text2));

        assertEquals(testCase1ExpectedResult, longestCommonSubsequence4(testCase1Text1, testCase1Text2));
        assertEquals(testCase2ExpectedResult, longestCommonSubsequence4(testCase2Text1, testCase2Text2));
        assertEquals(testCase3ExpectedResult, longestCommonSubsequence4(testCase3Text1, testCase3Text2));
        assertEquals(testCase4ExpectedResult, longestCommonSubsequence4(testCase4Text1, testCase4Text2));
    }
}