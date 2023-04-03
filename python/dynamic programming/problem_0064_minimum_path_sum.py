import unittest

class Solution:
    @staticmethod
    def minPathSum(grid):
        rows, cols = len(grid), len(grid[0])

        # sets up the top row and leftmost column since there is only one way to navigate to those cells (from the left or from above)
        for col in range(1, cols):
            grid[0][col] += grid[0][col-1]
        for row in range(1, rows):
            grid[row][0] += grid[row-1][0]

        # nested for loop for filling in the inner cells. since there are only two directions to come from for each cell, we keep track of what the cell's value would be when coming from above or from the left, and then replace it with the minimum of the two values. 
        for row in range(1, rows):
            for col in range(1, cols):
                from_above = grid[row][col] + grid[row-1][col]
                from_left = grid[row][col] + grid[row][col-1]
                grid[row][col] = min(from_above, from_left)
        
        return grid[-1][-1]
    
"""
We don't need to keep track of any old values in grid, so doing in place dp will be nice to make it space optimized. 
Since you can only arrive to cells from either above or from the left, the cells in the very top row and leftmost column only have one possible place that a "pointer" can come from. Because of this, we can just sum up the values in those cells to start before working on the inner cells.

Time = O(mn)
Space = O(1)
"""

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [[1,3,1],[1,5,1],[4,2,1]]
        self.testCase1ExpectedResult = 7

        self.testCase2 = [[1,2,3],[4,5,6]]
        self.testCase2ExpectedResult = 12

    def testMinPathSum1(self):
        self.assertEqual(self.solution.minPathSum(self.testCase1), self.testCase1ExpectedResult)

    def testMinPathSum2(self):
        self.assertEqual(self.solution.minPathSum(self.testCase2), self.testCase2ExpectedResult)

if __name__ == "__main__":
    unittest.main()