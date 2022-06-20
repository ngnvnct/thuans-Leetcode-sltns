import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class Meeting_Rooms_252 {
    public boolean canAttend(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            int endTime = intervals[i - 1][1];
            int startTime = intervals[i][0];
            if (endTime > startTime) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testMeetingRoom() {
        int[][] exampleOne = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        int[][] exampleTwo = { { 7, 10 }, { 2, 4 } };
        int[][] exampleThree = { { 5, 8 }, { 6, 8 } };

        assertFalse(canAttend(exampleOne));
        assertTrue(canAttend(exampleTwo));
        assertFalse(canAttend(exampleThree));
    }
}

/*
 * https://leetcode.com/problems/meeting-rooms/
 * Explanation
 * 
 * Sort based on start time
 * We look at the first two interval, we compare the end time of the first
 * interval and the start time of the 2nd interval
 * If the start time is before the end time, it means they are overlap. Overlap
 * = return False
 * 
 * 
 * Time: O(nlogn)
 * Space: O(1)
 * 
 */