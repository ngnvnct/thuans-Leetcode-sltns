import unittest

class Solution:
    @staticmethod
    def majorityElement(nums):
        minimum = len(nums) / 3
        hsh = {}
        for num in nums:
            if num not in hsh:
                hsh[num] = 1
                continue
            hsh[num] += 1

        ans = []
        for key in hsh.keys():
            if hsh[key] > minimum:
                ans.append(key)
        
        return ans
    
class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = [3,2,3]
        self.testCase1ExpectedResult = [3]

        self.testCase2 = [1]
        self.testCase2ExpectedResult = [1]

        self.testCase3 = [1,2]
        self.testCase3ExpectedResult = [1,2]

    def testMajorityElement1(self):
        self.assertEqual(self.solution.majorityElement(self.testCase1), self.testCase1ExpectedResult)
    def testMajorityElement2(self):
        self.assertEqual(self.solution.majorityElement(self.testCase2), self.testCase2ExpectedResult)
    def testMajorityElement3(self):
        self.assertEqual(self.solution.majorityElement(self.testCase3), self.testCase3ExpectedResult)

if __name__ == "__main__":
    unittest.main()