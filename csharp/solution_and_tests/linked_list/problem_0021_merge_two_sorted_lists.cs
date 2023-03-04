/*
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Explanation:
 * 
 * We use a dummy node, and which value is smaller, we take it and point it to
 * the dummy node
 * 1->2->4
 * 1->3->4->5->6
 * if we exhaust a list, another list can have still have some values after it,
 * in that case, we just point our dummy.next to l2, and vice versa
 * 
 * Time: O(n + m)
 * Space: O(1)
 */

using List_Node;
using System.Collections.Generic;
using NUnit.Framework;

namespace Merge_Two_Sorted_Lists
{
    class Solution
    {
        public static ListNode MergeTwoLists(ListNode list1, ListNode list2)
        {
            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
            while(list1 != null && list2 != null)
            {
                if (list1.value < list2.value)
                {
                    dummy.next = list1;
                    list1 = list1.next;
                }
                else
                {
                    dummy.next = list2;
                    list2 = list2.next;
                }
                dummy = dummy.next;
            }
            if (list1 == null)
            {
                dummy.next = list2;
            }
            else
            {
                dummy.next = list1;
            }
            return head.next;
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
            ListNode testCase1FirstList = node.AddMany(new ListNode(2), new List<int> { 6, 7, 8 });
            ListNode testCase1SecondList = node.AddMany(new ListNode(1), new List<int> { 3, 4, 5, 9, 10 });
            List<int> testCase1ExpectedResult = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            ListNode testCase2FirstList = null;
            ListNode testCase2SecondList = null;
            List<int> testCase2ExpectedResult = new List<int>();
            ListNode testCase3FirstList = null;
            ListNode testCase3SecondList = new ListNode(0);
            List<int> testCase3ExpectedResult = new List<int> { 0 };

            CollectionAssert.AreEqual(testCase1ExpectedResult, node.GetNodesInArray(Solution.MergeTwoLists(testCase1FirstList, testCase1SecondList)));
            CollectionAssert.AreEqual(testCase2ExpectedResult, node.GetNodesInArray(Solution.MergeTwoLists(testCase2FirstList, testCase2SecondList)));
            CollectionAssert.AreEqual(testCase3ExpectedResult, node.GetNodesInArray(Solution.MergeTwoLists(testCase3FirstList, testCase3SecondList)));
        }
    }
}