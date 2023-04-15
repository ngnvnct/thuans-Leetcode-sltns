import unittest

class Solution:
    @staticmethod
    def threeSumClosest(nums, target):
        nums.sort()
        # diff will be the difference between the target int and the sum of the 3 summed up numbers
        # ans will be the returned answer, which is the sum of the 3 numbers that is closest to target
        diff, ans = 1e8, 1e8
        for left in range(len(nums)):
            mid, right, = left+1, len(nums)-1
            while mid < right:
                sum = nums[left] + nums[mid] + nums[right]
                # absolute value difference between the sum and target. important to use absolute value since it could miss an answer
                # i.e. sum = 4, target = 6, diff = -2 // sum = 7, target = 6, diff = 1. but since -2 < 1, the returned answer will be 4 even though it's wrong
                if abs(target-sum) < diff:
                    diff = abs(target-sum)
                    ans = sum                
                # narrows down the 3 numbers to get closer to the target depending on conditions
                if sum > target:
                    right -= 1
                elif sum < target:
                    mid += 1
                else:
                    right -= 1
                    mid += 1
        return ans

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [-1,2,1,-4]
        self.testCase1Target = 1
        self.testCase1ExpectedResult = 2

        self.testCase2 = [0,0,0]
        self.testCase2Target = 1
        self.testCase2ExpectedResult = 0
    
    def testThreeSumClosest1(self):
        self.assertEqual(self.solution.threeSumClosest(self.testCase1, self.testCase1Target), self.testCase1ExpectedResult)
    
    def testThreeSumClosest2(self):
        self.assertEqual(self.solution.threeSumClosest(self.testCase2, self.testCase2Target), self.testCase2ExpectedResult)

if __name__ == "__main__":
    unittest.main()