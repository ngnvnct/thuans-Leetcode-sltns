public class diameter_binary_tree {
    int diameter;
    public int diamaterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = dfs(root.left);
        int rightPath = dfs(root.right);
        diameter = Math.max(diameter, leftPath+rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }
}


/*abstract
Explanation

Diamater of a binary tree if the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root
The length of a path between two nodes is represented by the number of edges between them

Gets a global variable diameter to keep track of the longest path
Do a dfs that recursively explore the entire tree. Once it is finished, it should return the longest path out of its left and right branches
If node is null, we have reached the end of the tree, return -
call dfs on left and right. In return, we get the longest path of its left and right
if left path plus right path is longer than the current diameter, update it
return the longer one and add 1 as the edge connecting it with its parent


   1
  2 3
4 5
Diamater: 3, 3 is the length of the path [4,2,1,3] or [5,2,1,3]
Possible follow up: print the path of the diameter

Time: O(n)
Space: O(n), call stack
*/