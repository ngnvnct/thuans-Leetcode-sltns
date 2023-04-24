import unittest
from collections import Counter

class Solution:
    @staticmethod
    def characterReplacement(s, k):
        left, longest, count = 0, 0, Counter()      # count is our hashmap to keep track of the frequency of certain characters. using collections library for this but pretty simple to implement without the library
        for right, c in enumerate(s):
            count[c] += 1       # keep count of the letters that we encounter. the most frequent letter in any given window will be what we are trying to change the other letters to
            while left < right and (right-left+1-max(count.values()) > k):  # want to reduce the window until the amount of letters different from the most frequent letter is less than k. once that is done, we are able to use our k amount of letter changes to create a string of repeating characters made up of the most frequent letter
                count[s[left]] -= 1
                left += 1
            longest = max(longest, right-left+1)
        return longest

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = "ABAB"
        self.testCase1k = 2
        self.testCase1ExpectedResult = 4

        self.testCase2 = "AABABBA"
        self.testCase2k = 1
        self.testCase2ExpectedResult = 4
    
    def testCharacterReplacement1(self):
        self.assertEqual(self.solution.characterReplacement(self.testCase1, self.testCase1k), self.testCase1ExpectedResult)
    
    def testCharacterReplacement2(self):
        self.assertEqual(self.solution.characterReplacement(self.testCase2, self.testCase2k), self.testCase2ExpectedResult)

if __name__ == "__main__":
    unittest.main()