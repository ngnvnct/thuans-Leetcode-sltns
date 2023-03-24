/*
 * https://leetcode.com/problems/add-two-integers/
 * Explanation:
 * 
 * First method is trivial
 * Second method about bit manipulation
 * 
 * num1 ^ num2 is the sum of two numbers but without the carry
 * num1 & num2 carry over bit, and we need to shift it left one time to put it
 * in the right position
 * 
 * Time: O(1)
 * Space: O(1)
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class problem_2235_add_two_integers {
    public int sum(int num1, int num2) {
        while (num2 != 0) {
            int carry = (num1 & num2) << 1;
            num1 ^= num2;
            num2 = carry;
        }
        return num1;
    }

    @Test
    public void testSum() {
        int testCase1FirstNum = 12;
        int testCase1SecondNum = 5;
        int testCase1ExpectedResult = 17;
        int testCase2FirstNum = -10;
        int testCase2SecondNum = 4;
        int testCase2ExpectedResult = -6;

        assertEquals(testCase1ExpectedResult, sum(testCase1FirstNum, testCase1SecondNum));
        assertEquals(testCase2ExpectedResult, sum(testCase2FirstNum, testCase2SecondNum));
    }
}