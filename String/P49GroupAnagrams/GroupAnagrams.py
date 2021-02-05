import unittest
from typing import List
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = defaultdict(dict)
        for s in strs:
            temp = s
            ch = sorted(list(s))
            sortedStr = "".join(ch)
            if sortedStr not in map:
                map[sortedStr] = []
            map[sortedStr].append(temp)
        res = []
        for value in map.values():
            res.append(value)
        return res

class UnitTest(unittest.TestCase):
    def test(self):
        strs = ["eat","tea","tan","ate","nat","bat"]
        self.assertEqual([["eat","tea","ate"],["tan","nat"],["bat"]], Solution().groupAnagrams(strs))
if __name__ == "__main__":
    unittest.main()