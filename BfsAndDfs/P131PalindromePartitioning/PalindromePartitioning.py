import unittest
from typing import List
'''
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
'''
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        if len(s) == 0:
            return res
        self.backtrack(s, res, [])
        return res
    
    def backtrack(self, s, res, temp):
        if not s:
            res.append(temp)
            return
        for i in range(1, len(s) + 1):
            str1 = s[:i]
            if self.isPalindrome(str1):
                self.backtrack(s[i:], res, temp + [str1])
            
            
    
    def isPalindrome(self, s):
        left, right = 0, len(s) - 1
        while left <= right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True  
    
    # better way
    def isPalindrome_1(self, s):
        return s == s[::-1]    

class UnitTest(unittest.TestCase):
    def test(self):
        s = "aab"
        self.assertEqual([["a","a","b"],["aa","b"]], Solution().partition(s))
if __name__ == "__main__":
    unittest.main()