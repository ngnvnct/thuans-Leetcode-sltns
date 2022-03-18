public class lowest_common_ancestor_bst {
    public TreeNode lcaRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lcaRecursive(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lcaRecursive(root.right, p, q);
        }
        return root;
    }

    public TreeNode lcaIterative(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }
}


/*
Explanation
BST properties:
Left subtree of a node N contains nodes whose values are lesser than or equal to node N's value.
Right subtree of a node N contains nodes whose values are greater than node N's value.
Both left and right subtrees are also BSTs.


The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
that has both p and q as descendants (where we allow a node to be a descendant of itself

Recursive
Start traversing the tree from the root node.
If both the nodes p and q are in the right subtree, then continue the search with right subtree starting step 1.
If both the nodes p and q are in the left subtree, then continue the search with left subtree starting step 1.
If both step 2 and step 3 are not true, this means we have found the node which is common to node p's and q's subtrees. 
and hence we return this common node as the LCA.

Iterative
The only difference is instead of recursively calling the function, we traverse down the tree iteratively. 
This is possible without using a stack or recursion since we don't need to backtrace to find the LCA node. 
In essence of it the problem is iterative, it just wants us to find the split point. 
The point from where p and q won't be part of the same subtree or when one is the parent of the other

Time: when the BST is balanced, O(log h), when the BST is skewed, O(h) where h is the height of the tree
Space: O(1) for iterative, O(h) for the recursive
*/
