import unittest
from typing import List
'''
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

'''
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        zipped = list(zip(*strs))
        res = ""
        # [(f,f,f), (l,l,i), (o,o,i), (w,w,g), (e, ,h), (r, ,t)]
        for c in zipped:
            if len(set(c)) == 1:
                res += c[0]
            else:
                break
        return res

    def longestCommonPrefix_1(self, strs: List[str]) -> str:
        if strs == None or len(strs) == 0: 
            return ""
        for i in range(len(strs[0])):
            c = strs[0][i]
            for j in range(1, len(strs)):
                s = strs[j]
                if i == len(s) or c != s[i]:
                    return strs[0][:i]
        return strs[0] if strs else ""

class UnitTest(unittest.TestCase):
    def test(self):
        strs = ["flower","flow","flight"]
        self.assertEqual("fl", Solution().longestCommonPrefix(strs))
        self.assertEqual("fl", Solution().longestCommonPrefix_1(strs))
        
if __name__ == "__main__":
    unittest.main()
                
            