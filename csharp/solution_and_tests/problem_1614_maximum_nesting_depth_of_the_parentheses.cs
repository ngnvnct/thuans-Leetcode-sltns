using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;

namespace Maximum_Nesting_Depth_of_the_Parentheses
{
    class Solution
    {
        public int MaxDepth(string s)
        {
            int currDepth = 0;
            int maxDepth = 0;

            foreach (char c in s)
            {
                if (c == '(')
                {
                    currDepth++;
                    maxDepth = Math.Max(currDepth, maxDepth);
                }
                else if (c == ')')
                {
                    currDepth--;
                    if (currDepth < 0)
                    {
                        return -1;
                    }
                }
            }
            return currDepth == 0 ? maxDepth : -1;
        }
    }

    class Test
    {
        Solution sol;
        [SetUp]
        public void Setup()
        {
            sol = new Solution();
        }

        [Test]
        [TestCase("(1+(2*3)+((8)/4))+1", ExpectedResult = 3)]
        [TestCase("(1)+((2))+(((3)))", ExpectedResult = 3)]
        [TestCase("8*((1*(5+6))*(8/6))", ExpectedResult = 3)]
        [TestCase("((())", ExpectedResult = -1)]
        public int TestMaxDepth(string s)
        {
            return sol.MaxDepth(s);
        }
    }
}

/*
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 * Explanation
 * 
 * Ask by Facebook Phone
 * A naive solution is to use a stack, don't do that.
 * Just ignore digits and signs and only count the ( or )
 * Keep a variable currDepth that is the Math.max of current max and max depth,
 * everytime you see an open, you increment currDepth and update a new max
 * If you see a close parentheses, decrement currDepth
 * 
 * Not on leetcode, a facebook constraint is if a parentheses is unbalance,
 * return -1, we have that if condition in the loop to terminate early
 * At the end of the loop, we have to check if currMax is 0, if it is not zero
 * that means it is unbalance, return -1
 * 
 * Time: O(n)
 * Space: O(1)
 */