import unittest
from typing import List
class Solution:
    def __init__(self, nums: List[int]):
        self.array = nums

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        res = 0
        for num1, num2 in zip(self.array, vec.array):
            res += num1 * num2
        return res
class UnitTest(unittest.TestCase):
    def test_1(self):
        nums1 = [1,0,0,2,3]
        nums2 = [0,3,0,4,0]
        self.assertEqual(8, Solution(nums1).dotProduct(Solution(nums2)))
        
if __name__ == "__main__":
    unittest.main()