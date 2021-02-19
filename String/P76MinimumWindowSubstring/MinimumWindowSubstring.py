'''
Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"
'''
import unittest
from collections import defaultdict


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        count_map = defaultdict(int)
        res, left, right, counter, minlen, idx = "", 0, 0, 0, len(s), -1
        for c in t:
            count_map[c] +=1
        while right < len(s):
            if s[right] in count_map:
                if count_map[s[right]] > 0:
                    counter += 1
                count_map[s[right]] -= 1
                    
            while counter == len(t):
                # need to move left    
                if right - left  + 1 <= minlen:
                    minlen = right - left + 1
                    idx = left
                if s[left] in count_map:
                    count_map[s[left]] += 1
                    if count_map[s[left]] > 0:
                        counter -= 1
                left += 1
            right += 1
        return "" if idx == -1 else s[idx:idx + minlen]
            

class UnitTest(unittest.TestCase):
    def test(self):
        s = "ADOBECODEBANC"
        t = "ABC"
        self.assertEqual("BANC", Solution().minWindow(s,t))
        
if __name__ == "__main__":
    unittest.main()