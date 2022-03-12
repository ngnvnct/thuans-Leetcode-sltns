import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class three_consecutive_odds {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length-2; i++) {
            if (arr[i] % 2 != 0 && arr[i+1] % 2 != 0 && arr[i+2] % 2 != 0) {
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
        int[] one = {2,6,4,1};
        int[] two = {1,2,34,3,4,5,7,23,21};
        assertEquals(false, threeConsecutiveOdds2(one));
        assertEquals(false, threeConsecutiveOdds(one));
        assertEquals(true, threeConsecutiveOdds2(two));
        assertEquals(true, threeConsecutiveOdds(two));
    }
}

/*
Explanation

It is as simple as it gets, update count if it is odd otherwise reset the count.

Time: O(n)
Space: O(1)
*/