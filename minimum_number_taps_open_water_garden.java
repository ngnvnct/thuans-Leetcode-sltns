import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class minimum_number_taps_open_water_garden {
    public int minTapsBF(int n, int[] ranges) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+ 2);
        dp[0] = 0;
        for (int i = 0; i <= n; ++i) {
            for (int j = Math.max(i-ranges[i]+1,0); j <= Math.min(i+ranges[i], n); j++) {
                dp[j] = Math.min(dp[j], dp[Math.max(0, i-ranges[i])] + 1);
            }
        }
        return dp[n] < n + 2 ? dp[n] : -1;
    }

    public int minTapsOptimal(int n, int[] ranges) {
        int[] startToEnd = new int[n+1];

        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);

            if (start == 0 && end == n) {
                return 1;
            }

            startToEnd[start] = Math.max(startToEnd[start], end);
        }

        int currentEnd = startToEnd[0];
        int tap = 0;
        int nextEnd = currentEnd;
        int index = 0;
        while (index <= currentEnd) {
            nextEnd = Math.max(nextEnd, startToEnd[index]);
            if (index == currentEnd) {
                currentEnd = nextEnd;
                tap++;
            }
            index++;
        }
        return currentEnd == n ? tap : -1;
    }

    @Test
    public void testGarden() {
        assertEquals(1, minTapsBF(5, new int[] {3,4,1,1,0,0}));
        assertEquals(1, minTapsOptimal(5, new int[] {3,4,1,1,0,0}));
        assertEquals(-1, minTapsBF(3, new int[] {0,0,0,0}));
        assertEquals(-1, minTapsBF(3, new int[] {0,0,0,0}));
    }
}

/*
Explanation

Brute Force

Optimal, first loop set the start and end ranges within the array, and exit early if we 
come across a range that covers all the way from 0 to n (only need 1 tap)

2 things for next part
1. Validate that we can cover the entire garden with taps
2. Provide the min number of taps to provide full coverage.

We start at position 0 in the garden, and moving forward till the end of the max position at the start
and gathering a potential next endpoint (the largest in the current range we are iterating through)
Do it until no more next endpoints to reach, if the final point is n, we return the total number of time we
have change the endpoint. If it does not, then we return -1 because no amount of taps can water the entire garden

Time:O(n)
Space: O(n)
*/
