using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace Leetcode
{
    public class Solution
    {
        public int[] TwoSum(int[] nums, int target)
        {
            Dictionary<int, int> map = new Dictionary<int, int>();
            for (int i = 0; i < nums.Length; i++)
            {
                if (map.ContainsKey(nums[i]))
                {
                    return new int[] { map[nums[i]], i };
                }
                map[target - nums[i]] = i;
            }
            return null;
        }
    }

    public class Tests
    {
        Leetcode.Solution sol;
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

/*
 * Part of Leetcode75
 * https://leetcode.com/problems/two-sum/
 * Explantion
 * 
 * We want to make a HashMap to keep trace of the difference of the element.
 * First, we have an if-statement asking is the HashMap contains this element
 * If yes, we return the value of the key-value pair, along with the current
 * index
 * Else, we put the key as the difference (target-nums[i]), and the value is the
 * current index
 * 
 * Line 18 and 19 can be replace by return new int[] {map.get(nums[i]), i};
 * 
 * Brute Force way is two nested loop then check each one, O(n^2) time and O(1)
 * space
 * 
 * Time: O(n), looping through n elements of Array
 * Space: O(n), storing the Array in HashMap
 */