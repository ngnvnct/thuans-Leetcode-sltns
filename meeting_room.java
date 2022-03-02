import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class meeting_room {
    public boolean canAttend(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            int endTime = intervals[i-1][1];
            int startTime = intervals[i][0];
            if (endTime > startTime) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testMeetingRoom() {
        int[][] exampleOne = {{0,30},{5,10},{15,20}};
        int[][] exampleTwo = {{7,10}, {2,4}};
        int[][] exampleThree = {{5,8}, {6,8}};
        
        assertEquals(false,canAttend(exampleOne));
        assertEquals(true, canAttend(exampleTwo));
        assertEquals(false, canAttend(exampleThree));
    }
}


/*abstract
Explanation

Sort based on start time
We look at the first two interval, we compare the end time of the first interval and the start time of the 2nd interval
If the start time is before the end time, it means they are overlap. Overlap = return False


Time: O(nlogn)
Space: O(1)

*/