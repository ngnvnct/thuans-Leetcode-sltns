/*
 * https://leetcode.com/problems/defanging-an-ip-address/description/
 * Explanation:
 * 
 * Method 1 is straight forward. Method 2 is a shortening version of method 1. 
 * Method 3 introduces Deque (Double-Ended Queue), which is another way of solving it
 * 
 * Time: O(n)
 * Space: O(n)
*/

using System.Collections.Generic;
using System.Text;
using NUnit.Framework;

namespace Defanging_an_IP_Address
{
    class Solution
    {
        public string DefangIPaddr(string address)
        {
            StringBuilder sb = new StringBuilder();
            foreach (char c in address)
            {
                if (c == '.')
                {
                    sb.Append("[.]");
                }
                else
                {
                    sb.Append(c);
                }
            }
            return sb.ToString();
        }

        public string DefangIPaddr2(string address)
        {
            return address.Replace(".", "[.]");
        }

        public string DefangIPaddrDeque(string address)
        {
            LinkedList<char> deque = new LinkedList<char>();
            StringBuilder sb = new StringBuilder();
            foreach (char c in address)
            {
                deque.AddLast(c);
            }
            while (deque.Count > 0)
            {
                char c = deque.First.Value;
                deque.RemoveFirst();
                if (c == '.')
                {
                    sb.Append("[.]");
                }
                else
                {
                    sb.Append(c);
                }
            }
            return sb.ToString();
        }
    }
    class Tests
    {
        Solution sol;
        [SetUp]
        public void Setup()
        {
            sol = new Solution();
        }

        [Test]
        [TestCase("1.1.1.1", ExpectedResult = "1[.]1[.]1[.]1")]
        [TestCase("255.100.50.0", ExpectedResult = "255[.]100[.]50[.]0")]
        public string TestDefangIPaddr(string address)
        {
            return sol.DefangIPaddr(address);
        }

        [Test]
        [TestCase("1.1.1.1", ExpectedResult = "1[.]1[.]1[.]1")]
        [TestCase("255.100.50.0", ExpectedResult = "255[.]100[.]50[.]0")]
        public string TestDefangIPaddr2(string address)
        {
            return sol.DefangIPaddr2(address);
        }

        [Test]
        [TestCase("1.1.1.1", ExpectedResult = "1[.]1[.]1[.]1")]
        [TestCase("255.100.50.0", ExpectedResult = "255[.]100[.]50[.]0")]
        public string TestDefangIpaddrDeque(string address)
        {
            return sol.DefangIPaddrDeque(address);
        }
    }
}