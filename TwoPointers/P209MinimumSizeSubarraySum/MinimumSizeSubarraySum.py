import unittest
from collections import deque
from typing import List

class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        length = len(nums)
        res = length + 1
        start, end, curSum = 0,0,0
        while end < length:
            curSum += nums[end]
            while curSum >= s:
                res = min(res, end - start + 1)
                curSum -= nums[start]
                start +=1
            end += 1
        res = 0 if res == length + 1 else res
        return res

class UnitTest(unittest.TestCase):
    def test_1(self):
        s = 7
        nums = [2,3,1,2,4,3]
        self.assertEqual(2, Solution().minSubArrayLen(s, nums))

if __name__ == "__main__":
    unittest.main()