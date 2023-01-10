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
        self.testCaseA = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        self.testCaseAExpected = 6
        self.testCaseB = [1]
        self.testCaseBExpected = 1
        self.testCaseC = [5, 4, -1, 7, 8]
        self.testCaseCExpected = 23

    def testCaseA(self):
        self.assertEqual(self.solution.maxSubArray(self.testCaseA), self.testCaseAExpected)

    def testCaseB(self):
        self.assertEqual(self.solution.maxSubArray(self.testCaseB), self.testCaseBExpected)

    def testCaseC(self):
        self.assertEqual(self.solution.maxSubArray(self.testCaseC), self.testCaseCExpected)


if __name__ == "__main__":
    unittest.main()
