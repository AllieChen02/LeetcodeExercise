import unittest
from typing import List

class Solution:
    def numSubarraysWithSum(self, A: List[int], S: int) -> int:
        # use an array to record presum
        arr, presum, res = {}, 0, 0
        for num in A:
            presum += num
            if presum - S in arr:
                res += arr[presum - S]
            if presum == S:
                res += 1
            if presum in arr:
                arr[presum] += 1
            else:
                arr[presum] = 1
        
        return res

class UnitTest(unittest.TestCase):
    def test_1(self):
        A, S = [1,0,1,0,1], 2
        self.assertEqual(4, Solution().numSubarraysWithSum(A,S))
        

if __name__ == "__main__":
    unittest.main()