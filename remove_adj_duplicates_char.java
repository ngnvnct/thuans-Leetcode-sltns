import java.util.ArrayDeque;
import java.util.Deque;

public class remove_adj_duplicates_char {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peekLast() == s.charAt(i)) {
                stack.removeLast();
            } else {
                stack.addLast(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}
