import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class Evaluate_Reverse_Polish_Notation_150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num1, num2;

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.addLast(stack.removeLast() + stack.removeLast());
                    break;
                case "-":
                    num1 = stack.removeLast();
                    num2 = stack.removeLast();
                    stack.addLast(num2 - num1);
                    break;
                case "*":
                    stack.addLast(stack.removeLast() * stack.removeLast());
                    break;
                case "/":
                    num1 = stack.removeLast();
                    num2 = stack.removeLast();
                    stack.addLast(num2 / num1);
                    break;
                default:
                    stack.addLast(Integer.parseInt(token));
                    break;
            }
        }
        return stack.peekLast();
    }

    public int evalRPNMethodTwo(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num1, num2;
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.addLast(stack.removeLast() + stack.removeLast());
            } else if (token.equals("-")) {
                num1 = stack.removeLast();
                num2 = stack.removeLast();
                stack.addLast(num2 - num1);
            } else if (token.equals("*")) {
                stack.addLast(stack.removeLast() * stack.removeLast());
            } else if (token.equals("/")) {
                num1 = stack.removeLast();
                num2 = stack.removeLast();
                stack.addLast(num2 / num1);
            } else {
                stack.addLast(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    public int evalRPNMethodThree(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();        
        for (String token : tokens) {
            
            if (!"+-*/".contains(token)) {
                stack.addLast(Integer.valueOf(token));
                continue;
            }
            
            int number2 = stack.removeLast();
            int number1 = stack.removeLast();
            int res = 0;
            
            switch (token) {
                case "+":
                    res = number1 + number2;
                    break;
                case "-":
                    res = number1 - number2;
                    break;
                case "*":
                    res = number1 * number2;
                    break;
                case "/":
                    res = number1 / number2;
                    break;
            }
            stack.addLast(res);
            
        }
        return stack.peekLast();
    }

    @Test
    public void testRPN() {
        String[] testCase1 = { "2", "1", "+", "3", "*" };
        int testCase1ExpectedResult = 9;
        String[] testCase2 = { "4", "13", "5", "/", "+" };
        int testCase2ExpectedResult = 6;
        String[] testCase3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        int testCase3ExpectedResult = 22;

        assertEquals(testCase1ExpectedResult, evalRPN(testCase1));
        assertEquals(testCase2ExpectedResult, evalRPN(testCase2));
        assertEquals(testCase3ExpectedResult, evalRPN(testCase3));

        assertEquals(testCase1ExpectedResult, evalRPNMethodTwo(testCase1));
        assertEquals(testCase2ExpectedResult, evalRPNMethodTwo(testCase2));
        assertEquals(testCase3ExpectedResult, evalRPNMethodTwo(testCase3));

        assertEquals(testCase1ExpectedResult, evalRPNMethodThree(testCase1));
        assertEquals(testCase2ExpectedResult, evalRPNMethodThree(testCase2));
        assertEquals(testCase3ExpectedResult, evalRPNMethodThree(testCase3));
    }
}

/*
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Explanation
 * 
 * Since the RPN is valid, we keep a stack and our loop will have 5 cases. 4
 * operators, and the last case we push our number into the stack
 * {"2","1","+","3","*"};
 * Stack [2,1]
 * We see a "+", we pop 2 numbers out, get the result and push it back onto the
 * stack
 * Stack [3, 3]
 * We see a "*", we pop 2 numbers out and get the result and push it back onto
 * the stack
 * 
 * Since after the loop our stack will only have 1 variable, we can return
 * stack.peek()
 * If you're using Java, note that the input type is an array of strings, not an
 * array of chars. This means that you should be comparing them with
 * .equals(...), not ==.
 * 
 * Time: O(n)
 * Space: O(n)
 */