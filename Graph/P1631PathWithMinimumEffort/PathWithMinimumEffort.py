import unittest
from typing import List
import sys
import heapq
class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m = len(heights)
        n = len(heights[0])
        cost = [[sys.maxsize] * n for _ in range(m)]
        hq = [(0, 0, 0)]
        while hq:
            diff, x, y = heapq.heappop(hq)
            if x == m-1 and y == n-1:
                return diff
            for dir in [[1,0],[-1,0],[0,1],[0,-1]]:
                i = dir[0] + x
                j = dir[1] + y
                if i >= 0 and i < m and j >=0 and j < n:
                    temp = max(abs(heights[i][j] - heights[x][y]), diff)
                    if cost[i][j] > temp:
                        cost[i][j] = temp
                        heapq.heappush(hq, (temp, i, j))
        return 0   

class UnitTest(unittest.TestCase):
    def test(self):
        heights = [[1,2,2],[3,8,2],[5,3,5]]
        self.assertEqual(2, Solution().minimumEffortPath(heights))


if __name__ == "__main__":
    unittest.main()