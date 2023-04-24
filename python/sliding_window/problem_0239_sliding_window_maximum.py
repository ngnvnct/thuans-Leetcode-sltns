import unittest
from collections import deque

class Solution:
    @staticmethod
    def maxSlidingWindow(nums, k):
        q, ans = deque(), []

        # indices will be appended to q (nums[q[i]] == the element in nums at i index)
        # using a monotonic stack/deque to find the local max num value
        for i, num in enumerate(nums):
            while q and nums[q[-1]] <= num:     # removes the latest element if it is less than or equal to the current element in nums. keeps the greatest number in our sliding window as the first element of q
                q.pop()
            q.append(i)
            if q[0] == i-k:         # removes the leftmost element to maintain a sliding window of size k. q[0] would point to an index that is outside (to the left) of our k window this is done in case the newly encountered num is less than nums[q[0]] but would still be the local max of the sliding window that just moved away from where q[0] pointed to
                q.popleft()
            if i >= k-1:            # only start appending to ans only once we have established a window of size k
                ans.append(nums[q[0]])
        
        return ans

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [1,3,-1,-3,5,3,6,7]
        self.testCase1k = 3
        self.testCase1ExpectedResult = [3,3,5,5,6,7]

        self.testCase2 = [1]
        self.testCase2k = 1
        self.testCase2ExpectedResult = [1]
    
    def testMaxSlidingWindow1(self):
        self.assertEqual(self.solution.maxSlidingWindow(self.testCase1, self.testCase1k), self.testCase1ExpectedResult)

    def testMaxSlidingWindow2(self):
        self.assertEqual(self.solution.maxSlidingWindow(self.testCase2, self.testCase2k), self.testCase2ExpectedResult)

if __name__ == "__main__":
    unittest.main()