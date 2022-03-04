import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class minimum_time_difference {
    public int findMinDifferent(List<String> timePoints) {
        // 24 hours time 60 minutes
        // "01:01" = 1 * 60 = 60 + 1 = 61 position
        boolean[] timeSeen = new boolean[24 * 60];

        for (String time : timePoints) {
            String[] timeSplit = time.split(":");
            int hour = Integer.parseInt(timeSplit[0]);
            int minute = Integer.parseInt(timeSplit[1]);
            if (timeSeen[(hour * 60) + minute]) {
                return 0;
            }
            timeSeen[(hour * 60) + minute] = true;
        }

        int min = Integer.MAX_VALUE, firstTimeSeen = -1, prevTimeSeen = -1, currTime = -1;
        for (int i = 0; i < timeSeen.length; i++) {
            if (timeSeen[i]) {
                if (prevTimeSeen == -1) {
                    prevTimeSeen = i;
                    firstTimeSeen = i;
                } else {
                    currTime = i;
                    min = Math.min(min, currTime - prevTimeSeen);
                    prevTimeSeen = currTime;
                }
            }
        }
        min = Math.min(min, 1440 - currTime + firstTimeSeen);
        return min;
    }

    @Test
    public void testMinDifference() {
        List<String> exampleOne = new ArrayList<>(Arrays.asList("23:59","00:00"));
        List<String> exampleTwo = new ArrayList<>(Arrays.asList("00:00","23:59","00:00"));
        assertEquals(1, findMinDifferent(exampleOne));
        assertEquals(0, findMinDifferent(exampleTwo));
    }
}

/*
 * Explanation
 * 
 * We make a bucket of size 24 (hours) * 60 minutes = 1440, and we mark it as
 * true if we already seen it
 * if we already seen that time, return 0
 * 
 * We gonna loop through this timeSeen, and set firstTimeSeen once and leave it
 * till the end
 * At the end prevTimeSeen will be the last time, and we compare it with the
 * firstTimeSeen
 * 
 * Now we update prevTimeSeen, i-prevTimeSeen is the CCW
 * Then we have to check the last timeSeen with the first time seen (the difference between 1440 and first element)
 * ["23:59","00:00"], curr is at 1439, and first is at 0, 1440-curr+first is Clockwise
 * 
 * Edge case like [00:01, 10:00, 23:59] and [00:00, 10:00, 23:00]
 * 
 * Time: O(n)
 * Space: O(1440)
 */