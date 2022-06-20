import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Meeting_Rooms_II_253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int requireRoom = 0;
        for (int i = 0, j = 0; i < intervals.length; i++) {
            if (startTime[i] >= endTime[j]) {
                j++;
            } else {
                requireRoom += 1;
            }
        }
        return requireRoom;
    }

    public int minMeetingRooms2(int[][] intervals) {
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];
        if (intervals.length == 0) {
            return 0;
        }
        for (int i = 0; i < intervals.length; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int requireRoom = 0;
        int start = 0;
        int end = 0;
        int count = 0;
        while (start < intervals.length) {
            if (startTime[start] < endTime[end]) {
                start += 1;
                count += 1;
            } else {
                end += 1;
                count -= 1;
            }
            requireRoom = Math.max(requireRoom, count);
        }
        return requireRoom;
    }

    public int minMeetingRoomMinHeap(int[][] intervals) {
        // Todo
        return 0;
    }

    @Test
    public void testMeetingRoom() {
        int[][] exampleOne = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        int[][] exampleTwo = { { 7, 10 }, { 2, 4 } };
        assertEquals(2, minMeetingRooms(exampleOne));
        assertEquals(2, minMeetingRooms2(exampleOne));
        assertEquals(1, minMeetingRooms(exampleTwo));
        assertEquals(1, minMeetingRooms2(exampleTwo));
    }
}

/*
 * https://leetcode.com/problems/meeting-rooms-ii/
 * Explanation
 * 
 * NeetCode way
 * Put start time in a separate array, sort it
 * Put end time in a sepearate array, sort it
 * Maintain count
 * 
 * start = [0,5,10]
 * end = [10,15,30]
 * Always pick the minimum value, if the minimum between this two is the start
 * time, increment count
 * 0 < 10, count + 1
 * 5 < 10, count + 1
 * Edge case, meeting is ending at 10, and starting at 10. We visit ending
 * first, if we iterate over ending, it means an ending has end, decrement count
 * 
 * the algorithm is doing is checking how many meetings begin before the
 * earliest-ended meeting ends.
 * If, for instance, 3 meetings have started before the earliest possible
 * meeting end, than we need 3 rooms.
 * Sorting the arrays helps in two things: first of all you can easily get the
 * earliest meetings end time,
 * and secondly, it allows you to start looking for meetings ends only from next
 * element in the ends array when you find some meeting start that is after the
 * current end,
 * because all other meeting ends before the current in the sorted array will
 * also be before the current meeting start
 * 
 * Time: O(nlogn)
 * Space: O(1)
 */