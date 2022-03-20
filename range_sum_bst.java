import java.util.Stack;

public class range_sum_bst {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high) {
                    res += node.val;
                }
                if (low < node.val) {
                    stack.push(node.left);
                }
                if (node.val < high) {
                    stack.push(node.right);
                }
            }
        }
        return res;
    }
}

/*
Explanation

Consider the value of the BST, 
10 is within [7,15], we take that
    10 
  5    15
3  7      18
when we see 5, there is no reason to go to the left of the subtree, since all the number will be smaller than it
same thing when we see 15, there is no reasion to the right of the sub tree

Time: O(n)
Space: O(n)

Follow Up: Prefix Tree, BST after flatenning BST
*/