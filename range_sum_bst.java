import java.util.Deque;
import java.util.LinkedList;

public class range_sum_bst {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            if (node != null) {
                if (low <= node.val && node.val <= high) {
                    res += node.val;
                }
                if (low < node.val) {
                    stack.addFirst(node.left);
                }
                if (node.val < high) {
                    stack.addFirst(node.right);
                }
            }
        }
        return res;
    }

    public int rangeSumDFS(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }
        if (low < root.val) {
            sum += rangeSumDFS(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumDFS(root.right, low, high);
        }
        return sum;
    }
}

/*
Explanation
Binary Search Tree is a node-based binary tree data structure which has the following properties:

The left subtree of a node contains only nodes with keys lesser than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
The left and right subtree each must also be a binary search tree.

Consider the value of the BST, 
10 is within [7,15], we take that
    10 
  5    15
3  7      18
when we see 5, there is no reason to go to the left of the subtree, since all the number will be smaller than it
same thing when we see 15, there is no reasion to the right of the sub tree

We traverse the tree using a depth first search. 
If node.val falls outside the range [low, high], (for example node.val < low), then we know that only the right branch could have nodes with value inside [L, R]

ArrayDeque does not accept null values, have to use LinkedList

Time: O(n)
Space: O(n)
*/