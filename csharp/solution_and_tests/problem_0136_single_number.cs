/*
 * https://leetcode.com/problems/single-number/
 * Explanation:
 * 
 * This is a bit manipulation problem. ^= is XOR, the integer becomes binary
 * representation, and XOR will calculate as
 * 1 ^ 0 = 1
 * 0 ^ 1 = 1
 * 1 ^ 1 = 0
 * 0 ^ 0 = 0
 * If you XOR the exact same number, they will become 0 in the output.
 * 
 * Time: O(n)
 * Space: O(1)
 */

using NUnit.Framework;

namespace Single_Number
{
    class Solution
    {
        public int SingleNumber(int[] nums)
        {
            int bitWise = 0;
            foreach (int num in nums)
            {
                bitWise ^= num;
            }
            return bitWise;
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
        [TestCase(new int[] { 2, 2, 1 }, ExpectedResult = 1)]
        [TestCase(new int[] { 4, 1, 2, 1, 2 }, ExpectedResult = 4)]
        [TestCase(new int[] { 1 }, ExpectedResult = 1)]
        public int TestSingleNumber(int[] nums)
        {
            return sol.SingleNumber(nums);
        }
    }
}
