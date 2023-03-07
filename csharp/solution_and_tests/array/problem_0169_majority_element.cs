/*
 * https://leetcode.com/problems/majority-element/
 * Explanation:
 * 
 * The Boyer-Moore voting algorithm is one of the popular optimal algorithms
 * which is used to find the majority element among the given elements that have
 * more than N/ 2 occurrences.
 * This works perfectly fine for finding the majority element which takes 2
 * traversals over the given elements, which works in O(N) time complexity and
 * O(1) space complexity.
 * 
 * First, choose a candidate from the given set of elements if it is the same as
 * the candidate element, increase the votes.
 * Otherwise, decrease the votes if votes become 0, select another new element
 * as the new candidate.
 * 
 * Sorting is sort and get the nums[nums.length/2]
 * 
 * Time: O(n) or O(n log n)
 * Space: O(1)
 */

using System;
using NUnit.Framework;

namespace Majority_Element
{
    class Solution
    {
        public static int MajorityElement(int[] nums)
        {
            int count = 0;
            int candidate = 0;
            foreach (int num in nums)
            {
                if (count == 0)
                {
                    candidate = num;
                    count = 1;
                }
                else
                {
                    if (num == candidate)
                    {
                        count++;
                    }
                    else
                    {
                        count--;
                    }
                }
            }
            return candidate;
        }

        public static int MajorityElementSort(int[] nums)
        {
            Array.Sort(nums);
            return nums[nums.Length / 2];
        }
    }

    class Tests
    {
        [Test]
        [TestCase(new int[] { 3, 2, 3 }, ExpectedResult = 3)]
        [TestCase(new int[] { 2, 2, 1, 1, 1, 2, 2 }, ExpectedResult = 2)]
        public int TestMajorityElement(int[] nums)
        {
            return Solution.MajorityElement(nums);
        }

        [Test]
        [TestCase(new int[] { 3, 2, 3 }, ExpectedResult = 3)]
        [TestCase(new int[] { 2, 2, 1, 1, 1, 2, 2 }, ExpectedResult = 2)]
        public int TestMajorityElementSort(int[] nums)
        {
            return Solution.MajorityElementSort(nums);
        }
    }
}
