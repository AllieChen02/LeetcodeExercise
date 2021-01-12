import unittest
from typing import List

'''
build on top of leetcode 84
cite from https://leetcode.com/problems/maximal-rectangle/discuss/122456/Easiest-solution-build-on-top-of-leetcode84
'''
class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if(len(matrix) == 0 or len(matrix[0]) == 0):
            return 0
        heights = [0] * len(matrix[0])
        maxArea = -1
        def largestRectangleArea(heights):
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
    
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == '0':
                    heights[j] = 0
                else:
                    heights[j] += 1
            area = largestRectangleArea(heights)
            maxArea = max(maxArea, area)
        return maxArea
    
                    