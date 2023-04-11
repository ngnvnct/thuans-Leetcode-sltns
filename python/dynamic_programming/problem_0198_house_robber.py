import unittest

class Solution:
    @staticmethod
    def rob(nums):
        if len(nums) <= 2:
            return max(nums)
        dp = [nums[0], nums[1]]
        for i in range(2, len(nums)):
            dp.append(nums[i] + max(dp[:-1]))
        return max(dp[-1], dp[-2])

"""
Bottom up tabulation dp.

Edge cases were basically what should we do when we encounter a house denoted with 0?
Taking the max of the dp array excluding the most recent addition will assure that we don't hit the "0 house" while still excluding the immediately adjacent house. 

Time complexity = O(n) tabulation dp. Only have to iterate through the array once
Space = O(n) We have to make a completely separate dp array.
"""

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
    
    def testRob1(self):
        self.testCase1 = [1,2,3,1]
        self.testCase1ExpectedResult = 4
        self.assertEqual(self.solution.rob(self.testCase1), self.testCase1ExpectedResult)
    def testRob2(self):
        self.testCase2 = [2,7,9,3,1]
        self.testCase2ExpectedResult = 12
        self.assertEqual(self.solution.rob(self.testCase2), self.testCase2ExpectedResult)
        
    def testRob3(self):
        self.testCase3 = [2, 1, 1, 2]
        self.testCase3ExpectedResult = 4
        self.assertEqual(self.solution.rob(self.testCase3), self.testCase3ExpectedResult)

    def testRob4(self):
        self.testCase4 = [1, 1, 1, 1, 1, 1, 1]
        self.testCase4ExpectedResult = 4
        self.assertEqual(self.solution.rob(self.testCase4), self.testCase4ExpectedResult)

    def testRob5(self):
        self.testCase5 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        self.testCase5ExpectedResult = 30
        self.assertEqual(self.solution.rob(self.testCase5), self.testCase5ExpectedResult)

if __name__ == "__main__":
    unittest.main()