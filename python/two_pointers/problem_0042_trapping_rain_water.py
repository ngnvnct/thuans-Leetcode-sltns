import unittest

class Solution:
    @staticmethod
    def trap(height):
        left, right = 0, len(height)-1
        highest_left, highest_right = 0, 0
        ans = 0
        while left < right:
            if height[left] < height[right]:
                if height[left] >= highest_left:
                    highest_left = height[left]
                else:
                    ans += (highest_left - height[left])
                left += 1
            else:
                if height[right] >= highest_right:
                    highest_right = height[right]
                else:
                    ans += (highest_right - height[right])
                right -= 1
        return ans

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [0,1,0,2,1,0,1,3,2,1,2,1]
        """
                     |_|
             |_|# # #|_|_|#|_|
         |_|#|_|_|#|_|_|_|_|_|_|
        """
        self.testCase1ExpectedResult = 6

        self.testCase2 = [4,2,0,3,2,5]
        """
                  |_|
        |_|# # # #|_|
        |_|# #|_|#|_|
        |_|_|#|_|_|_|
        |_|_|#|_|_|_|
        """
        self.testCase2ExpectedResult = 9

    def testTrap1(self):
        self.assertEqual(self.solution.trap(self.testCase1), self.testCase1ExpectedResult)

    def testTrap2(self):
        self.assertEqual(self.solution.trap(self.testCase2), self.testCase2ExpectedResult)

if __name__ == "__main__":
    unittest.main()

