import unittest

class Solution:
    @staticmethod
    def lengthOfLongestSubstring(s):
        count = {}      # will keep track of the most recently encountered index of a certain character
        longest, left = 0, 0
        for right, c in enumerate(s):
            if c not in count:          # if c not in count then that means it is not a repeating character
                longest = max(longest, right-left+1)        # left and right are the bookends of the substring of interest
            else:
                if count[c] >= left:            # once a repeating character is encountered, check if the previous instance of that character is within our current substring
                    left = count[c] + 1         # if it is, then we move left to exclude the first instance, since our right pointer has encountered the next instance. right pointer will be the new sole appearance of this letter in our substring for now
                else:
                    longest = max(longest, right-left+1)    # if the previous instance of the letter is outside of our current substring, then the right pointer will still be pointing to the sole instance of that character in the current substring
            count[c] = right        # the key character will have a value of its most recently encountered index
        return longest

class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

        self.testCase1 = "abcabcbb"
        self.testCase1ExpectedResult = 3

        self.testCase2 = "bbbbb"
        self.testCase2ExpectedResult = 1

        self.testCase3 = "pwwkew"
        self.testCase3ExpectedResult = 3
    
    def testLengthOfLongestSubstring1(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring(self.testCase1), self.testCase1ExpectedResult)
    
    def testLengthOfLongestSubstring2(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring(self.testCase2), self.testCase2ExpectedResult)
    
    def testLengthOfLongestSubstring3(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring(self.testCase3), self.testCase3ExpectedResult)

if __name__ == "__main__":
    unittest.main()