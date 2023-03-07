/*
 * https://leetcode.com/problems/container-with-most-water/
 * Explanation:
 * 
 * Using two pointers approach. We take the length of the right and left
 * pointer, and multiply it by the minimum value of the height at left and the
 * height at right, since the minimum value determines how much water we can hold.
 * 
 * If the height at left is smaller than
 * right, we move the left for a potential bigger height. If the left point and
 * the right pointer have equal value, we can move either of them, it doesn't matter.
 * 
 * Time: O(n)
 * Space: O(1)
 */

using System;
using NUnit.Framework;

namespace Container_With_Most_Water
{
    class Solution
    {
        public static int MaxArea(int[] height)
        {
            int leftPointer = 0;
            int rightPointer = height.Length - 1; ;
            int maxArea = 0;
            while (leftPointer < rightPointer)
            {
                int currContainerLength = rightPointer - leftPointer;
                int currArea = currContainerLength * Math.Min(height[leftPointer], height[rightPointer]);
                maxArea = Math.Max(currArea, maxArea);
                if (height[leftPointer] < height[rightPointer])
                {
                    leftPointer++;
                }
                else
                {
                    rightPointer--;
                }
            }
            return maxArea;
        }
    }

    class Tests
    {
        [Test]
        [TestCase(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }, ExpectedResult = 49)]
        [TestCase(new int[] { 1, 1 }, ExpectedResult = 1)]
        public int TestMaxArea(int[] height)
        {
            return Solution.MaxArea(height);
        }
    }
}
