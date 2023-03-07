/*
 * https://leetcode.com/problems/contains-duplicate/
 * Explanation:
 * 
 * Create a HashSet and add the element to it. As it implements the Set
 * Interface, duplicate values are not allowed.
 * If an element is a duplicate, it will return true.
 * 
 * Time: O(n), lopping through the Array
 * Space: O(n), storing the Array in a Set
 * 
 * Sorting: Sorting then linear search, O(n log n) time and O(1) space if
 * heapsort is used. Althoug not a good idea to modify the input, make a copy
 * instead
 */

using NUnit.Framework;
using System;
using System.Collections.Generic;

namespace Contains_Duplicate
{
    class Solution
    {
        public static bool ContainsDuplicateSet(int[] nums)
        {
            HashSet<int> noDuplicate = new HashSet<int>();
            foreach (int num in nums)
            {
                if (noDuplicate.Contains(num))
                {
                    return true;
                }
                noDuplicate.Add(num);
            }
            return false;
        }

        public static bool ContainsDuplicateSort(int[] nums)
        {
            Array.Sort(nums);
            for (int i = 1; i < nums.Length; i++)
            {
                if (nums[i] == nums[i-1])
                {
                    return true;
                }
            }
            return false;
        }
    }

    public class Tests
    {
        [Test]
        [TestCase(new int[] { 1, 2, 3, 1 }, ExpectedResult = true)]
        [TestCase(new int[] { 1, 2, 3, 4 }, ExpectedResult = false)]
        [TestCase(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }, ExpectedResult = true)]
        public bool TestContainsDuplicateSort(int[] nums)
        {
            return Solution.ContainsDuplicateSort(nums);
        }

        [Test]
        [TestCase(new int[] { 1, 2, 3, 1 }, ExpectedResult = true)]
        [TestCase(new int[] { 1, 2, 3, 4 }, ExpectedResult = false)]
        [TestCase(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }, ExpectedResult = true)]
        public bool TestContainsDuplicateSet(int[] nums)
        {
            return Solution.ContainsDuplicateSet(nums);
        }
    }
}