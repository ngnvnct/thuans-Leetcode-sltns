public class longest_palindromic_substring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLength = expandAroundCenter(s, i, i);
            int evenLength = expandAroundCenter(s, i, i + 1);
            int resLen = Math.max(oddLength, evenLength);
            if (resLen > end - start) {
                start = i - (resLen - 1) / 2;
                end = i + resLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}

/*abstract
Explanation

Brute Force
babad
Scan through the entire array
n to scan through the array, and n^2 for all the substring
Brute Force Time: O(n^3)

We can start from the middle, and expand outward
n to scan through the array, and n to expand outward
O(n^2)

Edge Case, "cbbd", even palindrome

Time: O(n^2)
Space: O(1)
*/