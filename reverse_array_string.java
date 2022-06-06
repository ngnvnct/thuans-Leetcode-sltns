import java.util.Arrays;

public class reverse_array_string {
    public static void main(String[] args) {
        char[] s= {'h', 'e', 'l', 'l','o'};
        reverse_array_string sol = new reverse_array_string();
        sol.reverseString(s);
        System.out.println(Arrays.toString(s));
        sol.reverseStringRecursion((s));
        System.out.println(Arrays.toString(s));

        s = new char[] {'H','a','n','n','a','h'};
        sol.reverseString(s);
        System.out.println(Arrays.toString(s));
        sol.reverseStringRecursion(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }

    public void reverseStringRecursion(char[] s) {
        helper(0, s.length-1, s);
    }

    public void helper(int start, int end, char[] s) {
        if (start >= end) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        helper(start+1, end-1, s);
    }
}


/*
https://leetcode.com/problems/reverse-string/
Two pointer approach, keep the left index and the right index, loop to the half way point and swap the element

Time: O(n)
Space: O(1)

Recursion with Two Pointers
Base Case: if start is greater than or equal to end, do nothing
else swap character at start index and character at end index, and call the helper function at start+1 and end-1

TIme: O(n)
Space: O(n) to keep the recursion stack
*/
