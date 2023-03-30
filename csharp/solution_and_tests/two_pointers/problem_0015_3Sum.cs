/*
 * https://leetcode.com/problems/3sum/
 * Explanation:
 * 
 * Sort the array, iterate through the list and use another two pointers (two
 * sum) to apporach the target
 * 
 * In the else statement
 * It is equal to 0, we add it to the result. Then we have to update the
 * pointer.
 * [-2,-2,0,0,2,2], we find the solution already, we increment left, we find a
 * dupe, we increment left again to skip same result, then our loop will shift in the if statement
 * We only have to update one pointer, and the conditions above will update the
 * other pointers
 * 
 * Time: O(n^2)
 * Space: O(1) or O(n) depend on sort library
 */

using System;
using System.Collections.Generic;
using NUnit.Framework;

namespace ThreeSum
{
    class Solution
    {
        public static IList<IList<int>> ThreeSum(int[] nums)
        {
            Array.Sort(nums);
            IList<IList<int>> triplets = new List<IList<int>>();
            for (int i = 0; i < nums.Length - 2; i++)
            {
                if (nums[i] > 0)
                {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1])
                { // SKip same result
                    continue;
                }
                int leftPointer = i + 1;
                int rightPointer = nums.Length - 1;
                while (leftPointer < rightPointer)
                {
                    int threeSum = nums[i] + nums[leftPointer] + nums[rightPointer];
                    if (threeSum < 0)
                    {
                        leftPointer++;
                    }
                    else if (threeSum > 0)
                    {
                        rightPointer--;
                    }
                    else
                    {
                        triplets.Add(new List<int> { nums[i], nums[leftPointer], nums[rightPointer] });
                        leftPointer++;
                        while (nums[leftPointer] == nums[leftPointer - 1] && leftPointer < rightPointer)
                        {
                            leftPointer++;
                        }
                    }
                }
            }
            return triplets;
        }
    }

    class Tests
    {
        [Test]
        public void TestThreeSum()
        {
            int[] testCase1 = new int[] { -1, 0, 1, 2, -1, -4 };
            IList<IList<int>> testCase1ExpectedResult = new List<IList<int>> { new List<int> { -1, -1, 2 }, new List<int> { -1, 0, 1 } };
            int[] testCase2 = new int[] { 0, 1, 1 };
            IList<IList<int>> testCase2ExpectedResult = new List<IList<int>>();
            int[] testCase3 = new int[] { 0, 0, 0 };
            IList<IList<int>> testCase3ExpectedResult = new List<IList<int>> { new List<int> { 0, 0, 0 } };

            CollectionAssert.AreEquivalent(testCase1ExpectedResult, Solution.ThreeSum(testCase1));
            CollectionAssert.AreEquivalent(testCase2ExpectedResult, Solution.ThreeSum(testCase2));
            CollectionAssert.AreEquivalent(testCase3ExpectedResult, Solution.ThreeSum(testCase3));
        }
    }
}
