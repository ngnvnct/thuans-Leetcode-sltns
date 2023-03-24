import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class Number_Of_Different_Integers_In_A_String_1805 {
    public static void main(String[] args) {
        String testCase1 = "16727895959129";
        String testCase2 = "a123bc34d8ef34";
        String testCase3 = "leet1234code234";
        String four = "a1b01c001";
        Number_Of_Different_Integers_In_A_String_1805 sol = new Number_Of_Different_Integers_In_A_String_1805();
        System.out.println(sol.numDifferentIntegers2(testCase1));
        System.out.println(sol.numDifferentIntegers2(testCase2));
        System.out.println(sol.numDifferentIntegers2(testCase3));
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
        String testCase1 = "16727895959129";
        int testCase1ExpectedResult = 1;
        String testCase2 = "a123bc34d8ef34";
        int testCase2ExpectedResult = 3;
        String testCase3 = "leet1234code234";
        int testCase3ExpectedResult = 2;
        String testCase4 = "a1b01c001";
        int testCase4ExpectedResult = 1;
        
        assertEquals(testCase1ExpectedResult, numDifferentIntegers(testCase1));
        assertEquals(testCase2ExpectedResult, numDifferentIntegers(testCase2));
        assertEquals(testCase3ExpectedResult, numDifferentIntegers(testCase3));
        assertEquals(testCase4ExpectedResult, numDifferentIntegers(testCase4));

        assertEquals(testCase1ExpectedResult, numDifferentIntegers2(testCase1));
        assertEquals(testCase2ExpectedResult, numDifferentIntegers2(testCase2));
        assertEquals(testCase3ExpectedResult, numDifferentIntegers2(testCase3));
        assertEquals(testCase4ExpectedResult, numDifferentIntegers2(testCase4));
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