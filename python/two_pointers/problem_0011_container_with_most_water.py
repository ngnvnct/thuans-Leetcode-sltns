import unittest

class Solution:
    @staticmethod
    def maxArea(height):
        left, right, area = 0, len(height)-1, 0

        while left < right:
            length = min(height[left], height[right])
            width = right - left

            area = max(area, length*width)

            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        
        return area

"""
Two pointers method, one on the left end of the array (i) and the other on the right end of the array (n)
Bring the pointers closer, keeping track of the area between the two pointers.
The height of the box will always be the minimum col height between the two of height[i] and height[n]
Width of the box is just the index distance between the two pointers
Keep track of the biggest area we encounter, so we only want to replace the area value if w*l is greater than the previous area value that we recorded
Lastly, we want to "get rid of" the smaller of the two heights and keep the bigger column or end. If the left col was shorter than the right, increment left pointer and vice versa
Doing this, we hope to find another column that is taller and hopefully leads to a bigger area.
Time = O(n) linear. Increment through the array once 
Space = O(1) no additional arrays needed to be created
"""

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [1,8,6,2,5,4,8,3,7]
        self.testCase1ExpectedResult = 49

        self.testCase2 = [1,1]
        self.testCase2ExpectedResult = 1

    def testMaxArea1(self):
        self.assertEqual(self.solution.maxArea(self.testCase1), self.testCase1ExpectedResult)

    def testMaxArea2(self):
        self.assertEqual(self.solution.maxArea(self.testCase2), self.testCase2ExpectedResult)

if __name__ == "__main__":
    unittest.main()