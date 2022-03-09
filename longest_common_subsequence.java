import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class longest_common_subsequence {
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

    @Test
    public void testLCS() {
        assertEquals(3, longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, longestCommonSubsequence("abc", "abc"));
        assertEquals(0, longestCommonSubsequence("abc", "def"));
        assertEquals(4, longestCommonSubsequence("XMJYAUZ", "MZJAWXU"));
    }
}

/*abstract
Explanation
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

Time: O(m * n)
Space: O(m * n)
*/