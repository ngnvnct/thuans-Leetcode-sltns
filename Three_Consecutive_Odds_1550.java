import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Three_Consecutive_Odds_1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean threeConsecutiveOdds2(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                count += 1;
            } else {
                count = 0;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testThreeOdd() {
        int[] testCase1 = { 2, 6, 4, 1 };
        int[] testCase2 = { 1, 2, 34, 3, 4, 5, 7, 23, 21 };

        assertFalse(threeConsecutiveOdds(testCase1));
        assertTrue(threeConsecutiveOdds(testCase2));

        assertFalse(threeConsecutiveOdds2(testCase1));
        assertTrue(threeConsecutiveOdds2(testCase2));
    }
}

/*
 * https://leetcode.com/problems/three-consecutive-odds/
 * Explanation
 * 
 * It is as simple as it gets, update count if it is odd otherwise reset the
 * count.
 * 
 * Time: O(n)
 * Space: O(1)
 */