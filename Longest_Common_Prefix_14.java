import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Longest_Common_Prefix_14 {
    public String longestCommonPrefixHorizontal(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            while (words[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public String longestCommonPrefixVertical(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        String prefix = words[0];
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            for (int j = 1; j < words.length; j++) {
                if (i >= words[j].length() || words[j].charAt(i) != c) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }

    @Test
    public void testPrefix() {
        String[] exampleOne = { "horse", "honk", "hope" };
        String exampleOneExpectedResult = "ho";
        String[] exampleTwo = { "verylong", "verygood", "ve" };
        String exampleTwoExpectedResult = "ve";
        String[] exampleThree = { "dog", "racecar", "car" };
        String exampleThreeExpectedResult = "";

        assertEquals(exampleOneExpectedResult, longestCommonPrefixHorizontal(exampleOne));
        assertEquals(exampleTwoExpectedResult, longestCommonPrefixHorizontal(exampleTwo));
        assertEquals(exampleThreeExpectedResult, longestCommonPrefixHorizontal(exampleThree));

        assertEquals(exampleOneExpectedResult, longestCommonPrefixVertical(exampleOne));
        assertEquals(exampleTwoExpectedResult, longestCommonPrefixVertical(exampleTwo));
        assertEquals(exampleThreeExpectedResult, longestCommonPrefixVertical(exampleThree));
    }
}

/*
 * https://leetcode.com/problems/longest-common-prefix/
 * Explanation
 * 
 * For horizontal scanning, we take the first element as our prefix string, and
 * we loop through the string array
 * Using indexOf String built in method. It retrieve the index position at which
 * a particular character
 * or substring appears in another string
 * We decrement the prefix string until the indexOf is 0 ("flower", "flow"), the
 * while loop will terminate when it is "flow"
 * 
 * For vertical scanning, we take the first element as our prefix string, and we
 * loop through its character
 * then we compare it with the character of the next string
 * the moment they are not the same, return the substring
 * 
 * String myStr = "Hello planet earth, you are a great planet.";
 * System.out.println(myStr.indexOf("planet"));
 * It will be at index 6
 * 
 * Time: O(n) where n is the sum of all characters in a strings
 * In the best case, vertical scanning will be at most O(n * minLen) comparison
 * where minLen is the length of the shortest string
 * Space: O(1)
 */