import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fizz_Buzz_412 {
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
        assertEquals(new ArrayList<>(Arrays.asList("1", "2", "Fizz")), fizzBuzz(3));
        assertEquals(new ArrayList<>(Arrays.asList("1", "2", "Fizz", "4", "Buzz")), fizzBuzz(5));
        assertEquals(new ArrayList<>(Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz","11", "Fizz", "13", "14", "FizzBuzz")), fizzBuzz(15));
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