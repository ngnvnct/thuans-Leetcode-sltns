/*
 * https://leetcode.com/problems/add-two-numbers/
 * Explanation:
 * 
 * Elementary math but there are some ege cases to consider
 * 
 * We make a dummy node and initialize current node to the dummy head
 * initialize carry to 0 and loop through the lists
 * set x to node l1, if it has reaches the end then set to 0, and do the same
 * for y as node l2
 * set sum = x + y + carry and get the carry by doing sum / 10
 * create a new node with the digit value of sum mod 10 to set it to the current
 * node next
 * then advance current node to next
 * 
 * When one list is longer than the other
 * When one list is null, empty list
 * The sum could have an extra carry of one at the end 99 + 1
 * 
 * Time: O(max(n,m)) where n and m are the length of l1 and l2
 * Space: O(max(n,m)), the length of the new list is at most max(n,m) + 1
 */

using List_Node;
using System.Collections.Generic;
using NUnit.Framework;

namespace Add_Two_Numbers
{
    class Solution
    {
        public static ListNode AddTwoNumbers(ListNode l1, ListNode l2)
        {
            int carry = 0;
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            while (l1 != null || l2 != null)
            {
                int x = (l1 != null) ? l1.value : 0;
                int y = (l2 != null) ? l2.value : 0;
                int sum = x + y + carry;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (l1 != null)
                {
                    l1 = l1.next;
                }
                if (l2 != null)
                {
                    l2 = l2.next;
                }
            }
            if (carry > 0)
            {
                curr.next = new ListNode(carry);
            }
            return dummy.next;
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
        public void TestAddTwoNumbers()
        {
            ListNode testCase1FirstNum = node.AddMany(new ListNode(2), new List<int> { 4, 3 });
            ListNode testCase1SecondNum = node.AddMany(new ListNode(5), new List<int> { 6, 4 });
            List<int> testCase1ExpectedResult = new List<int> { 7, 0, 8 };
            ListNode testCase2FirstNum = node.AddMany(new ListNode(9), new List<int> { 9 });
            ListNode testCase2SecondNum = new ListNode(1);
            List<int> testCase2ExpectedResult = new List<int> { 0, 0, 1 };

            CollectionAssert.AreEqual(testCase1ExpectedResult, node.GetNodesInArray(Solution.AddTwoNumbers(testCase1FirstNum, testCase1SecondNum)));
            CollectionAssert.AreEqual(testCase2ExpectedResult, node.GetNodesInArray(Solution.AddTwoNumbers(testCase2FirstNum, testCase2SecondNum)));
        }
    }
}
