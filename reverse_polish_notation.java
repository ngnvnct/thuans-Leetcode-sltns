import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class reverse_polish_notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num1,num2;
        for (String token : tokens) {
            switch(token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2-num1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.peek();
    }

    public int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num1,num2;
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2-num1);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    @Test
    public void testRPN() {
        String[] exampleOne = {"2","1","+","3","*"};
        String[] exampleTwo = {"4","13","5","/","+"};
        String[] exampleThree = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        assertEquals(9, evalRPN(exampleOne));
        assertEquals(6, evalRPN(exampleTwo));
        assertEquals(22, evalRPN(exampleThree));
        assertEquals(9, evalRPN2(exampleOne));
        assertEquals(6, evalRPN2(exampleTwo));
        assertEquals(22, evalRPN2(exampleThree));
    }
}


/*
Explanation

Since the RPN is valid, we keep a stack and our loop will have 5 cases. 4 operators, and the last case we push our number into the stack
{"2","1","+","3","*"};
Stack [2,1]
We see a "+", we pop 2 numbers out, get the result and push it back onto the stack
Stack [3, 3]
We see a "*", we pop 2 numbers out and get the result and push it back onto the stack

Since after the loop our stack will only have 1 variable, we can return stack.peek()
If you're using Java, note that the input type is an array of strings, not an array of chars. This means that you should be comparing them with .equals(...), not ==.


Time: O(n)
Space: O(n)
*/