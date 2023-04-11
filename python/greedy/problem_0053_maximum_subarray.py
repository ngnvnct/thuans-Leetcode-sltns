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

    def testMaxSubArray1(self):
        self.testCase1 = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        self.testCase1ExpectedResult = 6
        self.assertEqual(self.solution.maxSubArray(self.testCase1), self.testCase1ExpectedResult)

    def testMaxSubArray2(self):
        self.testCase2 = [1]
        self.testCase2ExpectedResult = 1
        self.assertEqual(self.solution.maxSubArray(self.testCase2), self.testCase2ExpectedResult)

    def testMaxSubArray3(self):
        self.testCase3 = [5, 4, -1, 7, 8]
        self.testCase3ExpectedResult = 23
        self.assertEqual(self.solution.maxSubArray(self.testCase3), self.testCase3ExpectedResult)

    def testMaxSubArray4(self):
        self.testCase4 = [-1, -2, -3, -4, -5]
        self.testCase4ExpectedResult = -1
        self.assertEqual(self.solution.maxSubArray(self.testCase4), self.testCase4ExpectedResult)

    def testMaxSubArray5(self):
        self.testCase5 = [0, 0, 0, 0, 0]
        self.testCase5ExpectedResult = 0
        self.assertEqual(self.solution.maxSubArray(self.testCase5), self.testCase5ExpectedResult)

    def testMaxSubArray6(self):
        self.testCase6 = [-2, -3, -1, -5]
        self.testCase6ExpectedResult = -1
        self.assertEqual(self.solution.maxSubArray(self.testCase6), self.testCase6ExpectedResult)


if __name__ == "__main__":
    unittest.main()
