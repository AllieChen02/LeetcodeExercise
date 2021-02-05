import unittest

class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        if not s:
            return res
        
        for i in range(len(s)):
            s1 = expandFromCenter(s, i, i)
            s2 = expandFromCenter(s, i, i+1)
            temp = ""
            temp = s1 if len(s1) > len(s2) else s2
            res = temp if len(temp) > len(res) else res
        return res
        
def expandFromCenter(s, left, right):
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1
    return s[left+1 : right]                    

class UnitTest(unittest.TestCase):
    def test(self):
        s = "babad"
        self.assertEqual("bab", Solution().longestPalindrome(s))
        
        s = "cbbd"
        self.assertEqual("bb", Solution().longestPalindrome(s))

if __name__ == "__main__":
    unittest.main()