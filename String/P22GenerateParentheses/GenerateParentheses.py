import unittest
from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def backtrack(res, str, left, right, n):
            if len(str) == 2*n:
                if left == n and right  == n:
                    res.append(str)
                return
            # left parenthese has higher priority
            if left < n:
                str += '('
                backtrack(res, str, left+1, right, n)
                str = str[:-1]
            if right < left:
                str += ')'
                backtrack(res, str, left, right+1, n)
                str = str[:-1]
        backtrack(res, "", 0, 0, n)
        return res


class UnitTest(unittest.TestCase):
    def test(self):
        n = 3
        self.assertEqual(["((()))","(()())","(())()","()(())","()()()"], Solution().generateParenthesis(n))
        
        n = 1
        self.assertEqual(["()"], Solution().generateParenthesis(n))
if __name__ == "__main__":
    unittest.main()
        
        