/*
 * https://leetcode.com/problems/unique-morse-code-words/
 * Explanation:
 * 
 * Put morse code out of the word in a string then add it to a hash set, return
 * the size of the hash set is the unique morse code words
 * 
 * Time: O(n)
 * Space: O(n)
 */

using System.Collections.Generic;
using System.Text;
using NUnit.Framework;

namespace Unique_Morse_Code_Words
{
    class Solution
    {
        public int UniqueMorseRepresentations(string[] words)
        {
            string[] morseAlphabet = new string[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
            HashSet<string> uniqueTransformation = new HashSet<string>();
            foreach (string word in words)
            {
                StringBuilder sb = new StringBuilder();
                foreach (char letter in word)
                {
                    sb.Append(morseAlphabet[letter - 'a']);
                }
                uniqueTransformation.Add(sb.ToString());
            }
            return uniqueTransformation.Count;
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
        [TestCase(new object[] { "gin", "zen", "gig", "msg" }, ExpectedResult = 2)]
        [TestCase(new object[] { "a" }, ExpectedResult = 1)]
        public int TestValidPalindrome(params string[] words)
        {
            return sol.UniqueMorseRepresentations(words);
        }
    }
}