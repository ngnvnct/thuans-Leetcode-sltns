/*
 * https://leetcode.com/problems/meeting-rooms/
 * Explanation:
 * 
 * Sort based on start time
 * We look at the first two interval, we compare the end time of the first
 * interval and the start time of the 2nd interval
 * If the start time is before the end time, it means they are overlap so we return false
 * 
 * Time: O(nlogn)
 * Space: O(1)
 */

using System;
using NUnit.Framework;

namespace Meeting_Rooms
{
    class Solution
    {
        public static bool CanAttendMeetings(int[][] intervals)
        {
            Array.Sort(intervals, (a, b) => a[0].CompareTo(b[0]));
            for (int i = 1; i < intervals.Length; i++)
            {
                int prevEndTime = intervals[i - 1][1];
                int currStartTime = intervals[i][0];
                if (prevEndTime > currStartTime)
                {
                    return false;
                }
            }
            return true;
        }
    }

    class Tests
    {
        [Test]
        public void TestCanAttendMeetings()
        {
            int[][] testCase1 = new int[][] { new int[] { 0, 30 }, new int[] { 5, 10 }, new int[] { 15, 20 } };
            int[][] testCase2 = new int[][] { new int[] { 7, 10 }, new int[] { 2, 4 } };

            Assert.IsFalse(Solution.CanAttendMeetings(testCase1));
            Assert.IsTrue(Solution.CanAttendMeetings(testCase2));
        }
    }
}
