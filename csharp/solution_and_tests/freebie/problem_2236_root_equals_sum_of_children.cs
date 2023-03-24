using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace Root_Equals_Sum_of_Children
{
    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution
    {
        public static bool CheckTree(TreeNode root)
        {
            int sum = root.left.val + root.right.val;
            if (root.val == sum)
            {
                return true;
            }
            return false;
        }
    }

    class Test
    {
        [Test]
        public void TestCheckTree()
        {
            TreeNode tree1 = new TreeNode(10, new TreeNode(5), new TreeNode(5));
            Assert.IsTrue(Solution.CheckTree(tree1));

            TreeNode tree2 = new TreeNode(10, new TreeNode(5), new TreeNode(6));
            Assert.IsFalse(Solution.CheckTree(tree2));

            TreeNode tree3 = new TreeNode(0, new TreeNode(0), new TreeNode(0));
            Assert.IsTrue(Solution.CheckTree(tree3));

            TreeNode tree4 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
            Assert.IsFalse(Solution.CheckTree(tree4));

            TreeNode tree5 = new TreeNode(1, new TreeNode(0), new TreeNode(0));
            Assert.IsFalse(Solution.CheckTree(tree5));
        }
    }
}
