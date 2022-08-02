import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.remove();
                if (i == level - 1) {
                    res.add(root.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return res;
    }
}

/*
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Explanation
 * 
 * We are going to use BFS here with one queue
 * get the queue and add the root, while the queue is not empty
 * get the current level length
 * and iterate from i to level length -1, pop the current node from hte queue
 * if i == level length -1, then it is the last node in the current level, push
 * it to the result
 * we have to ADD left first and then right child
 * 
 * root: [1,2,3,null,5,null,4]
 * queue: [1,2,3,null,5,null,4]
 * res: [1]
 * queue: [2,null,5], [3,null,4]
 * queue: [3,null,4]
 * res: [1,3]
 * queue [[5], [4]]
 * 
 * 
 * Time: O(n), visit each node
 * Space: O(D) to keep the queues, D is the tree diamater
 */