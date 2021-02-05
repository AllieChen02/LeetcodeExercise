import unittest
from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if digits is None or len(digits) == 0:
            return []
        res = [""]
        alph = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        def combine(res, str):
            temp = []
            for i in range(0, len(str)):
                for j in range(0, len(res)):
                    temp.append(res[j] + str[i])
            return temp
        for digit in digits:
            res = combine(res, alph[int(digit)])
        return res


class UnitTest(unittest.TestCase):
    def test(self):
        digits = "23"
        self.assertEqual(["ad","ae","af","bd","be","bf","cd","ce","cf"], Solution().letterCombinations(digits))
        
if __name__ == "__main__":
    unittest.main()