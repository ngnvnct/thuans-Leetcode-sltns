import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            count = Math.max(count, right-left+1);
            //count = Math.max(count, set.size());
        }
        return count;
    }

    @Test
    public void testLongestSubstring() {
        String exampleOne = "abcabcbb";
        String exampleTwo = "bbbbb";
        String exampleThree = "pwwkew";
        assertEquals(3, lengthOfLongestSubstring(exampleOne));
        assertEquals(1, lengthOfLongestSubstring(exampleTwo));
        assertEquals(3, lengthOfLongestSubstring(exampleThree));
    }
}

/*abstract
Explanation
Sliding Window technique. "abcabcbb", we start at "a", then go to b and c, on the next a we know that it is in the set, we remove the left most character then move the window to the right, then add a new "a" in
Then we update the max result

The reason we want to use a while loop is something like this "qrsvbspk"

qrsvb is the longest substring without repeating character, we have to keep looping until remove "s" from our set, so the new substring will be "vbs", and then "vbspk"

Time: O(n)
Space: O(n)
*/