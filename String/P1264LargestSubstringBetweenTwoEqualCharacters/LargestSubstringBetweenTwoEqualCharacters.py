import unittest

class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        dict,res  = {}, -1
        for i in range(len(s)):
            if s[i] not in dict:
                dict[s[i]] = []
            dict[s[i]].append(i)
        for key, value in dict.items():
            print(value)
            if len(value) <= 1:
                continue
            res = max(res, value[len(value)-1] - value[0] - 1)
        return res

class UnitTest(unittest.TestCase):
    def test(self):
        s = "abca"
        self.assertEqual(2, Solution().maxLengthBetweenEqualCharacters(s))
if __name__ == "__main__":
    unittest.main()