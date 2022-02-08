import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class valid_anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
            if (alphabet[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testAnagram() {
        assertEquals(true, isAnagram("anagram", "nagaram"));
        assertEquals(false, isAnagram("rat", "cat"));
        assertEquals(false, isAnagram("anagram", "agaram"));
    }
}

/*
Explanation

Make a alphabet array of 26 elements. Take the current character subtract by 'a' to get the ASCII code value of that letter. For example, 'a' is 97 and 'z' is 122, 122-97 = 25, the last element
in the alphabet array. Loop through the string and increment the alphabet element, then loop through the 2nd string and decrement the alphabet element. If the array element is negative, it is not an anagram

Time: O(2n) -> O(n)
Space: O(26) -> O(1)

*/