import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Lowest_Common_Ancestor_Of_A_Binary_Tree_236 {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return (left != null) ? left : right;
        }
    }

    public TreeNode lca2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lca2(root.left, p, q);
        TreeNode right = lca2(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }

    public TreeNode lcaIterative(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root, null);
        queue.add(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node != null) {
                parent.put(node.left, node);
                parent.put(node.right, node);
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        Set<TreeNode> set = new HashSet<>();

        while (p != null) {
            set.add(p);
            p = parent.get(p);
        }

        while (!set.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Explanation
 * 
 * Traverse the tree in Depth first, the moment i encounter p or q, return some
 * boolean flag.
 * Base case, we find p or q or touch the ground, return the root
 * 
 * Then we search p and q from left and right
 * From the root's left & right we found both p and q, so the root is the LCA
 * Left is not null means from the left's left and right we found both p and q
 * so the left is the lca, otherwise it is the right
 * 
 * Time: O(n)
 * Space: O(n)
 */