# LC says to modify in place and don't return anything. unittest doesn't work unless something is returned so we are returning nums back in this solution
import unittest

class Solution:
    @staticmethod
    def sortColors(nums):
        # zero_index keeps track of where the next 0 should be placed
        # two_index keeps track of where the next 2 should be placed
        # depending on what curr_index is, different things will happen
        zero_index, curr_index, two_index = 0, 0, len(nums)-1

        # want to use <= in order to cover all possible elements. we know that anything to the right of two_index (non inclusive) will be "locked" since they should all be 2's
        # but there is a chance that nums[two_index] could be a 0. if curr_index ends when curr_index == two_index, then nums will remain out of order at that index
        while curr_index <= two_index:
            if nums[curr_index] == 0:
                nums[zero_index], nums[curr_index] = nums[curr_index], nums[zero_index]
                # anything to the left of zero_index (non inclusive of nums[zero_index]) is "locked" since they should all be 0's
                zero_index += 1
                curr_index += 1
            elif nums[curr_index] == 1:
                # we are moving the 0's and 2's around the 1's once curr_index encounters them, so we don't have to do anything when curr_index goes over a 1
                curr_index += 1
            else:
                nums[two_index], nums[curr_index] = nums[curr_index], nums[two_index]
                # don't iterate curr_index here so that we can check the number that got switched to curr_index
                two_index -= 1
        return nums
"""
Time = O(n)
Space = O(1)
"""
class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [2,0,2,1,1,0]
        self.testCase1ExpectedResult = [0,0,1,1,2,2]

        self.testCase2 = [2,0,1]
        self.testCase2ExpectedResult = [0,1,2]
    
    def testSortColors1(self):
        self.assertEqual(self.solution.sortColors(self.testCase1), self.testCase1ExpectedResult)
    
    def testSortColors2(self):
        self.assertEqual(self.solution.sortColors(self.testCase2), self.testCase2ExpectedResult)

if __name__ == "__main__":
    unittest.main()