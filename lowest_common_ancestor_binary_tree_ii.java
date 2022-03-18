import java.util.HashSet;
import java.util.Set;

public class lowest_common_ancestor_binary_tree_ii {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        Set<Integer> found = new HashSet<>();
        TreeNode lca = dfs(root, p, q, found);
        return (found.size() == 2) ? lca : null;
    }
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q, Set<Integer> found) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left, p, q, found);
        TreeNode right = dfs(root.right, p, q, found);

        if (root.val == p.val || root.val == q.val) {
            found.add(root.val);
            return root;
        }

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }
}
