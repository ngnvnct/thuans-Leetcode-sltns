import unittest

class Solution:
    @staticmethod
    def maxSubArray(nums):
        locMax, curMax = 0, -1000000
        for num in nums:
            locMax = max(num, locMax + num)
            curMax = max(curMax, locMax)
        return curMax

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        
        self.testCase1 = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        self.testCase1ExpectedResult = 6

        self.testCase2 = [1]
        self.testCase2ExpectedResult = 1

        self.testCase3 = [5, 4, -1, 7, 8]
        self.testCase3ExpectedResult = 23

    def testMaxSubArray1(self):
        self.assertEqual(self.solution.maxSubArray(self.testCase1), self.testCase1ExpectedResult)

    def testMaxSubArray2(self):
        self.assertEqual(self.solution.maxSubArray(self.testCase2), self.testCase2ExpectedResult)

    def testMaxSubArray3(self):
        self.assertNotEqual(self.solution.maxSubArray(self.testCase3), self.testCase3ExpectedResult)


if __name__ == "__main__":
    unittest.main()
