import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class Isomorphic_Strings_205 {
    public boolean isIsomorphic(String source, String target) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < source.length(); i++) {
            if (map.containsKey(source.charAt(i)) && map.get(source.charAt(i)) != target.charAt(i)) {
                return false;
            } else if (!map.containsKey(source.charAt(i)) && set.contains(target.charAt(i))) {
                return false;
            } else {
                map.put(source.charAt(i), target.charAt(i));
                set.add(target.charAt(i));
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String source, String target) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);

            if (map.containsKey(currentChar)) {
                if (!map.get(currentChar).equals(target.charAt(i))) {
                    return false;
                }
            } else {
                if (map.containsValue(target.charAt(i))) {
                    return false;
                }
                map.put(currentChar, target.charAt(i));
            }
        }
        return true;
    }

    @Test
    public void testIsomorphic() {
        assertTrue(isIsomorphic("egg", "add"));
        assertFalse(isIsomorphic("foo", "bar"));
        assertTrue(isIsomorphic("paper", "title"));
        assertFalse(isIsomorphic("badc", "baba"));
    }
}

/*
 * Part of Leetcode75
 * https://leetcode.com/problems/isomorphic-strings/
 * Explanation
 * 
 * Use assertTrue and assertFalse for boolean test in JUnit
 * 
 * This problem is a classic hashmap and hashset problem. We keep a map to map the current char at the source into the target string
 * at each iteration we check if the map already contains the key, and if it is, check if it matches the target string
 * else if we don't have the key, but the character is in the hash set ("badc" and "baba"), which means this target character is already being mapped
 * to somewhere else, so we return false
 * else we map the source string to the target string, and add the target string into our set (not source), see above
 * 
 * Time: O(n)
 * Space: O(1) because the size is fixed in the problem statement (valid ascii characters)
 */