import unittest


class Solution:
    @staticmethod
    def getConcatenation(nums):
        ans = []
        for i in range(len(nums)):
            ans.append(nums[i])
            ans.insert(i, nums[i])

        return ans


# class TestCase(unittest.TestCase):
#     def setUp(self):
#         self.solution = Solution()
#         self.testCaseA = [1, 2, 1]
#         self.testCaseAExpectedResult = [1, 2, 1, 1, 2, 1]
#         self.testCaseB = [1, 2, 3, 3, 2, 1]
#         self.testCaseBExpectedResult = [1, 2, 3, 3, 2, 1, 1, 2, 3, 3, 2, 1]
#
#     def testSolutionA(self):
#         self.assertEqual(self.solution.getConcatenation(self.testCaseA), self.testCaseAExpectedResult)
#
#     def testSolutionB(self):
#         self.assertEqual(self.solution.getConcatenation(self.testCaseB), self.testCaseBExpectedResult)
#
#     def testSolutionC(self):
#         self.assertFalse(self.solution.getConcatenation([]))


if __name__ == "__main__":
    # unittest.main()
    solution = Solution()
    print(solution.getConcatenation([1, 2, 1]))

