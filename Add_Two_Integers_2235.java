public class Add_Two_Integers_2235 {
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public int sumBit(int num1, int num2) {
        while (num2 != 0) {
            int carry = (num1 & num2) << 1;
            num1 ^= num2;
            num2 = carry;
        }
        return num1;
    }
}

/*
 * https://leetcode.com/problems/add-two-integers/
 * Explanation
 * 
 * First method is trivial
 * Second method is learning about bit manipulation, which I think is the point of the problem
 * num1 ^ num2 is the sum of two numbers but without the carry
 * num1 & num2 carry over bit, and we need to shift it left one time to put it in the right position
 * 
 * Time: O(1)
 * Space: O(1) 
 */