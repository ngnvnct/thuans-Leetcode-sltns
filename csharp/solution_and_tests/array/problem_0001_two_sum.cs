/*
 * https://leetcode.com/problems/two-sum/
 * Explanation:
 * 
 * We want to make a Dictionary to keep trace of the difference of the element.
 * First, we have an if-statement asking is the Dictionary contains this element
 * If yes, we return the value of the key-value pair, along with the current
 * index
 * Else, we put the key as the difference (target-nums[i]), and the value is the
 * current index
 * 
 * Brute Force way is two nested loop then check each one, O(n^2) time and O(1)
 * space
 * 
 * Time: O(n), looping through n elements of Array
 * Space: O(n), storing the Array in HashMap
 */

using NUnit.Framework;
using System.Collections.Generic;

namespace Two_Sum
{
    public class Solution
    {
        public static int[] TwoSum(int[] nums, int target)
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
        [Test]
        [TestCase(new int[] { 2, 7, 11, 15 }, 9, ExpectedResult = new int[] { 0, 1 })]
        [TestCase(new int[] { 3, 2, 4 }, 6, ExpectedResult = new int[] { 1, 2 })]
        [TestCase(new int[] { 3, 3 }, 6, ExpectedResult = new int[] { 0, 1 })]
        public int[] TestTwoSum(int[] nums, int target)
        {
            return Solution.TwoSum(nums, target);
        }
    }
}