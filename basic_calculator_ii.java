import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class basic_calculator_ii {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char operation = '+';
        int currentNum = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNum = (currentNum * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && currentChar != ' ' || i == len - 1) {
                if (operation == '+') {
                    stack.push(currentNum);
                } else if (operation == '-') {
                    stack.push(-currentNum);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNum);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNum);
                }
                operation = currentChar;
                currentNum = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public int calculateOptimal(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int currentNum = 0;
        int lastNum = 0;
        int res = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNum = currentNum * 10 + (currentChar - '0');
            }

            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '+' || operation == '-') {
                    res += lastNum;
                    lastNum = (operation == '+') ? currentNum : -currentNum;
                } else if (operation == '*') {
                    lastNum = lastNum * currentNum;
                } else if (operation == '/') {
                    lastNum = lastNum / currentNum;
                }
                operation = currentChar;
                currentNum = 0;
            }
        }
        res += lastNum;
        return res;
    }

    public int calculateEasy(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int currentNum = 0;
        int lastNum = 0;
        int res = 0;
        int len = s.length();
        char operation = '+';
        for (int i = 0; i< len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNum = (currentNum * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && currentChar != ' ' || i == len-1) {
                if (operation == '+') {
                    res += lastNum;
                    lastNum = currentNum;
                } else if (operation == '-') {
                    res += lastNum;
                    lastNum = -currentNum;
                } else if (operation == '*') {
                    lastNum = lastNum * currentNum;
                } else if (operation == '/') {
                    lastNum = lastNum / currentNum;
                }
                operation = currentChar;
                currentNum = 0;
            }
        }
        res += lastNum;
        return res;
    }

    @Test
    public void testCalculate() {
        assertEquals(7, calculate("3+2*2"));
        assertEquals(7, calculateOptimal("3+2*2"));
        assertEquals(7, calculateEasy("3+2*2"));
        assertEquals(1, calculate("3/2"));
        assertEquals(1, calculateOptimal("3/2"));
        assertEquals(1, calculateEasy("3/2"));
        assertEquals(5, calculate("3+5 / 2"));
        assertEquals(5, calculateOptimal("3+5 / 2"));
        assertEquals(5, calculateEasy("3+5 / 2"));
    }
}

/*
 * Explanation
 * 
 * Using Stack: 4 types of operation (+), (-), (*), (/)
 * without parenthesis, (*) and (/) takes precedence.
 * 
 * If it is 0-9, add it to currentNumber
 * Else, evaluate. (+) and (-) are evaluate later based on the next operation.
 * So we must store the currentNumber to be used later,
 * push it to the stack
 * If we see (-), we push -currentNum
 * 
 * Stack Time: O(n)
 * Stack Space: O(n)
 * 
 * Optimal, instead of pop all the values from the stack and add to the result.
 * We could add the values to the result before hand and keep track of the last
 * calculated number
 * if it is (+) or (-1), add lastNum to the res instead of pushing it to the
 * stack, currentNum would be updated to lastNum for next iteration
 * if it is (*) or (/), we must evaluate lastNum * currentNum and update the
 * lastNum with the result of the expression
 * 
 * 
 * Optimal Time: O(n)
 * Space: O(1)
 */