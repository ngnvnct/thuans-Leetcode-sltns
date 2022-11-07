import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Most_Common_Word_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] split = normalizedStr.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (String s : banned) {
            set.add(s);
        }

        for (String word : split) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        int maxFreq = 0;
        String res = "";

        for (String str : map.keySet()) {
            if (map.get(str) > maxFreq) {
                maxFreq = map.get(str);
                res = str;
            }
        }
        return res;
    }

    @Test
    public void testMostCommonWord() {
        assertEquals("ball",mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" }));
        assertEquals("a", mostCommonWord("a.", new String[0]));
    }
}

/*
 * https://leetcode.com/problems/most-common-word/
 * Explanation
 * 
 * Use replace all to replace all the symbol and and extra white space and turn
 * it into lower case
 * Split the string into array, build a list of banned word in a set
 * If the word is not in the set, calculate the frequency
 * 
 * At the end get the frequency
 * 
 * Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey()
 * 
 * This line can be used for the last step
 * 
 * Time: O(n + m), O(n) to process each stage, O(m) to build the hash set
 * Space: O(n + m), O(n) to build the hash map, O(m) to build a set out of
 * banned word list
 */