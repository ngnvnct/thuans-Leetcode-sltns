/*
 * https://leetcode.com/problems/valid-anagram/
 * Explanation:
 * 
 * Make a alphabet array of 26 elements. Take the current character subtract by
 * 'a' to get the ASCII code value of that letter. For example, 'a' is 97 and
 * 'z' is 122, 122-97 = 25, the last element
 * in the alphabet array. Loop through the string and increment the alphabet
 * element, then loop through the 2nd string and decrement the alphabet element.
 * If the array element is negative, it is not an anagram.
 * 
 * Sorting: O(n log n) time, in Java toCharArray makes a copy so it will be O(n)
 * space, otherwise it is O(1) space (language dependent detail)
 * 
 * Time: O(2n) -> O(n)
 * Space: O(26) -> O(1)
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you adapt
 * your solution to such a case?
 * 
 * Make a hash map with similar concept to the bucket, and loop throught the
 * values if it is negative it is not an anagram
 * 
 * Time: O(n)
 * Space: O(n)
 */

using System;
using System.Linq;
using NUnit.Framework;

namespace Valid_Anagram
{
    class Solution
    {
        public static bool IsAnagram(string s, string t)
        {
            if (s.Length != t.Length)
            {
                return false;
            }
            int[] alphabet = new int[26];
            foreach (char c in s)
            {
                alphabet[c - 'a']++;
            }
            foreach (char c in t)
            {
                alphabet[c - 'a']--;
                if (alphabet[c - 'a'] < 0)
                {
                    return false;
                }
            }
            return true;
        }

        public static bool IsAnagramSort(String s, String t)
        {
            if (s.Length != t.Length)
            {
                return false;
            }
            char[] sortS = s.ToCharArray();
            char[] sortT = t.ToCharArray();
            Array.Sort(sortS);
            Array.Sort(sortT);
            return Enumerable.SequenceEqual(sortS, sortT);
        }
    }

    class Tests
    {
        [Test]
        [TestCase("anagram", "nagaram", ExpectedResult = true)]
        [TestCase("rat", "cat", ExpectedResult = false)]
        [TestCase("anagram", "agaram", ExpectedResult = false)]
        public bool TestIsAnagram(string s, string t)
        {
            return Solution.IsAnagram(s, t);
        }

        [Test]
        [TestCase("anagram", "nagaram", ExpectedResult = true)]
        [TestCase("rat", "cat", ExpectedResult = false)]
        [TestCase("anagram", "agaram", ExpectedResult = false)]
        public bool TestIsAnagramSort(string s, string t)
        {
            return Solution.IsAnagramSort(s, t);
        }
    }
}
