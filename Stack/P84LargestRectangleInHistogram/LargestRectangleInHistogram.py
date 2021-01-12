import unittest
from typing import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # 避开了对edge case
        heights.append(0)
        stack, res, size = [-1], 0, len(heights)
        for i in range(size):
            # 后一个index小于前一个index时
            while heights[i] < heights[stack[-1]]:
                height = heights[stack.pop()]
                width = i - stack[-1] - 1
                res = max(res, height * width)
            stack.append(i)
        # heights.pop()
        return res

class UnitTest(unittest.TestCase):
    def test(self):
        heights = [2,1,5,6,2,3]
        self.assertEqual(10, Solution().largestRectangleArea(heights))
if __name__ == "__main__":
    unittest.main()
        
        