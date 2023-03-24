import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class find_words_that_can_be_formed_by_chars {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] alphabet = new int[26];
            for (int i = 0; i < chars.length(); i++) {
                alphabet[chars.charAt(i) - 'a']++;
            }
        
        for (String word : words) {
            int[] clone = alphabet.clone();
            int count = 0;
            
            for (int i = 0; i < word.length(); i++) {
                clone[word.charAt(i) - 'a']--;
                if (clone[word.charAt(i) - 'a'] < 0) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == word.length()) {
                res += word.length();
            }
        }
        return res;
    }

    @Test
    public void testCountCharacters() {
        assertEquals(6, countCharacters(new String[] {"cat", "bt", "hat", "tree"}, "atach"));
        assertEquals(10, countCharacters(new String[] {"hello", "world", "leetcode"}, "welldonehoneyr"));
    }
}

/*
https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
Explanation

Count the frequency of character, similar to the valid anagram problem. If the string is good, adds the length of it to the result.

Time: O(n * k), one loop that loops for every work, and an inner loop that loops through each char in that word
Space: O(26), keep 26 characters in the alphabet
*/