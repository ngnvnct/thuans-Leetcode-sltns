import java.util.ArrayDeque;
import java.util.Deque;

public class backspace_string_compare {
    public boolean backspaceCompare(String s, String t) {
        String newS = "";
        String newT = "";
        Deque<Character> stackS = new ArrayDeque<>();
        Deque<Character> stackT = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!stackS.isEmpty()) {
                    stackS.removeFirst();
                }
            } else {
                stackS.addFirst(c);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!stackT.isEmpty()) {
                    stackT.removeFirst();
                }
            } else {
                stackT.addFirst(c);  
            }
        }
        if (stackS.size() != stackT.size())
        {
            return false;
        }
        while (!stackS.isEmpty())
        {
            // If the top elements of both stacks
            // are same
            if (stackS.peek() == stackT.peek())
            {
                // Pop top of both stacks
                stackS.pop();
                stackT.pop();
            }
            else
            {
                return false;
            }
        }
        return true;
//         while (!stackS.isEmpty()) {
//             newS += stackS.removeLast();
//         }
//         while (!stackT.isEmpty()) {
//             newT += stackT.removeLast();
//         }
        
//         return newS.equals(newT);
        
    }
}
