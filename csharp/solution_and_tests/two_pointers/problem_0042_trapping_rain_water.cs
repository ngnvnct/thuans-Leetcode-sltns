/*
 * https://leetcode.com/problems/trapping-rain-water/
 * Explanation:
 * 
 * maxLeft = 0,1,2,3
 * maxRight = 1,2
 * [L,L,L,L,L,L,L,L,R,R,R,R] <--- Pointer
 * [0,1,0,2,1,0,1,3,2,1,2,1] <--- Input
 * [0,0,1,0,1,2,1,0,0,1,0,0] <--- Trap Water, 1 + 1 + 2 +1 +1 = 6
 * 
 * We have a maxLeft and a maxRight to update the largest value
 * Shift the one that has the smaller max value
 * We can't have water at the endpoint, and we don't count negative number
 * Running throught he algorithm with two pointers
 * 
 * Time: O(n)
 * Space: O(1)
 * 
 * O(n) Memory Solution
 * 1. We can't have water at the end point, we move our pointer when maxLeft
 * 2. We want the Min(maxLeft, maxRight)
 * 3. We shift the pointer whenever maxLeft < maxRight or vice versa
 * 4. Calculate it, if maxLeft/maxRight subtract by height[left]/height[right]
 * and the result if negative, we set it to 0
 * 5. Code Wise, if you update maxLeft or maxRight, you will never get a
 * negative result
 * 
 * Input    [0,1,0,2,1,0,1,3,2,1,2,1]
 * maxLeft  [0,0,1,1,2,2,2,3,3,3,3,3], max height on the left of this
 * maxRight [3,3,3,3,3,3,3,2,2,2,1,0], max height on the right of this
 * Min(l,r) [0,1,1,2,2,2,2,3,2,2,2,0]
 * 
 * Input     [0,1,0,2,1,0,1,3,2,1,2,1]
 * Min-Input [0,0,1,0,1,2,1,0,0,1,0,0] = 1 + 1 + 2 + 1 + 1 = 6
 * Calculation (Min(l,r) - heights >= 0)
 * Space: O(n)
 */

using System;
using NUnit.Framework;

namespace Trapping_Rain_Water
{
    class Solution
    {
        public static int Trap(int[] height)
        {
            if (height == null || height.Length == 0)
            {
                return 0;
            }
            int leftPointer = 0;
            int rightPointer = height.Length - 1;
            int leftMax = height[leftPointer];
            int rightMax = height[rightPointer];
            int trapWater = 0;

            while (leftPointer < rightPointer)
            {
                if (leftMax <= rightMax)
                {
                    leftPointer++;
                    leftMax = Math.Max(leftMax, height[leftPointer]);
                    trapWater += leftMax - height[leftPointer];
                }
                else
                {
                    rightPointer--;
                    rightMax = Math.Max(rightMax, height[rightPointer]);
                    trapWater += rightMax - height[rightPointer];
                }
            }
            return trapWater;
        }

        public static int TrapMemory(int[] height)
        {
            if (height == null)
            {
                return 0;
            }
            int[] leftMax = new int[height.Length];
            int[] rightMax = new int[height.Length];
            leftMax[0] = height[0];
            rightMax[height.Length - 1] = height[height.Length - 1];
            int trapWater = 0;
            for (int i = 1; i < height.Length; i++)
            {
                leftMax[i] = Math.Max(height[i], leftMax[i - 1]);
            }
            for (int i = height.Length - 2; i > -1; i--)
            {
                rightMax[i] = Math.Max(height[i], rightMax[i + 1]);
            }
            for (int i = 0; i < height.Length - 1; i++)
            {
                trapWater += Math.Min(leftMax[i], rightMax[i]) - height[i];
            }
            return trapWater;
        }
    }

    class Test
    {
        [Test]
        [TestCase(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }, ExpectedResult = 6)]
        [TestCase(new int[] { 4, 2, 0, 3, 2, 5 }, ExpectedResult = 9)]
        public int TestTrap(int[] height)
        {
            return Solution.Trap(height);
        }

        [Test]
        [TestCase(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }, ExpectedResult = 6)]
        [TestCase(new int[] { 4, 2, 0, 3, 2, 5 }, ExpectedResult = 9)]
        public int TestTrapMemory(int[] height)
        {
            return Solution.TrapMemory(height);
        }
    }
}
