using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace solution
{
    public class Solution
    {
        public int[] TwoSum(int[] nums, int target)
        {
            Dictionary<int, int> map = new Dictionary<int, int>();
            for (int i = 0; i < nums.Length; i++)
            {
                int diff = target - nums[i];
                if (map.ContainsKey(diff))
                {
                    return new int[] { map[diff], i };
                }
                else
                {
                    map[nums[i]] = i;
                }
            }
            return null;
        }
    }

    public class Tests
    {
        solution.Solution sol;
        [SetUp]
        public void Setup()
        {
            sol = new Solution();
        }

        [Test]
        public void TestTwoSum()
        {
            Assert.AreEqual(new int[] { 1, 2 }, sol.TwoSum(new int[] { 0, 1, 2 }, 3));
            Assert.AreNotEqual(new int[] { 0, 2 }, sol.TwoSum(new int[] { 0, 1, 2 }, 3));
        }
    }
}
