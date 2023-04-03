import unittest

class Solution:
    @staticmethod
    def rob(nums):
        # since the first and last houses are adjacent (due to being arranged in a circle), all houses will be adjacent to each other if there are 3 or less houses. we can only rob one house
        if len(nums) <= 3:
            return max(nums)
        
        # dp array starting at the first house (nums[0])
        start0 = [nums[0], nums[1]]
        for i in range(2, len(nums)-1): # excludes the very last house since it would be adjacent to the starting house (nums[0])
            start0.append(nums[i] + max(start0[:-1])) # use [:-1] to exclude the immediately adjacent house

        # dp array starting at the second house (nums[1])
        start1 = [nums[1], nums[2]]
        for i in range(3, len(nums)): # excludes first house (nums[0]) but now includes the very last house
            start1.append(nums[i] + max(start1[:-1]))

        return max(start0[-1], start0[-2], start1[-1], start1[-2])
    
"""
Basically the same as House Robber 1 but done twice to account for different starting points.
Since the last house is the neighbor of the first house, we go through the array twice, one which hits the 
very first house but excludes the last house. The other which starts on the second house but hits the very last house.
After setting up those parameters, proceed as normal like in House Robber 1. 

Time = O(n) linear dp. Iterate through the array once. Technically O(2n) 🤓
Space = O(n) for the two extra arrays. Technically O(2n)
"""
    
class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [2,3,2]
        self.testCase1ExpectedResult = 3

        self.testCase2 = [1,2,3,1]
        self.testCase2ExpectedResult = 4

        self.testCase3 = [1,2,3]
        self.testCase3ExpectedResult = 3

    def testRob1(self):
        self.assertEqual(self.solution.rob(self.testCase1), self.testCase1ExpectedResult)
    def testRob2(self):
        self.assertEqual(self.solution.rob(self.testCase2), self.testCase2ExpectedResult)
    def testRob3(self):
        self.assertEqual(self.solution.rob(self.testCase3), self.testCase3ExpectedResult)

if __name__ == "__main__":
    unittest.main()