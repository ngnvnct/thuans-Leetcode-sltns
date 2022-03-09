import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class max_area_of_island {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfsFill(grid,i,j));
                }
            }
        }
        return max;        
    }
    public int dfsFill(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]==0){
            return 0;
        }
        grid[i][j]= 0;
        int count = 1;
        count += dfsFill(grid, i + 1, j);
        count += dfsFill(grid, i - 1, j);
        count += dfsFill(grid, i, j + 1);
        count += dfsFill(grid, i, j - 1);
        return count;
    }

    @Test
    public void testIsland() {
        int [][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int [][] grid2 = {{0,0,0,0,0,0,0,0}};
        assertEquals(6, maxAreaOfIsland(grid));
        assertEquals(0, maxAreaOfIsland(grid2));
    }
}

/*
Explanation

This one is similar to Number of Islands. If we see 1, we want to do something with it. For every cell grid we already visited, we mark it with 0, and make our count 1
then we call dfs on up, down, left, right, and increase our count. Then we return it

In our main loop, we take the maximum area that we've encounter.

Time: O(M*N) where M is number of row and N is number of column
Space: O(M*N)
*/