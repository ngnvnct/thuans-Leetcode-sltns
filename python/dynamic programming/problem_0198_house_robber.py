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

        self.testCase1 = [1,2,3,1]
        self.testCase1ExpectedResult = 4

        self.testCase2 = [2,7,9,3,1]
        self.testCase2ExpectedResult = 12
    
    def testRob1(self):
        self.assertEqual(self.solution.rob(self.testCase1), self.testCase1ExpectedResult)
    def testRob2(self):
        self.assertEqual(self.solution.rob(self.testCase2), self.testCase2ExpectedResult)

if __name__ == "__main__":
    unittest.main()