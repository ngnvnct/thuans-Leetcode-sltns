public class search_in_a_bst {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val == val) {
                return temp;
            }
            if (temp.val > val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    public TreeNode searchBSTRecursion(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}

/*
Explanation
Key take away: BST is a binary tree where the key in each node
is greater than any key stored in the left sub-tree
and less than any key stored in the right sub-tree

Provides search, insert, delete in log time

Iteration: while the tree is not empty, find the value
if val < root.val, search the left sub tree, else seach the right subtree

Recursion: if the tree is empty or we find the value, return the root
if val < root.val go to the left subtree, else go to the right subtree

Dry Run
       2
    1    33
       25  40
     11   34
    7 12    36
       13
Find 12
2 < 12, go to the right subtree
33 > 12, go to the left sub tree
11 < 12, go to the right subtree
12 == 12, return root

Time: O(h) where h is a tree height. O(log h) average case and O(h) worst case
Space: O(h) height of the tree, O (log h) average case and O(h) worse case
*/