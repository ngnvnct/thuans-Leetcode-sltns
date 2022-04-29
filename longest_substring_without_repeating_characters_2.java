import java.util.HashMap;
import java.util.Map;

public class longest_substring_without_repeating_characters_2 {
    public String longestSubStringWithoutDuplication(String s) {
		Map<Character, Integer> lastSeen = new HashMap<>();
		int left = 0;
		int leftSubstring = 0;
		int rightSubstring = 1;
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			if (lastSeen.containsKey(c)) {
				left = Math.max(left, lastSeen.get(c) + 1);
			}
			if (rightSubstring - leftSubstring < right + 1 - left) {
				leftSubstring = left;
				rightSubstring = right+1;
			}
			lastSeen.put(c, right);
		}
		String res = s.substring(leftSubstring, rightSubstring);
		return res;
    }
}
