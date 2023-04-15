import unittest


class Solution:
    @staticmethod
    def threeSum(nums):
        nums.sort()
        ans = []
        for left in range(len(nums)):
            if left > 0 and nums[left] == nums[left-1]:
                continue
            mid, right = left+1, len(nums)-1
            while mid < right:
                sum = nums[left] + nums[mid] + nums[right]
                # moves the mid and right pointers in to get closer to 0 based on certain conditions
                if sum < 0:
                    mid += 1
                    continue
                elif sum > 0:
                    right -= 1
                    continue
                # once the sum is 0, do this stuff
                ans.append([nums[left], nums[mid], nums[right]])
                # to avoid duplicates, move the pointers in to skip duplicate entries
                while mid > right and nums[mid] == nums[mid+1]:
                    mid += 1
                while left < right and nums[right] == nums[right-1]:
                    right -= 1
                mid += 1
                right -= 1

        return list(ans)


class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [-1, 0, 1, 2, -1, -4]
        self.testCase1ExpectedResult = [[-1, -1, 2], [-1, 0, 1]]

        self.testCase2 = [0, 1, 1]
        self.testCase2ExpectedResult = []

        self.testCase3 = [0, 0, 0]
        self.testCase3ExpectedResult = [[0, 0, 0]]

    def testThreeSum1(self):
        self.assertEqual(self.solution.threeSum(
            self.testCase1), self.testCase1ExpectedResult)

    def testThreeSum2(self):
        self.assertEqual(self.solution.threeSum(
            self.testCase2), self.testCase2ExpectedResult)

    def testThreeSum3(self):
        self.assertEqual(self.solution.threeSum(
            self.testCase3), self.testCase3ExpectedResult)


if __name__ == "__main__":
    unittest.main()