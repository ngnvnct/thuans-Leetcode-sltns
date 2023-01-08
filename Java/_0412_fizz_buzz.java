package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class _0412_fizz_buzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    @Test
    public void testFizzBuzz() {
        int testCase1 = 3;
        List<String> testCase1ExpectedResult = new ArrayList<>(Arrays.asList("1", "2", "Fizz"));
        int testCase2 = 5;
        List<String> testCase2ExpectedResult = new ArrayList<>(Arrays.asList("1", "2", "Fizz", "4", "Buzz"));
        int testCase3 = 15;
        List<String> testCase3ExpectedResult = new ArrayList<>(Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz","11", "Fizz", "13", "14", "FizzBuzz"));

        assertEquals(testCase1ExpectedResult, fizzBuzz(testCase1));
        assertEquals(testCase2ExpectedResult, fizzBuzz(testCase2));
        assertEquals(testCase3ExpectedResult, fizzBuzz(testCase3));
    }
}

/*
 * https://leetcode.com/problems/fizz-buzz/
 * Explantion:
 * Use modulus % to return the remainder of two number after division
 * 
 * Time: O(n), n is input
 * Space: O(n), storing the result
 */