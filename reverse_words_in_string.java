import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class reverse_words_in_string {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        for (String a : s.trim().split(" ")) {
            //while(!a.isEmpty()) {
            //    stack.push(a);
            //}
            if (!a.isEmpty()) {
                stack.push(a);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        String[] array = s.split(" ");
        for (int i = array.length-1; i >= 0; i--) {
            if (!array[i].isEmpty()) {
                sb.append(array[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0;
        int end = 0;
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            reverse(sb, start, end-1);
            start = end+1;
            ++end;
        }
    }

    @Test(timeout = 100)
    public void testReverse() {
        String one = "the sky is blue";
        String expectedOne = "blue is sky the";
        String two = "    hello   world ";
        String expectedTwo = "world hello";
        String three = "a good     example";
        String expectedThree = "example good a";
        assertEquals(expectedOne,reverseWords(one));
        assertEquals(expectedTwo, reverseWords(two));
        assertEquals(expectedThree, reverseWords(three));
    }
}

/*
Explanation
String is immutable in Java, really hard to solve it in-place with O(1) extra space

Built in trim() method in java removes leading and trailing space
JUnit: Learn timeout, test will failed if it takes too long or if there is an inf loop.

Time: O(n)
Space: O(n)
*/
