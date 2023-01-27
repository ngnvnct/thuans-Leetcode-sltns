/*
 * This class contains everything need to test Linked List
 *
 */

using System.Collections.Generic;

namespace List_Node
{
    class ListNode
    {
        public int value;
        public ListNode next;

        public ListNode()
        {
        }

        public ListNode(int value = 0, ListNode next = null)
        {
            this.value = value;
            this.next = next;
        }

        public ListNode(int value)
        {
            this.value = value;
            next = null;
        }

        public int GetValue()
        {
            return this.value;
        }

        public ListNode AddMany(ListNode ll, List<int> values)
        {
            ListNode current = ll;
            while (current.next != null)
            {
                current = current.next;
            }
            foreach (int value in values)
            {
                current.next = new ListNode(value);
                current = current.next;
            }
            return ll;
        }

        public List<int> GetNodesInArray(ListNode ll)
        {
            List<int> nodes = new List<int>();
            ListNode current = ll;
            while (current != null)
            {
                nodes.Add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }
}
