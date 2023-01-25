/*
 * https://leetcode.com/problems/3sum-closest/description/ 
 * Explanation:
 * 
 * Similar to 3Sum, we would use the two pointers technique here. This requires a sorted Array
 * However, since this ideal triplet may not exist, we will track the smallest absolute difference
 * between the threeSum and the target
 * 
 * If diff is 0, this is our ideal triplet, break from the loop
 *
 * Time: O(n log n + n ^2) = O(n^2)
 * Space: O(log n) to O(n), depending on the implementation of the sorting algorithm
 */

using System;
using NUnit.Framework;

namespace ThreeSum_Closest
{
    class Solution
    {
        public int ThreeSumClosest(int[] nums, int target)
        {
            Array.Sort(nums);
            int diff = Int32.MaxValue;
            for (int i = 0; i < nums.Length && diff != 0; i++)
            {
                int leftPointer = i + 1;
                int rightPointer = nums.Length - 1;
                while (leftPointer < rightPointer)
                {
                    int threeSum = nums[i] + nums[leftPointer] + nums[rightPointer];
                    int closestThreeSum = target - threeSum;
                    if (Math.Abs(closestThreeSum) < Math.Abs(diff))
                    {
                        diff = closestThreeSum;
                    }
                    if (threeSum < target)
                    {
                        leftPointer++;
                    }
                    else
                    {
                        rightPointer--;
                    }
                }
            }
            return target - diff;
        }
    }

    class Tests
    {
        Solution sol;
        [SetUp]
        public void SetUp()
        {
            sol = new Solution();
        }

        [Test]
        [TestCase(new int[] { -1, 2, 1, -4 }, 1, ExpectedResult = 2)]
        [TestCase(new int[] { 0, 0, 0 }, 1, ExpectedResult = 0)]
        [TestCase(new int[] { 4, 0, 5, -5, 3, 3, 0, -4, -5 }, -2, ExpectedResult = -2)]
        public int TestThreeSumClosest(int[] nums, int target)
        {
            return sol.ThreeSumClosest(nums, target);
        }
    }
}