import unittest

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        if len(s) == 0:
            return res
        else:
            seen, start, idx = {}, 0, 0
            while idx < len(s):
                if s[idx] in seen:
                    seen[s[idx]] += 1
                    while seen[s[idx]] > 1:
                        # move start pointer
                        seen[s[start]] -=1
                        start +=1
                else:
                    seen[s[idx]] = 1
                res = max(res, idx - start + 1)
                idx +=1
            return res
                    
                
                
        
class UnitTest(unittest.TestCase):
    def test_1(self):
        s = "abcabcbb"
        self.assertEqual(3, Solution().lengthOfLongestSubstring(s))

        s = "bbbbb"
        self.assertEqual(1, Solution().lengthOfLongestSubstring(s))

        s = "pwwkew"
        self.assertEqual(3, Solution().lengthOfLongestSubstring(s))

        s = ""
        self.assertEquals(0, Solution().lengthOfLongestSubstring(s))

if __name__ == "__main__":
    unittest.main() 