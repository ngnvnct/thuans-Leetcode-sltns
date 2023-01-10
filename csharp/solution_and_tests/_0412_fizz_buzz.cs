using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;

namespace Fizz_Buzz
{
    class Solution
    {
        public IList<string> FizzBuzz(int n)
        {
            IList<string> res = new List<string>(n);
            for (int i = 1; i <= n; i++)
            {
                if (i % 15 == 0)
                {
                    res.Add("FizzBuzz");
                }
                else if (i % 5 == 0)
                {
                    res.Add("Buzz");
                }
                else if (i % 3 == 0)
                {
                    res.Add("Fizz");
                }
                else
                {
                    res.Add($"{i}");
                }
            }
            return res;
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

        /* C# Test Explanation
         * Cannot use non-constant expression in TestCase, and IList is one of them
         * Have to do it like this, or use TestCaseSource. This set up works
         * Need to use CollectionAssert to test List
         * https://learn.microsoft.com/en-us/dotnet/api/microsoft.visualstudio.testtools.unittesting.collectionassert?redirectedfrom=MSDN&view=visualstudiosdk-2022
        */
        [Test]
        public void TestFizzBuzz()
        {
            int testCase1 = 3;
            int testCase2 = 5;
            int testCase3 = 15;
            IList<string> expectedResult1 = new List<string> { "1", "2", "Fizz" };
            IList<string> expectedResult2 = new List<string> { "1", "2", "Fizz", "4", "Buzz" };
            IList<string> expectedResult3 = new List<string> { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz" };

            CollectionAssert.AreEqual(expectedResult1, sol.FizzBuzz(testCase1));
            CollectionAssert.AreEqual(expectedResult2, sol.FizzBuzz(testCase2));
            CollectionAssert.AreEqual(expectedResult3, sol.FizzBuzz(testCase3));
        }
    }
}

/*
 * https://leetcode.com/problems/fizz-buzz/
 * Explantion:
 * Use modulus % to return the remainder of two number after division
 * 
 * Time: O(n), n is input
 * Space: O(n), storing the result
 */