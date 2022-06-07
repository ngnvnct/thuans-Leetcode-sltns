public class wildcard_matching {
    public boolean isMatch(String query, String template) {
        int queryLen = query.length(), pLen = template.length();
        int queryIndex = 0, templateIndex = 0;
        int starIndex = -1, queryTempIndex = -1;

        while (queryIndex < queryLen) {
            // If the pattern caracter = string character
            // or pattern character = '?'
            if (templateIndex < pLen && (template.charAt(templateIndex) == '?' || template.charAt(templateIndex) == query.charAt(queryIndex))) {
                ++queryIndex;
                ++templateIndex;
    
            // If pattern character = '*'
            } else if (templateIndex < pLen && template.charAt(templateIndex) == '*') {
                // Check the situation
                // when '*' matches no characters
                starIndex = templateIndex;
                queryTempIndex = queryIndex;
                ++templateIndex;
                          
            // If pattern character != string character
            // or pattern is used up
            // and there was no '*' character in pattern 
            } else if (starIndex == -1) {
                return false;
                          
            // If pattern character != string character
            // or pattern is used up
            // and there was '*' character in pattern before
            } else {
                // Backtrack: check the situation
                // when '*' matches one more character
                templateIndex = starIndex + 1;
                queryIndex = queryTempIndex + 1;
                queryTempIndex = queryIndex;
            }
        }

        // The remaining characters in the pattern should all be '*' characters
        for (int i = templateIndex; i < pLen; i++) {
            if (template.charAt(i) != '*') {
                return false;
            }
   
        }
        return true;
    }

    public boolean isMatchDP(String query, String template) {
        if(query == null || template == null) return false;
        int sLen = query.length();
        int pLen = template.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        
        // Base cases:
        dp[0][0] = true;
        // This for loop is unneeded because the boolean array is initalize to false
        //first col: dp[i][0], can't match when template is empty, all false
        //for(int i = 1; i <= sLen; i++){
        //    dp[i][0] = false;
        //}

        //first row: dp[0][j] except for String template starts with *, otherwise all false
        for(int j = 1; j <= pLen; j++){
            if(template.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }            
        }
        
        // Recursion:
        for(int i = 1; i <= sLen; i++){
            for(int j = 1; j <= pLen; j++){
                // the last && is a diagonal part
                if((query.charAt(i-1) == template.charAt(j-1) || template.charAt(j-1) == '?') && dp[i-1][j-1]) {
                    dp[i][j] = true;
                }

                // dp[i-1][j], means that "*" acts like an empty sequence (ab, ab*)
                // for dp[i][j-1], means that * acts like any sequences (abcd, ab*)
                else if (template.charAt(j-1) == '*' && (dp[i-1][j] || dp[i][j-1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[sLen][pLen];
    }
}

/*
https://leetcode.com/problems/wildcard-matching/
template: b*b*b*b*a
query: bbbbbbbbbbbbbbbbba (essentially the idea here is that it has to at least be 'bbbba' but any number of b's will also be valid
template: b*b*b*b*a
output: True

I have no idea how to explain the optimal solution
       0  1 2 3 4 5
       [] x ? y * z
0 []   T  F F F F F
1 x    F  T F F F F
2 a    F  F T F F F
3 y    F  F F T T F
3 l    F  F F F T F
4 m    F  F F F T F
5 z    F  F F F T T

       0  1 2 3 4 
       [] * a * a
0 []   T  T F F F
1 b    F  T F F F
2 b    F  T F F F
3 a    F  T T T F
4 a    F  T T T T


T[0][0] empty string and empty pattern
string "" and pattern "x", false
first column if there is a string and no pattern, they will always be false

T[i][j] = T[i-1][j-1] === T[i][j-1] T[i-1][j]

x? == xa, ? can match with anything, 
x?y == xay, look at diagonal value
x?y* == xay, if * is a zero sequence, look at the value on the left

DP Explanation
dp[i][j]: true if the first i char in String query matches the first j chars in String template
Base Case:
   origin: dp[0][0] = true
first row: dp[0][j] except for String template starts with *, otherwise all false
first col: dp[i][0], can't match when template is empty, all false

Recursion
Iterate through every dp[i][j]
dp[i][j] = true
   if (query[ith] == template[jth] || template[jtth] == '?') && dp[i-1][j-1] = true (diagonal))
   else if (template[jth] == '*' && dp[i-1][j] == true || dp[i][j-1] == true)
        for dp[i][j], means that "*" acts like an empty sequence (ab, ab*)
        for dp[i][j-1], means that * acts like any sequences (abcd, ab*)
Start from 0 to len
output should be dp[query.len][template.len]

Time:  O(m x n)
Space: O(m x n)
*/