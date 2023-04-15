import unittest


class Solution:
    @staticmethod
    def twoSum(numbers, target):
        left, right = 0, len(numbers)-1
        while left < right:
            res = numbers[left] + numbers[right]
            if res == target:
                return [left+1, right+1]
            if res < target:
                left += 1
            else:
                right -= 1


class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [2, 7, 11, 15]
        self.testCase1Target = 9
        self.testCase1ExpectedResult = [1, 2]

        self.testCase2 = [2, 3, 4]
        self.testCase2Target = 6
        self.testCase2ExpectedResult = [1, 3]

        self.testCase3 = [-1, 0]
        self.testCase3Target = -1
        self.testCase3ExpectedResult = [1, 2]

    def testTwoSum1(self):
        self.assertEqual(self.solution.twoSum(
            self.testCase1, self.testCase1Target), self.testCase1ExpectedResult)

    def testTwoSu21(self):
        self.assertEqual(self.solution.twoSum(
            self.testCase2, self.testCase2Target), self.testCase2ExpectedResult)

    def testTwoSum3(self):
        self.assertEqual(self.solution.twoSum(
            self.testCase3, self.testCase3Target), self.testCase3ExpectedResult)


if __name__ == "__main__":
    unittest.main()
