import unittest

class Solution:
    @staticmethod
    def threeSum(nums):
        ans = set()
        nums.sort()
        for left in range(len(nums)):
            mid, right = left+1, len(nums)-1
            while mid < right:
                sum = nums[left] + nums[mid] + nums[right]
                if sum < 0:
                    mid += 1
                elif sum > 0:
                    right -= 1
                else:
                    ans.add(tuple((nums[left], nums[mid], nums[right])))
                    mid += 1
                    right -= 1
        return ans
    
class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [-1,0,1,2,-1,-4]
        self.testCase1ExpectedResult = [[-1,-1,2], [-1,0,1]]

        self.testCase2 = [0,1,1]
        self.testCase2ExpectedResult = []

        self.testCase3 = [0,0,0]
        self.testCase3ExpectedResult = [[0,0,0]]

    def testThreeSum1(self):
        self.assertEqual(self.solution.threeSum(self.testCase1), self.testCase1ExpectedResult)
    def testThreeSum2(self):
        self.assertEqual(self.solution.threeSum(self.testCase2), self.testCase2ExpectedResult)
    def testThreeSum3(self):
        self.assertEqual(self.solution.threeSum(self.testCase3), self.testCase3ExpectedResult)

if __name__ == "__main__":
    unittest.main()