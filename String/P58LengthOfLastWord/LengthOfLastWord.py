import unittest
'''
Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Example 2:

Input: s = " "
Output: 0
'''
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        strArr = s.strip().split(" ")
        return 0 if len(strArr) == 0 else len(strArr[-1])
    
class UnitTest(unittest.TestCase):
    def test(self):
        s = "Hello World"
        self.assertEquals(5, Solution().lengthOfLastWord(s))
               
if __name__ == "__main__":
    unittest.main()