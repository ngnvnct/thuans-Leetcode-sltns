using NUnit.Framework;

namespace Island_Perimeter
{
    class Solution
    {
        public int IslandPerimeter(int[][] grid)
        {
            if (grid == null || grid.Length == 0)
            {
                return 0;
            }
            for (int i = 0; i < grid.Length; i++)
            {
                for (int j = 0; j < grid[0].Length; j++)
                {
                    if (grid[i][j] == 1)
                    {
                        return Dfs(grid, i, j);
                    }
                }
            }
            return 0;
        }
        private int Dfs(int[][] grid, int i, int j)
        {
            // above the grid, below the grid
            // left of the grid
            // right of the grid
            // if it is 0 we don't want to traverse it
            if (i < 0 || i >= grid.Length || j < 0 || j >= grid[i].Length || grid[i][j] == 0)
            {
                return 1;
            }
            int count = 0;
            if (grid[i][j] == -1)
            {
                return 0;
            }
            grid[i][j] = -1;
            // up, down, left and right of the index
            count += Dfs(grid, i + 1, j); //down
            count += Dfs(grid, i - 1, j);  // up
            count += Dfs(grid, i, j + 1); // neighbor to the right
            count += Dfs(grid, i, j - 1); // neighbor to the left
            return count;
        }
    }

    class Tests
    {
        Solution sol;
        [SetUp]
        public void SetUp()
        {
            sol = new Solution();
        }

        [Test]
        public void TestIslandPerimeter()
        {
            int[][] testCase1 = new int[][] { new int[] { 0, 1, 0, 0 }, new int[] { 1, 1, 1, 0 }, new int[] { 0, 1, 0, 0 }, new int[] { 1, 1, 0, 0 } };
            int testCase1ExpectedResult = 16;
            int[][] testCase2 = new int[][] { new int[] { 1 } };
            int testCase2ExpectedResult = 4;
            int[][] testCase3 = new int[][] { new int[] { 1, 0 } };
            int testCase3ExpectedResult = 4;

            Assert.AreEqual(testCase1ExpectedResult, sol.IslandPerimeter(testCase1));
            Assert.AreEqual(testCase2ExpectedResult, sol.IslandPerimeter(testCase2));
            Assert.AreEqual(testCase3ExpectedResult, sol.IslandPerimeter(testCase3));
        }
    }
}
