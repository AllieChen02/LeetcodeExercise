import unittest

class Solution:
    def countDistinct(self, s: str) -> int:
        trie = {}
        res = 0
        for i in range(len(s)):
            root = trie
            for j in range(i, len(s)):
                if s[j] not in root:
                    res += 1
                    root[s[j]] = {}
                root = root[s[j]]
        return res


class UnitTest(unittest.TestCase):
    def test(self):
        s = "aabbaba"
        self.assertEqual(21, Solution().countDistinct(s))
if __name__ == "__main__":
    unittest.main()