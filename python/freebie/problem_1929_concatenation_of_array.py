import unittest

class Solution:
    @staticmethod
    def getConcatenation(nums):
        ans = []
        for i in range(len(nums)):
            ans.append(nums[i])
            ans.insert(i, nums[i])
        return ans

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()
        
        self.testCase1 = [1, 2, 1]
        self.testCase1ExpectedResult = [1, 2, 1, 1, 2, 1]

        self.testCase2 = [1, 2, 3, 3, 2, 1]
        self.testCase2ExpectedResult = [1, 2, 3, 3, 2, 1, 1, 2, 3, 3, 2, 1]

    def testSolutionA(self):
        self.assertEqual(self.solution.getConcatenation(self.testCase1), self.testCase1ExpectedResult)

    def testSolutionB(self):
        self.assertEqual(self.solution.getConcatenation(self.testCase2), self.testCase2ExpectedResult)

    def testSolutionC(self):
        self.assertFalse(self.solution.getConcatenation([]))

if __name__ == "__main__":
    unittest.main()


