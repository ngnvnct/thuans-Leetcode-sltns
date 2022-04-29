import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ascending_numbers_in_sentence {
    public static void main(String[] args) {
        String example1 = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        String example2 = "hello world 5 x 5";
        String example3 = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        ascending_numbers_in_sentence sol = new ascending_numbers_in_sentence();
        System.out.println(sol.areNumbersAscending(example1));
        System.out.println(sol.areNumbersAscending(example2));
        System.out.println(sol.areNumbersAscending(example3));
    }

    public boolean areNumbersAscending(String s) {
        int i = 0;
        int num = 0;
        int prev = 0;

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }
                if (num <= prev) {
                    return false;
                }
                prev = num;

            } else {
                i++;
            }
        }
        return true;
    }

    public boolean areNumbersAscending2(String s) {
        int num = 0;
        int prev = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = 0;
                while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }
                if (num <= prev) {
                    return false;
                }
                prev = num;
            } else {
                i++;
            }
        }
        return true;
    }

    @Test
    public void testAscending() {
        String example1 = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        String example2 = "hello world 5 x 5";
        String example3 = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        assertEquals(true, areNumbersAscending(example1));
        assertEquals(false, areNumbersAscending(example2));
        assertEquals(false, areNumbersAscending(example3));
        assertEquals(true, areNumbersAscending2(example1));
        assertEquals(false, areNumbersAscending2(example2));
        assertEquals(false, areNumbersAscending2(example3));
    }
}

/*
Explanation
Multiple ways to do it, tokenization or just loop through the string normally, and get the num using our favorite formular
num = num * 10 + (currentChar - '0');

then check with the previous, if it is smaller or equal to previousNum, return false, else make previousNum becomes currentNum
return true when the loop terminate

Time: O(n)
Space: O(1) not counting input string
*/