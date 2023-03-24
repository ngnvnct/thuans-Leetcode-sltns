import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class Pair {
    char c;
    int count;
    public Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }

    public char getKey() {
        return this.c;
    }
    public int getValue() {
        return this.count;
    }
}

public class remove_adj_duplicates_char_ii {
    public static void main(String[] args) {
        remove_adj_duplicates_char_ii sol = new remove_adj_duplicates_char_ii();
        System.out.println(sol.removeDuplicates("abcd", 2));
        System.out.println(sol.removeDuplicates("deeedbbcccbdaa",3));
        System.out.println(sol.removeDuplicates("pbbcggttciiippooaais",2));
    }

    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peekLast().getKey() == s.charAt(i)) {
                Pair last = stack.removeLast();
                int count = last.getValue();
                count++;
                stack.addLast(new Pair(s.charAt(i), count));
            } else {
                stack.addLast(new Pair(s.charAt(i), 1));
            }
            if (stack.peekLast().getValue() == k) {
                stack.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Pair pair : stack) {
            int count = pair.getValue();
            String str = String.valueOf(pair.getKey());
            for (int i = 0; i < count; i++) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public String removeDuplicates2(String s, int k) {
        Deque<Pair> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peekLast().getKey() == s.charAt(i)) {
                Pair last = stack.removeLast();
                int count = last.count;
                count++;
                stack.addLast(new Pair(s.charAt(i), count));
            } else {
                stack.addLast(new Pair(s.charAt(i), 1));
            }
            if (stack.peekLast().count == k) {
                stack.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Pair pair : stack) {
            int count = pair.count;
            String str = String.valueOf(pair.c);
            sb.append(str.repeat(count));
        }
        return sb.toString();
    }

    @Test
    public void testDuplicate() {
        assertEquals("abcd", removeDuplicates("abcd", 2));
        assertEquals("aa", removeDuplicates("deeedbbcccbdaa", 3));
        assertEquals("ps", removeDuplicates("pbbcggttciiippooaais", 2));
        assertEquals("abcd", removeDuplicates2("abcd", 2));
        assertEquals("aa", removeDuplicates2("deeedbbcccbdaa", 3));
        assertEquals("ps", removeDuplicates2("pbbcggttciiippooaais", 2));
    }
}

/*
Explanation

Starting at Java 11, javafx does not get package with Java SDK. That means it is hard to do call the Pair<Key, Value> Object
However, you can quickly create one using the example above and it will do the same thing

Key Take Away, Learning about Class Pair and how to apply it to this Pattern.
Make a class Pair (or import from javafx if allowed), create A Pair of Key Value with Character, Number of Occurence

Algorithm:
If the stack is not empty, and the current char is equal to the stack peek last, pop out the current element, add 1 to the count and push it back in.
You can't easily update it like in Python
Then build the string within the stack using StringBuilder. Also Later java version there is a String library method called repeat which does the same thing as the count for-loop

The 2nd method is just another approach if we don't want to create a getter

Note: Because we used a Deque, we don't need to reverse the string at the end, the string is already in the right location

Time: O(n)
Space: O(n)
*/