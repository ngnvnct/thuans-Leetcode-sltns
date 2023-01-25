/*
 * https://leetcode.com/problems/island-perimeter/
 * Explanation:
 * 
 * Similar to https://leetcode.com/problems/number-of-islands/
 * 
 * This is a Graph problem, which can be solve using Depth First Search (DFS) or
 * BFS. DFS will be used here. First, we have a constraint if the length is 0 or
 * it is null, return 0
 * then we want to loop through the grid row and columns, and if we encounter a
 * 1, we want to do something with it. In this case, we will call dfs to check
 * for perimeter
 * 
 * In our DFS call, we want to have a constraint check, if it is out of bound or
 * we encounter a 0, we want to return 1
 * else, we mark each visited 0 with a -1 so we don't revisit it again, then we
 * call the dfs stack going down, up, to the left and to the right, trying to
 * get to the base case, and add it to our perimeter
 * 
 * Time: O(MN)
 * Space: O(1)
 */
package graph;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_0463_island_perimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        int perimeter = 0;
        if (grid[i][j] == -1) {
            return 0;
        }
        grid[i][j] = -1;
        perimeter += dfs(grid, i + 1, j);
        perimeter += dfs(grid, i - 1, j);
        perimeter += dfs(grid, i, j + 1);
        perimeter += dfs(grid, i, j - 1);
        return perimeter;
    }

    @Test
    public void testPerimeter() {
        int[][] testCase1 = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        int testCase1ExpectedResult = 16;
        int[][] testCase2 = { { 1 } };
        int testCase2ExpectedResult = 4;
        int[][] testCase3 = { { 1, 0 } };
        int testCase3ExpectedResult = 4;

        assertEquals(testCase1ExpectedResult, islandPerimeter(testCase1));
        assertEquals(testCase2ExpectedResult, islandPerimeter(testCase2));
        assertEquals(testCase3ExpectedResult, islandPerimeter(testCase3));
    }
}