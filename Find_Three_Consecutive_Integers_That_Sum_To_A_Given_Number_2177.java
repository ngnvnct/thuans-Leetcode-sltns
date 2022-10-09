import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Find_Three_Consecutive_Integers_That_Sum_To_A_Given_Number_2177 {
    public long[] sumOfThree(long num) {
        long x1 = num / 3;
        long x2 = x1 - 1;
        long x3 = x1 + 1;
        long sum = x1 + x2 + x3;
        if (sum == num) {
            return new long[] { x2, x1, x3 };
        }
        return new long[] {};
    }

    public long[] sumOfThree2(long num) {
        if (num % 3 != 0) {
            return new long[0];
        }
        return new long[] { (num / 3) - 1, num / 3, (num / 3) + 1 };
    }

    @Test
    public void testSumOfThree() {
        long exampleOne = 33;
        long[] exampleOneExpectedResult = { 10, 11, 12 };
        long exampleTwo = 4;
        long[] exampleTwoExpectedResult = {};

        assertArrayEquals(exampleOneExpectedResult, sumOfThree(exampleOne));
        assertArrayEquals(exampleTwoExpectedResult, sumOfThree(exampleTwo));

        assertArrayEquals(exampleOneExpectedResult, sumOfThree2(exampleOne));
        assertArrayEquals(exampleTwoExpectedResult, sumOfThree2(exampleTwo));
    }
}

/*
 * https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/
 * Explanation
 * 
 * Brute Force is brute force, just do it as it ask.
 * 
 * Math:
 * 
 * (x-1) + (x) + (x+1) = n
 * 3x = n
 * x = n/3
 * We can say that
 * If a number is divisible by 3, only an answer exist
 * If a number is divisble by 3, then it's answer array would have three
 * elements
 * i. num/3
 * ii. num/3 + 1
 * iii. num/3 -1
 * 
 * num = 2, no triplet is possible
 * num = 3, [0,1,2]
 * num = 4, no triplet is possible
 * num = 6, [1,2,3]
 * num = 9, [2,3,4]
 * 
 * So we can do a mod 3 and see if it is not equal to 0, if that is true we get
 * an empty array, else we get our answer
 * 
 * Time: O(1)
 * Space: O(1)
 */