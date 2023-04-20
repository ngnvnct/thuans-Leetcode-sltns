import unittest

class Solution:
    @staticmethod
    def maxProfit(prices):
        minimum, true_max = 1e8, 0
        for price in prices:
            minimum = min(price, minimum)
            local_max = price - minimum
            true_max = max(local_max, true_max)
        return true_max

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [7,1,5,3,6,4]
        self.testCase1ExpectedResult = 5

        self.testCase2 = [7,6,4,3,1]
        self.testCase2ExpectedResult = 0
    
    def testMaxProfit1(self):
        self.assertEqual(self.solution.maxProfit(self.testCase1), self.testCase1ExpectedResult)

    def testMaxProfit2(self):
        self.assertEqual(self.solution.maxProfit(self.testCase2), self.testCase2ExpectedResult)

if __name__ == "__main__":
    unittest.main()