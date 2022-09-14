import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class First_Unique_Character_In_A_String_387 {
    public int firstUniqCharMap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharQueue(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = queue.poll();
            if (!queue.contains(temp)) {
                return s.indexOf(temp);
            } else {
                queue.offer(temp);
            }
        }
        return -1;
    }

    public int firstUniqCharArray(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void testUniq() {
        String exampleOne = "leetcode";
        int exampleOneExpectedResult = 0;
        String exampleTwo = "loveleetcode";
        int exampleTwoExpectedResult = 2;
        String exampleThree = "aabb";
        int exampleThreeExpectedResult = -1;

        assertEquals(exampleOneExpectedResult, firstUniqCharArray(exampleOne));
        assertEquals(exampleTwoExpectedResult, firstUniqCharArray(exampleTwo));
        assertEquals(exampleThreeExpectedResult, firstUniqCharArray(exampleThree));

        assertEquals(exampleOneExpectedResult, firstUniqCharMap(exampleOne));
        assertEquals(exampleTwoExpectedResult, firstUniqCharMap(exampleTwo));
        assertEquals(exampleThreeExpectedResult, firstUniqCharMap(exampleThree));

        assertEquals(exampleOneExpectedResult, firstUniqCharQueue(exampleOne));
        assertEquals(exampleTwoExpectedResult, firstUniqCharQueue(exampleTwo));
        assertEquals(exampleThreeExpectedResult, firstUniqCharQueue(exampleThree));
    }
}

/*
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * Explanation
 * 
 * Array, keep a bucket of alphabet and increment the frequency, if frequency is
 * one, going from left to right of the string, that is the first unique
 * non-repeating
 * Same thing with Map
 * For queue, offer everything, then do another loop and pop it out, if the
 * queue doesn't contain that character anymore, it's the first unique
 * non-repeating, return the indexOf of it
 * 
 * Time: O(n)
 * Space: O(1)
 */