import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class problem_0314_binary_tree_vertical_order_traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Integer> cols = new ArrayDeque<>();

        queue.addLast(root);
        cols.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            int currCol = cols.poll();

            map.putIfAbsent(currCol, new ArrayList<>());
            // if (!map.containsKey(currCol)) {
            // map.put(currCol, new ArrayList<>());
            // }
            map.get(currCol).add(node.val);

            if (node.left != null) {
                queue.addLast(node.left);
                cols.add(currCol - 1);
            }
            if (node.right != null) {
                queue.addLast(node.right);
                cols.add(currCol + 1);
            }
        }
        return new ArrayList<>(map.values());
    }
}

/*
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * Explanation:
 * 
 * Using BFS, if a node is at level N in the final result, its left child must
 * exist in level N - 1, and right child must exist in N + 1
 * Use a queue to store the queue and the current col
 * 
 * If it is the left child, the currCol-1, right child currCol + 1
 * -3 -2 -1 0 1 2
 * 2
 * 9 8
 * 4 1 7
 * 3 11 5
 * 
 * Our tree map (using tree map to keep the key in sorted order) to keep track
 * of the Vertical Level
 * 
 * Time: O(n)
 * Space: O(n)
 */