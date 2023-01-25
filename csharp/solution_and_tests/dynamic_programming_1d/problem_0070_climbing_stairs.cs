/*
 * https://leetcode.com/problems/climbing-stairs/
 * Explantion:
 * 
 * Use Dynamic Programming to store expensive calculation (memoization). Have a
 * base case, then start with smaller values, and build a larger value using them.
 * 
 * You only need the previous two values so you don't need a DP array to store all of them
 * This is basically similar to https://leetcode.com/problems/fibonacci-number/
 * 
 * Time: O(n), n is input
 * Space: O(1)
 * 
 * Dynamic Programming: O(n) time, O(n) space
 * Recursion: O(2^n) time, Space O(n)
 */

using NUnit.Framework;

namespace Climbing_Stairs
{
    class Solution
    {
        public int ClimbStairs(int n)
        {
            if (n < 3)
            {
                return n;
            }
            int a = 1;
            int b = 2;
            int distinctWays = 0;
            while (n > 2)
            {
                distinctWays = a + b;
                a = b;
                b = distinctWays;
                n--;
            }
            return distinctWays;
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
        [TestCase(2, ExpectedResult = 2)]
        [TestCase(3, ExpectedResult = 3)]
        [TestCase(45, ExpectedResult = 1836311903)]
        public int TestClimbStairs(int n)
        {
            return sol.ClimbStairs(n);
        }
    }
}
