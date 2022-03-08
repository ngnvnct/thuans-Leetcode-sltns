import java.util.HashMap;
import java.util.Map;

public class to_lower_case {
    public String toLowerCase(String s) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < upper.length(); i++) {
            map.put(upper.charAt(i), lower.charAt(i));
        }
        String res = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                res += map.get(s.charAt(i));
                sb.append(map.get(s.charAt(i)));
            } else {
                res += s.charAt(i);
                sb.append(s.charAt(i));
            }
        }
        return res;
        //return sb.toString();
    }

    public String toLowerCase2(String s) {
        String res = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                res += (char) (s.charAt(i) - 'A' + 'a');
                sb.append((char) (s.charAt(i) - 'A' + 'a'));
            } else {
                res += s.charAt(i);
                sb.append(s.charAt(i));
            }
        }
        return res;
        //return sb.toString();
    }
}

/*
Explanation
Method 1 is simple, make a hash of upper case key and lower case, then iterate through the string
Method 2, using ASCII code method, A to Z is 65 to 90, a to z is 97 to 122. Between 'A' and 'a' is 32 integer apart

if we take a upper case ('H' - 'A' + 'a'), you will get the lower case of h, 72-65 = 7 + 97 = 104 = 'h'

Using sb and res to show it doesn't matter which

Time: O(n)
Space: O(n) to keep the output string
*/