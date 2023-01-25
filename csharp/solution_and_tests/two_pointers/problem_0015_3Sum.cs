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
        public IList<IList<int>> ThreeSum(int[] nums)
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
        Solution sol;
        [SetUp]
        public void SetUp()
        {
            sol = new Solution();
        }

        [Test]
        public void TestThreeSum()
        {
            int[] testCase1 = new int[] { -1, 0, 1, 2, -1, -4 };
            int[][] testCase1ExpectedResult = new int[][] { new int[] { -1, -1, 2 }, new int[] { -1, 0, 1 } };
            int[] testCase2 = new int[] { 0, 1, 1 };
            int[][] testCase2ExpectedResult = new int[0][];
            int[] testCase3 = new int[] { 0, 0, 0 };
            int[][] testCase3ExpectedResult = new int[][] { new int[] { 0, 0, 0 } };

            CollectionAssert.AreEqual(testCase1ExpectedResult, sol.ThreeSum(testCase1));
            CollectionAssert.AreEqual(testCase2ExpectedResult, sol.ThreeSum(testCase2));
            CollectionAssert.AreEqual(testCase3ExpectedResult, sol.ThreeSum(testCase3));
        }

    }
}
