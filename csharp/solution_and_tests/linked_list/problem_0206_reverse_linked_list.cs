/*
 * https://leetcode.com/problems/reverse-linked-list/
 * Explanation:
 * 
 * While traversing the list, we can change the current node's next pointer to point to its previous element. 
 * Since a node does not have reference to its previous node, we must store its previous element beforehand. 
 * We also need another pointer to store the next node before changing the reference. 
 * Do not forget to return the new head reference at the end!
 * 
 * Time: O(n)
 * Space: O(1) for iterative, O(n) for recursive
 */

using List_Node;
using System.Collections.Generic;
using NUnit.Framework;

namespace Reverse_Linked_List
{
    class Solution
    {
        public static ListNode ReverseList(ListNode head)
        {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null)
            {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        public static ListNode ReverseListRecursive(ListNode head)
        {
            if (head == null || head.next == null)
            {
                return head;
            }
            ListNode newHead = ReverseListRecursive(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

    class Tests
    {
        Solution sol;
        ListNode node;
        [SetUp]
        public void SetUp()
        {
            sol = new Solution();
            node = new ListNode();
        }

        [Test]
        public void TestReverseList()
        {
            ListNode testCase1 = node.AddMany(new ListNode(1), new List<int> { 2, 3, 4, 5 });
            List<int> testCase1ExpectedResult = new List<int> { 5, 4, 3, 2, 1 };
            ListNode testCase2 = node.AddMany(new ListNode(1), new List<int> { 2 });
            List<int> testCase2ExpectedResult = new List<int> { 2, 1 };
            ListNode testCase3 = null;
            List<int> testCase3ExpectedResult = new List<int>();

            CollectionAssert.AreEqual(testCase1ExpectedResult, node.GetNodesInArray(Solution.ReverseList(testCase1)));
            CollectionAssert.AreEqual(testCase2ExpectedResult, node.GetNodesInArray(Solution.ReverseList(testCase2)));
            CollectionAssert.AreEqual(testCase3ExpectedResult, node.GetNodesInArray(Solution.ReverseList(testCase3)));
        }

        [Test]
        public void TestReverseListRecursive()
        {
            ListNode testCase1 = node.AddMany(new ListNode(1), new List<int> { 2, 3, 4, 5 });
            List<int> testCase1ExpectedResult = new List<int> { 5, 4, 3, 2, 1 };
            ListNode testCase2 = node.AddMany(new ListNode(1), new List<int> { 2 });
            List<int> testCase2ExpectedResult = new List<int> { 2, 1 };
            ListNode testCase3 = null;
            List<int> testCase3ExpectedResult = new List<int>();

            CollectionAssert.AreEqual(testCase1ExpectedResult, node.GetNodesInArray(Solution.ReverseListRecursive(testCase1)));
            CollectionAssert.AreEqual(testCase2ExpectedResult, node.GetNodesInArray(Solution.ReverseListRecursive(testCase2)));
            CollectionAssert.AreEqual(testCase3ExpectedResult, node.GetNodesInArray(Solution.ReverseListRecursive(testCase3)));
        }
    }
}
