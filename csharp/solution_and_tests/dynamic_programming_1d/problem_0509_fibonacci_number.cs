/*
 * https://leetcode.com/problems/fibonacci-number/
 * Explanation:
 * 
 * Use Dynamic Programming to store expensive calculation (memoization). Have a
 * base case, then start with smaller values, and build a larger value using
 * them. You only need the previous two values so you don't need to store all of them
 * 
 * 
 * Time: O(n)
 * Space: O(1)
 */

using NUnit.Framework;

namespace Fibonacci_Number
{
    class Solution
    {
        public static int Fib(int n)
        {
            if (n <= 1)
            {
                return n;
            }
            int a = 0;
            int b = 1;
            int fibSequence = 0;
            while (n > 1)
            {
                fibSequence = a + b;
                a = b;
                b = fibSequence;
                n--;
            }
            return fibSequence;
        }
    }

    class Tests
    {
        [Test]
        [TestCase(2, ExpectedResult = 1)]
        [TestCase(3, ExpectedResult = 2)]
        [TestCase(4, ExpectedResult = 3)]
        [TestCase(30, ExpectedResult = 832040)]
        public int TestFib(int n)
        {
            return Solution.Fib(n);
        }
    }
}
