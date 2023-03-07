/*
 * https://leetcode.com/problems/palindrome-linked-list/
 * Explanation:
 * 
 * Use a stack, push all element onto the stack, then pop it and check it with
 * the current value
 * 
 * Time: O(n)
 * Space: O(n)
 * 
 */

using List_Node;
using System.Collections.Generic;
using NUnit.Framework;

namespace Palindrome_Linked_List
{
    class Solution
    {
        public static bool IsPalindrome(ListNode head)
        {
            Stack<int> stack = new Stack<int>();
            ListNode curr = head;
            while(curr != null)
            {
                stack.Push(curr.value);
                curr = curr.next;
            }
            while (head != null)
            {
                if (stack.Pop() != head.value)
                {
                    return false;
                }
                head = head.next;
            }
            return true;
        }
    }

    class Tests
    {
        ListNode node;
        [SetUp]
        public void SetUp()
        {
            node = new ListNode();
        }

        [Test]
        public void TestMergeTwoLists()
        {
            ListNode testCase1 = node.AddMany(new ListNode(1), new List<int> { 2, 2, 1 });
            ListNode testCase2 = node.AddMany(new ListNode(1), new List<int> { 2 });

            Assert.True(Solution.IsPalindrome(testCase1));
            Assert.False(Solution.IsPalindrome(testCase2));
        }
    }
}