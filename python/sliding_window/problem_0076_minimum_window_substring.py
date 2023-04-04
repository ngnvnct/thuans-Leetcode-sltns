import unittest

class Solution:
    @staticmethod
    def minWindow(s, t):
        hsh = {}
        # building our hashmap of characters in t and amount of them to keep track of. 
        for char in t:
            if char not in hsh:
                hsh[char] = 1
                continue
            hsh[char] += 1
        
        # left and right are the bookends to our sliding window. 
        left, right = 0, 0
        # "window" will be the value that our sliding window denoted by left and right will have to be lower than after certain conditions are fulfilled i.e. basically keeps track of the size of our answer
        window = len(s)+1
        # track will be our flag to check our substring starting from left and ending at right.
        track = len(t)
        # keeps track of our smallest substring that is encountered
        sub = ""

        while right < len(s):
            if s[right] in hsh:
                if hsh[s[right]] > 0: 
                    track -= 1
                hsh[s[right]] -= 1
            
            while track == 0:
                if (right - left + 1) < window:
                    window = right - left + 1
                    sub = s[left:right+1]
                
                if s[left] in hsh:
                    hsh[s[left]] += 1
                    if hsh[s[left]] > 0:
                        track += 1
                left += 1
            right += 1

        return sub
    
class TestCase(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def testMinWindow1(self):
        self.testCase1s = "ADOBECODEBANC"
        self.testCase1t = "ABC"
        self.testCase1ExpectedResult = "BANC"
        self.assertEqual(self.solution.minWindow(self.testCase1s, self.testCase1t), self.testCase1ExpectedResult)

    def testMinWindow2(self):
        self.testCase2s = "a"
        self.testCase2t = "a"
        self.testCase2ExpectedResult = "a"
        self.assertEqual(self.solution.minWindow(self.testCase2s, self.testCase2t), self.testCase2ExpectedResult)
        
    def testMinWindow3(self):
        self.testCase3s = "a"
        self.testCase3t = "aa"
        self.testCase3ExpectedResult = ""
        self.assertEqual(self.solution.minWindow(self.testCase3s, self.testCase3t), self.testCase3ExpectedResult)

if __name__ == "__main__":
    unittest.main()