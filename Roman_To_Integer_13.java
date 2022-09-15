import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Roman_To_Integer_13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }

    @Test
    public void testRomanToInt() {
        assertEquals(3, romanToInt("III"));
        assertEquals(58, romanToInt("LVIII"));
        assertEquals(1994, romanToInt("MCMXCIV"));
    }
}

/*
 * https://leetcode.com/problems/roman-to-integer/
 * Explanation
 * 
 * Make sure to ask if the input will be valid.
 * 
 * Make a hash map of all the symbol, then loop through the string
 * if the current string is smaller than the index+1 string, we subtract it from
 * our current result
 * else we just continue adding it
 * 
 * TIme: O(1) since there are only a finite set of roman numerals, if roman
 * numerals had an arbitrary number of symbols, it will be O(n)
 * Space: O(1)
 */
