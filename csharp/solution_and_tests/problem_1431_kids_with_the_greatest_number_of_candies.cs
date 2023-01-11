/*
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * Explanation:
 * 
 * Find the upper limit, then check if adding the extra candies the new
 * candies[i] is bigger than the upper limit
 * 
 * Time: O(n)
 * Space: O(1)
 */

using System.Collections.Generic;
using System.Linq;
using NUnit.Framework;

namespace Kids_With_the_Greatest_Number_of_Candies
{
    class Solution
    {
        public IList<bool> KidsWithCandies(int[] candies, int extraCandies)
        {
            IList<bool> result = new List<bool>(candies.Length);
            int greatestCandyValue = candies.Max();
            for (int i = 0; i < candies.Length; i++)
            {
                int newCandies = candies[i] + extraCandies;
                result.Add(newCandies >= greatestCandyValue);
            }
            return result;
        }
    }

    public class Tests
    {
        Solution sol;
        [SetUp]
        public void Setup()
        {
            sol = new Solution();
        }

        [Test]
        [TestCase(new int[] { 2, 3, 5, 1, 3 }, 3, ExpectedResult = new bool[] { true, true, true, false, true })]
        [TestCase(new int[] { 4, 2, 1, 1, 2 }, 1, ExpectedResult = new bool[] { true, false, false, false, false })]
        [TestCase(new int[] { 12, 1, 12 }, 10, ExpectedResult = new bool[] { true, false, true })]
        public IList<bool> TestKidsWithCandies(int[] candies, int extraCandies)
        {
            return sol.KidsWithCandies(candies, extraCandies);
        }
    }
}