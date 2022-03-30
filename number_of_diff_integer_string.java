import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class number_of_diff_integer_string {

    public static void main(String[] args) {
        String one = "16727895959129";
        String two = "a123bc34d8ef34";
        String three = "leet1234code234";
        String four = "a1b01c001";
        number_of_diff_integer_string sol = new number_of_diff_integer_string();
        System.out.println(sol.numDifferentIntegers2(one));
        System.out.println(sol.numDifferentIntegers2(two));
        System.out.println(sol.numDifferentIntegers2(three));
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
        System.out.println("set contains " + set);
        return set.size();
    }

    @Test
    public void testInteger() {
        String one = "16727895959129";
        String two = "a123bc34d8ef34";
        String three = "leet1234code234";
        String four = "a1b01c001";
        assertEquals(1, numDifferentIntegers(one));
        assertEquals(1, numDifferentIntegers2(one));
        assertEquals(3, numDifferentIntegers(two));
        assertEquals(3, numDifferentIntegers2(two));
        assertEquals(2, numDifferentIntegers(three));
        assertEquals(2, numDifferentIntegers2(three));
        assertEquals(1, numDifferentIntegers(four));
        assertEquals(1, numDifferentIntegers2(four));
    }
}

/*abstract
Explanation

Two ways to do it, both using the string library. 

Method 1: Add the number normally, and use Integer.parseUnsignedInt to remove leading zeroes
Method 2: Using two pointers approach, first count all the length of the number (end), and then shrink it everytime i see a leading 0

Need unsignedint because of 167278959591294, so method 2 is prefer
Actually, it passes on leetcode, so have to use a long, so method 2 is more prefer

Time: O(n) where n is the length of the string
Space: O(n) where n is the size of the number added
*/