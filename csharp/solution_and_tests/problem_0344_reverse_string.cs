/*
 * https://leetcode.com/problems/reverse-string/
 * Explanation:
 * 
 * Two pointer approach, keep the left pointer and the right pointer, loop to the half way point and swap the element
 * 
 * Time: O(n) to swap n / 2 element
 * Space: O(1)
*/

using NUnit.Framework;

namespace Reverse_String
{
    class Solution
    {
        public void ReverseString(char[] s)
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

        public char[] ReverseStringTestVoid(char[] s)
        {
            ReverseString(s);
            return s;
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
        public void TestReverseString()
        {
            char[] testCase1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
            char[] testCase1ExpectedResult = new char[] { 'o', 'l', 'l', 'e', 'h' };
            char[] testCase2 = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
            char[] testCase2ExpectedResult = new char[] { 'h', 'a', 'n', 'n', 'a', 'H' };

            sol.ReverseString(testCase1);
            sol.ReverseString(testCase2);
            Assert.AreEqual(testCase1ExpectedResult, testCase1);
            Assert.AreEqual(testCase2ExpectedResult, testCase2);
        }

        [Test]
        [TestCase(new char[] { 'h', 'e', 'l', 'l', 'o' }, ExpectedResult = new char[] { 'o', 'l', 'l', 'e', 'h' })]
        [TestCase(new char[] { 'H', 'a', 'n', 'n', 'a', 'h' }, ExpectedResult = new char[] { 'h', 'a', 'n', 'n', 'a', 'H' })]
        public char[] TestReverseStringTestVoid(char[] s)
        {
            return sol.ReverseStringTestVoid(s);
        }
    }
}
