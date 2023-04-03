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

        # nested for loop for filling in the inner cells. since there are only 2 places we can arrive at this cell from (from above or from the left) then the minimum value between above and left will be the minimum path. the min value is added to the current cell 
        for row in range(1, rows):
            for col in range(1, cols):
                grid[row][col] += min(grid[row-1][col], grid[row][col-1])
        
        return grid[-1][-1]
    
"""
We don't need to keep track of any old values in grid, so doing in place dp will be nice to make it space optimized. 
Since you can only arrive to cells from either above or from the left, the cells in the very top row and leftmost column only have one possible place that a "pointer" can come from. Because of this, we can just sum up the values in those cells travelling in one direction to start before working on the inner cells.

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