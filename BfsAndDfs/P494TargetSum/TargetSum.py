import unittest
from typing import List


        
class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        # dfs
        self.memo = {}
        def dfs(nums, idx, target):
            if idx == len(nums):
                return 1 if target == 0 else 0
            if (idx, target) in self.memo:
                return self.memo[(idx, target)]
            res = dfs(nums, idx + 1, target - nums[idx]) + dfs(nums, idx + 1, target + nums[idx])
            self.memo[(idx, target)] = res
            return res
        return dfs(nums, 0, S)

    
class UnitTest(unittest.TestCase):
    def test(self):
        nums = [1, 1, 1, 1, 1]
        S = 3
        self.assertEqual(5, Solution().findTargetSumWays(nums, S))
if __name__ == "__main__":
    unittest.main()