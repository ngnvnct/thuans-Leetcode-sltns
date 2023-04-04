import unittest

class Solution:
    @staticmethod
    def minWindow(s, t):
        hsh = {}                # keeping track of the characters in t and the frequency of the characters
        for c in t:
            if c not in hsh: 
                hsh[c] = 1
                continue
            hsh[c] += 1
        
        left, right = 0, 0      # bookends of our sliding window
        window = len(s)+1       # keeps track of the size of our smallest substring. starts at the biggest window it can be
        track = len(t)          # this will be the flag that will initiate the narrowing down of a substring
        sub = ""                # returned smallest substring
        
        while right < len(s):
            if s[right] in hsh:
                if hsh[s[right]] > 0: 
                    track -= 1
                hsh[s[right]] -= 1
            while track == 0:
                if (right-left+1) < window:
                    window = right-left+1
                    sub = s[left:right+1]
                if s[left] in hsh:
                    hsh[s[left]] += 1
                    if hsh[s[left]] > 0: 
                        track += 1
                left += 1
            right += 1
        return sub
"""
We store the frequency of letters in t in hsh. 
We use left and right pointers to indicate the bookends of our window/substring
Window is just used to check conditions
Track is set to the length of t. This will only decrement and increment when a letter that is in t is added or subtracted from hsh, a maximum of times that
it appears in t. In other words:
    t = abcc
    track = 4
    hsh = {a:1, b:1, c:2}
    s = aabbbcc
    The amount of a's in s > a's in t, but track will only decrement when going over one a, since only one a appears in t. That is why we must first check if 
    the count in hsh is greater than 0. If the count is below 0, then the count in s of that letter is considered extra and will not effect track
We only started reducing the window once track == 0, in other words, once all letters in t have been found in s.
Update window size and the substring that makes up that window
Starts reducing the window, only stopping once track is greater than 0, meaning the window is now missing some letter that is in t.
Time = O(m+n)
Space = O(n)
"""
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