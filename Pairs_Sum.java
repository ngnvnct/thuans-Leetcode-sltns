import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Pairs_Sum {
    public boolean pairSum(String input) {
        int digits = 0;
        int sum = 0;
        int countQuestionMarks = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '?') {
                countQuestionMarks++;
            } else if (Character.isDigit(c) && countQuestionMarks != 3) {
                digits = c - '0';
                countQuestionMarks = 0;
            } else if (Character.isDigit(c) && countQuestionMarks == 3) {
                sum = digits + (c - '0');
                if (sum != 10) {
                    return false;
                }
                digits = (c - '0');
                countQuestionMarks = 0;
            } else {
                countQuestionMarks = 0;
            }
        }
        return sum == 10;
    }

    @Test
    public void testPairsSum() {
        assertTrue(pairSum("asfafsasf5???5sdgsdgsg4???6"));
        assertTrue(pairSum("9???1???9???1"));
        assertFalse(pairSum("adsasdg4????6"));
        assertFalse(pairSum("4?b??6"));
        assertFalse(pairSum(""));
        assertTrue(pairSum("4???6b"));
    }
}

/*
 * Explanation
 * The brute force way would be storing the sum and then do another pass to
 * check if that pairs of sum add up to 10
 * 
 * But you can just have a condition to check if the current sum adds up to 10,
 * return false if they are not
 * at the end return sum == 10 instead of return true, because to get pass the
 * edge case of empty string
 * 
 * We have to reset countQuestionMarks if we don't encounter 3 in a row (example
 * four)
 * 
 * Time: O(n)
 * Space: O(1)
 */