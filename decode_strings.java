import java.util.Stack;

public class decode_strings {
    private int position = 0;
    public String decodeString(String s) {
        int n = s.length();
        int repeat = 0;
        StringBuilder sb = new StringBuilder();
        while (position < n) {
            char c = s.charAt(position);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= '0' && c <= '9') {
                repeat = repeat * 10 + (c- '0');
            } else if (c == '[') {
                position++;
                String str = decodeString(s);
                for (int i = 0; i < repeat; i++) {
                    sb.append(str);
                }
                repeat = 0;
            } else if (c == ']') {
                break;
            }
            position++;
        }
        return sb.toString();
    }

    public String decodeStringStack(String s) {
        Stack<Integer> numCount = new Stack<>();
        Stack<String> stack = new Stack<>();
        String res = "";
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index += 1;
                }
                // This is here just in case I forget about Character.isDigit() 
                /*while (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    count = 10 * count + (s.charAt(index) - '0');
                    index += 1;
                }*/
                numCount.push(count);
            } else if (s.charAt(index) == '[') {
                stack.push(res);
                res = "";
                index += 1;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(stack.pop());
                int count = numCount.pop();
                for (int i =0; i < count; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index += 1;
            } else {
                res += s.charAt(index);
                index += 1;
            }
        }
        return res;
    }
}


/*abstract
Explanation

54[ab6[cd]]
Stack 5-4-[-a-b-6-[-c-d. Once we see a ], we pop everything include the [ bracket
In this case we pop cd, and we take the integer right after [, as long as it is 0 to 9 (digits)

Then we push 6[cd] into the stack
Then we get to the 2nd ], we pop everything until we get to [, then we get to the integer
54[a, b,cdcdcdcdcdced]
now multiple 54 by the string inside


Stack Solution
We see 4 cases
a number, a letter or the two brackets. We have two stacks, one to keep track of the number (count), and the other keep track of the string


Recursive DFS Solution
For the string in [] pair, we can recursively as the source string, the codes go into lower level at '[', and back to parent at ']'

Time:  O(n)
Space: O(n)
*/