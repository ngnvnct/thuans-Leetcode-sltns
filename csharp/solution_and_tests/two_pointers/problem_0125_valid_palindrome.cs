/*
 * https://leetcode.com/problems/valid-palindrome/
 * Explanation:
 * 
 * With this method, you don't have to do RegEx stuff to remove all spaces and commas from a string.
 * We use Char.IsLetterOrDigit to skip the " " space character, and we don't need to use char array
 * Using two pointers technique
 * 
 * Time: O(n)
 * Space: O(1)
 */

using System;
using NUnit.Framework;

namespace Valid_Palindrome
{
    class Solution
    {
        public static bool IsPalindrome(string s)
        {
            int leftPointer = 0;
            int rightPointer = s.Length - 1;
            s = s.ToLower();
            while (leftPointer < rightPointer)
            {
                while (!Char.IsLetterOrDigit(s[leftPointer]) && leftPointer < rightPointer)
                {
                    leftPointer++;
                }
                while (!Char.IsLetterOrDigit(s[rightPointer]) && leftPointer < rightPointer)
                {
                    rightPointer--;
                }
                if (s[leftPointer++] != s[rightPointer--])
                {
                    return false;
                }
            }
            return true;
        }
    }

    class Tests
    {
        [Test]
        [TestCase("A man, a plan, a canal: Panama", ExpectedResult = true)]
        [TestCase("race a car", ExpectedResult = false)]
        [TestCase("", ExpectedResult = true)]
        [TestCase("Was it a car or a cat I saw", ExpectedResult = true)]
        [TestCase("No 'x' in Nixon", ExpectedResult = true)]
        [TestCase("Live on time, emit no evil", ExpectedResult = true)]
        [TestCase("Was it a cat I saw?", ExpectedResult = true)]
        [TestCase("Eva, can I see bees in a cave?", ExpectedResult = true)]
        [TestCase("Madam, in Eden, I'm Adam", ExpectedResult = true)]
        [TestCase("Never odd or even", ExpectedResult = true)]
        [TestCase("Do geese see God?", ExpectedResult = true)]
        [TestCase("Mr. Owl ate my metal worm", ExpectedResult = true)]
        [TestCase("A Santa, at NASA", ExpectedResult = true)]
        [TestCase("Yo, Banana Boy!", ExpectedResult = true)]
        [TestCase("Madam, in Alaska, I'm Adam", ExpectedResult = false)]
        [TestCase("A man, a plan, a canal -- Panama", ExpectedResult = true)]
        [TestCase("Mr. Owl ate my metal worm?", ExpectedResult = true)]
        public bool TestIsPalindrome(string s)
        {
            return Solution.IsPalindrome(s);
        }
    }
}
