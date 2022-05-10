import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class baseball_game {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            
            if (s.equals("C") && !stack.isEmpty()) {
                stack.removeFirst();
            } else if (s.equals("D") && !stack.isEmpty()) {
                stack.addFirst(2 * stack.peekFirst());
            } else if (s.equals("+") && stack.size() >= 2) {
                int num1 = stack.removeFirst();
                int sum = num1 + stack.peekFirst();
                stack.addFirst(num1);
                stack.addFirst(sum);
            } else {
                stack.addFirst(Integer.parseInt(s));
            }
        }
        int count = 0;
        for (int i : stack) {
            count += i;
        }
        return count;
    }
    
    public int calPointOnePass(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        int totalSum = 0;
        
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            
            if (s.equals("C") && !stack.isEmpty()) {
                totalSum -= stack.peekFirst();
                stack.removeFirst();
            } else if (s.equals("D") && !stack.isEmpty()) {
                stack.addFirst(2 * stack.peekFirst());
                totalSum += stack.peekFirst();
            } else if (s.equals("+") && stack.size() >= 2) {
                int num1 = stack.removeFirst();
                int sum = num1 + stack.peekFirst();
                stack.addFirst(num1);
                stack.addFirst(sum);
                totalSum += stack.peekFirst();
            } else {
                stack.addFirst(Integer.parseInt(s));
                totalSum += stack.peekFirst();
            }
        }
        return totalSum;
    }

    @Test
    public void testPoint() {
        String[] one = {"5","2","C","D","+"};
        String[] two = {"5","-2","4","C","D","9","+","+"};

        assertEquals(30, calPoints(one));
        assertEquals(30, calPointOnePass(one));
        assertEquals(27, calPoints(two));
        assertEquals(27, calPointOnePass(two));
    }
}


/*abstract
Explanation

Constraints
1 <= ops.length <= 1000
ops[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
For operation "+", there will always be at least two previous scores on the record.
For operations "C" and "D", there will always be at least one previous score on the record.

Challenge: Code it so that I am not bounded by the constraint ("C" when there are no score on the record)

For Java: Using Stack shows that you're not as familiar with language as the interviewer probably wants you to be.
Stack is a rather old collection that extends Vector, has performance issues due to each method in it being synchronized, 
and violates some best practices around interfaces, so it is considered legacy nowadays.

https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
Use Deque instead https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html

*/