import unittest
from typing import List

class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        res, left, right, prod = 0, 0, 0, 1
        while right < len(nums):
            prod *= nums[right]
            while prod >= k:
                # move left pointer
                prod /= nums[left]
                left += 1
            # the number of intervals with subarray product less than k should be right - left + 1
            # e.g [5,9,3,7,8], 9 is the left pointer, 7 is the right pointer, then res += 3, which is due to [9,3,7], [3,7] [7]
            res += right - left + 1
            right += 1
        return res
        

class UnitTest(unittest.TestCase):
    def test_1(self):
        nums = [10, 5, 2, 6]
        k = 100
        self.assertEqual(8, Solution().numSubarrayProductLessThanK(nums,k))
        
if __name__ == "__main__":
    unittest.main()