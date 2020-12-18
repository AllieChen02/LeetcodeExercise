import unittest
from collections import deque
from typing import List

class Solution:
    def longestOnes(self, A: List[int], K: int) -> int:
        if not A or len(A) == 0:
            return 0
        length = len(A)
        start, end, zeroCount, res = 0, 0, 0, 0
        while end < length:
            if A[end] == 0:
                zeroCount += 1
            if zeroCount > K:
                if A[start] == 0:
                    zeroCount -= 1
                start += 1
            res = max(res, end - start + 1)
            end += 1
        return res
            

class UnitTest(unittest.TestCase):
    def test_1(self):
        K = 2
        A = [1,1,1,0,0,0,1,1,1,1,0]
        self.assertEqual(6, Solution().longestOnes(A, K))
        
        A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]
        K = 3
        self.assertEqual(10, Solution().longestOnes(A, K))
if __name__ == "__main__":
    unittest.main()