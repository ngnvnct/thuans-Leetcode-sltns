/*
 * https://leetcode.com/problems/reverse-string/
 * Explanation:
 * 
 * Two pointer approach, keep the left pointer and the right pointer, loop to the half way point and swap the element
 * 
 * Time: O(n) to swap n / 2 element
 * Space: O(1)
*/

using System.Collections.Generic;
using NUnit.Framework;

namespace Reverse_String
{
    class Solution
    {
        public static void ReverseString(char[] s)
        {
            int leftPointer = 0;
            int rightPointer = s.Length - 1;
            while (leftPointer < rightPointer)
            {
                char temp = s[leftPointer];
                s[leftPointer++] = s[rightPointer];
                s[rightPointer--] = temp;
            }
        }

        public static char[] ReverseStringTestVoid(char[] s)
        {
            ReverseString(s);
            return s;
        }

        public static void ReverseStringStack(char[] s)
        {
            Stack<char> stack = new Stack<char>();
            foreach (char letter in s)
            {
                stack.Push(letter);
            }
            for (int i = 0; i < s.Length; i++)
            {
                s[i] = stack.Pop();
            }
        }

        public static char[] ReverseStringTestStack(char[] s)
        {
            ReverseStringStack(s);
            return s;
        }
    }

    class Tests
    {
        [Test]
        public void TestReverseString()
        {
            char[] testCase1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
            char[] testCase1ExpectedResult = new char[] { 'o', 'l', 'l', 'e', 'h' };
            char[] testCase2 = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
            char[] testCase2ExpectedResult = new char[] { 'h', 'a', 'n', 'n', 'a', 'H' };

            Solution.ReverseString(testCase1);
            Solution.ReverseString(testCase2);
            Assert.AreEqual(testCase1ExpectedResult, testCase1);
            Assert.AreEqual(testCase2ExpectedResult, testCase2);
        }

        [Test]
        [TestCase(new char[] { 'h', 'e', 'l', 'l', 'o' }, ExpectedResult = new char[] { 'o', 'l', 'l', 'e', 'h' })]
        [TestCase(new char[] { 'H', 'a', 'n', 'n', 'a', 'h' }, ExpectedResult = new char[] { 'h', 'a', 'n', 'n', 'a', 'H' })]
        public char[] TestReverseStringTestVoid(char[] s)
        {
            return Solution.ReverseStringTestVoid(s);
        }

        [Test]
        public void TestReverseStringStack()
        {
            char[] testCase1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
            char[] testCase1ExpectedResult = new char[] { 'o', 'l', 'l', 'e', 'h' };
            char[] testCase2 = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
            char[] testCase2ExpectedResult = new char[] { 'h', 'a', 'n', 'n', 'a', 'H' };

            Solution.ReverseStringStack(testCase1);
            Solution.ReverseStringStack(testCase2);
            Assert.AreEqual(testCase1ExpectedResult, testCase1);
            Assert.AreEqual(testCase2ExpectedResult, testCase2);
        }

        [Test]
        [TestCase(new char[] { 'h', 'e', 'l', 'l', 'o' }, ExpectedResult = new char[] { 'o', 'l', 'l', 'e', 'h' })]
        [TestCase(new char[] { 'H', 'a', 'n', 'n', 'a', 'h' }, ExpectedResult = new char[] { 'h', 'a', 'n', 'n', 'a', 'H' })]
        public char[] TestReverseStringTestStack(char[] s)
        {
            return Solution.ReverseStringTestVoid(s);
        }
    }
}
