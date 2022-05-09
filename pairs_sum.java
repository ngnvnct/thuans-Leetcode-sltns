import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class pairs_sum {

    public boolean pairSum(String input) {
        int digits = 0;
        int sum = 0;
        int countQuestionMarks = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '?') {
                countQuestionMarks++;
            } else if (Character.isDigit(c) && countQuestionMarks != 3) {
                digits = c -'0';
                countQuestionMarks = 0;
            } else if (Character.isDigit(c) && countQuestionMarks == 3) {
                sum = digits + (c-'0');
                if (sum != 10) {
                    return false;
                }
                digits = (c-'0');
                countQuestionMarks = 0;
            } else {
                countQuestionMarks = 0;
            }
        }
        return sum == 10;
    }

    @Test
    public void testPairsSum() {
        String one = "asfafsasf5???5sdgsdgsg4???6";
        String two = "9???1???9???1";
        String three = "adsasdg4????6";
        String four = "4?b??6";
        String five = "4???6b";
        assertEquals(true, pairSum(one));
        assertEquals(true, pairSum(two));
        assertEquals(false, pairSum(three));
        assertEquals(false, pairSum(four));
        assertEquals(false, pairSum(""));
        assertEquals(true, pairSum(five));
    }
}

/*
Explanation
The brute force way would be storing the sum and then do another pass to check if that pairs of sum add up to 10

But you can just have a condition to check if the current sum adds up to 10, return false if they are not
at the end return sum == 10 instead of return true, because to get pass the edge case of empty string

We have to reset countQuestionMarks if we don't encounter 3 in a row (example four)

Time: O(n)
Space: O(1)
*/