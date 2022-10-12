import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Number_Of_Different_Integers_In_A_String_1805 {
    public static void main(String[] args) {
        String exampleOne = "16727895959129";
        String exampleTwo = "a123bc34d8ef34";
        String exampleThree = "leet1234code234";
        String four = "a1b01c001";
        Number_Of_Different_Integers_In_A_String_1805 sol = new Number_Of_Different_Integers_In_A_String_1805();
        System.out.println(sol.numDifferentIntegers2(exampleOne));
        System.out.println(sol.numDifferentIntegers2(exampleTwo));
        System.out.println(sol.numDifferentIntegers2(exampleThree));
        System.out.println(sol.numDifferentIntegers2(four));
    }

    public int numDifferentIntegers(String word) {
        String res = "";
        Set<Long> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                res += word.charAt(i);
            } else {
                if (!res.equals("")) {
                    long number = Long.parseUnsignedLong(res);
                    res = "";
                    set.add(number);
                }
            }
        }

        if (!res.equals("")) {
            set.add(Long.parseUnsignedLong(res));
        }
        return set.size();
    }

    public int numDifferentIntegers2(String word) {
        Set<String> set = new HashSet<>();
        int start = 0;

        while (start < word.length()) {
            if (Character.isDigit(word.charAt(start))) {
                int end = start;

                while (end < word.length() && Character.isDigit(word.charAt(end))) {
                    end++;
                }
                while (start < end && word.charAt(start) == '0') {
                    start++;
                }
                set.add(word.substring(start, end));
                start = end;
            } else {
                start++;
            }
        }
        //System.out.println("set contains " + set);
        return set.size();
    }

    @Test
    public void testInteger() {
        String exampleOne = "16727895959129";
        int exampleOneExpectedResult = 1;
        String exampleTwo = "a123bc34d8ef34";
        int exampleTwoExpectedResult = 3;
        String exampleThree = "leet1234code234";
        int exampleThreeExpectedResult = 2;
        String exampleFour = "a1b01c001";
        int exampleFourExpectedResult = 1;
        
        assertEquals(exampleOneExpectedResult, numDifferentIntegers(exampleOne));
        assertEquals(exampleTwoExpectedResult, numDifferentIntegers(exampleTwo));
        assertEquals(exampleThreeExpectedResult, numDifferentIntegers(exampleThree));
        assertEquals(exampleFourExpectedResult, numDifferentIntegers(exampleFour));

        assertEquals(exampleOneExpectedResult, numDifferentIntegers2(exampleOne));
        assertEquals(exampleTwoExpectedResult, numDifferentIntegers2(exampleTwo));
        assertEquals(exampleThreeExpectedResult, numDifferentIntegers2(exampleThree));
        assertEquals(exampleFourExpectedResult, numDifferentIntegers2(exampleFour));
    }
}

/*
 * https://leetcode.com/problems/number-of-different-integers-in-a-string/
 * Explanation
 * 
 * Two ways to do it, both using the string library.
 * 
 * Method 1: Add the number normally, and use Integer.parseUnsignedInt to remove
 * leading zeroes
 * Method 2: Using two pointers approach, first count all the length of the
 * number (end), and then shrink it everytime i see a leading 0
 * 
 * Need unsignedint because of 167278959591294, so method 2 is prefer
 * Actually, it passes on leetcode, so have to use a long, so method 2 is more
 * prefer
 * 
 * Time: O(n) where n is the length of the string
 * Space: O(n) where n is the size of the number added
 */