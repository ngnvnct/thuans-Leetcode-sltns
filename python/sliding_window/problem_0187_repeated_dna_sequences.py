import unittest

class Solution:
    @staticmethod
    def findRepeatedDnaSequences(s):
        seen, ans = set(), []

        for i in range(len(s)-9):   # s[n-9] is the highest index i can go to to ensure that the window of size 10 doesn't go off the string
            subarray = s[i:i+10]
            if subarray in seen and subarray not in ans:
                ans.append(subarray)
            seen.add(subarray)

        return list(ans)        # leetcode lets you just return ans as a set and it accepts it

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
        self.testCase1ExpectedResult = ["AAAAACCCCC","CCCCCAAAAA"]

        self.testCase2 = "AAAAAAAAAAAAA"
        self.testCase2ExpectedResult = ["AAAAAAAAAA"]
    
    def testFindRepeatedDnaSequences1(self):
        self.assertEqual(self.solution.findRepeatedDnaSequences(self.testCase1), self.testCase1ExpectedResult)
    
    def testFindRepeatedDnaSequences2(self):
        self.assertEqual(self.solution.findRepeatedDnaSequences(self.testCase2), self.testCase2ExpectedResult)

if __name__ == "__main__":
    unittest.main()