using NUnit.Framework;
using System;
using System.Collections.Generic;

namespace Contains_Duplicate_0217
{
    class Solution
    {
        public bool ContainsDuplicateSet(int[] nums)
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

        public bool ContainsDuplicateSort(int[] nums)
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
        Contains_Duplicate_0217.Solution sol;
        [SetUp]
        public void Setup()
        {
            sol = new Solution();
        }

        [Test]
        [TestCase(new int[] { 1, 2, 3, 1 }, ExpectedResult = true)]
        [TestCase(new int[] { 1, 2, 3, 4 }, ExpectedResult = false)]
        [TestCase(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }, ExpectedResult = true)]
        public bool TestContainsDuplicateSort(int[] nums)
        {
            return sol.ContainsDuplicateSort(nums);
        }

        [Test]
        [TestCase(new int[] { 1, 2, 3, 1 }, ExpectedResult = true)]
        [TestCase(new int[] { 1, 2, 3, 4 }, ExpectedResult = false)]
        [TestCase(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }, ExpectedResult = true)]
        public bool TestContainsDuplicateSet(int[] nums)
        {
            return sol.ContainsDuplicateSet(nums);
        }
    }
}
