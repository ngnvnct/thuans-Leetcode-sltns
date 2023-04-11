/*
 * https://leetcode.com/problems/number-of-islands/
 * Explanation:
 * 
 * This is a Graph problem, which can be solve using Depth First Search (DFS) or
 * BFS. DFS will be used here. First, we have a constraint if the length is 0 or
 * it is null, return 0
 * then we want to loop through the grid row and columns, and if we encounter a
 * 1, we want to do something with it. In this case, we will call dfs to check
 * for number of islands
 * and add it to our final result.
 * 
 * In our DFS call, we want to have a constraint check, if it is out of bound or
 * we encounter a 0, we return 0
 * else, we mark each visited "1" with a "0" so we don't revisit it again, then
 * we call the dfs stack going down, up, to the left and to the right
 * 
 * Time: O(n)
 * Space: O(m * n) because of recursion stack
 */

package graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class problem_0200_number_of_islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islands = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    islands += dfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    public int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        return 1;
    }

    @Test
    public void testNumIslands() {
        char[][] testCase1 = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        assertEquals(1, numIslands(testCase1));

        char[][] testCase2 = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        assertEquals(3, numIslands(testCase2));

        char[][] testCase3 = {
                { '1', '1', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }
        };
        assertEquals(1, numIslands(testCase3));

        char[][] testCase4 = {
                { '0', '0', '0', '0', '0' },
                { '0', '0', '0', '0', '0' },
                { '0', '0', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        assertEquals(0, numIslands(testCase4));

        char[][] testCase5 = {
                { '1', '1', '1', '0', '0' },
                { '1', '0', '0', '1', '0' },
                { '1', '0', '0', '0', '1' },
                { '0', '0', '1', '1', '0' }
        };
        assertEquals(4, numIslands(testCase5));
    }
}