/*
 * https://leetcode.com/problems/simplify-path/
 * Explanation:
 * 
 * Keep a stack to push the directory on it, and split the components to array
 * of strings
 * if it is "." or the directory is empty, we just continue, "." means the
 * current directory
 * if it is ".." meaning we want to go up one directory, we pop it out of the
 * stack
 * else, we add it to the stack
 * 
 * Then we build a new string, 2 methods to build the string using Deque
 * 
 * Time: O(n)
 * Space: O(2n) -> O(n), split component array and the stack
 */

using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace Simplify_Path
{
    class Solution
    {
        public string SimplifyPath(string path)
        {
            LinkedList<string> deque = new LinkedList<string>();
            string[] components = path.Split("/");
            foreach (string directory in components)
            {
                if (directory.Equals(".") || directory.Equals(String.Empty))
                {
                    continue;
                }
                else if (directory.Equals(".."))
                {
                    if (deque.Count > 0)
                    {
                        deque.RemoveLast();
                    }
                }
                else
                {
                    deque.AddLast(directory);
                }
            }
            StringBuilder res = new StringBuilder();
            foreach (string element in deque)
            {
                res.Append("/").Append(element);
            }
            return res.Length > 0 ? res.ToString() : "/";
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
        [TestCase("/home/", ExpectedResult = "/home")]
        [TestCase("/../", ExpectedResult = "/")]
        [TestCase("/home//foo/", ExpectedResult = "/home/foo")]
        public string TestSimplifyPath(string path)
        {
            return sol.SimplifyPath(path);
        }
    }
}
