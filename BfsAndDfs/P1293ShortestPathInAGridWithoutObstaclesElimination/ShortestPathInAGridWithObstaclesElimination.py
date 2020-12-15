import unittest
from collections import deque
from typing import List

class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        res = 0
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]
        q = deque([])
        visited = set()
        q.append([0,0,0])
        while q:
            size = len(q)
            for _ in range(size):
                r, c, tempk = q.popleft()
                if r == m - 1 and c == n - 1:
                    return res
                else:
                    for x, y in dirs:
                        newr = x + r
                        newc = y + c
                        newk = tempk
                        if newr >= 0 and newr < m and newc >=0 and newc < n:
                            if grid[newr][newc] == 1:
                                newk = newk + 1
                            if newk <= k and (newr, newc, newk) not in visited:
                                visited.add((newr, newc, newk))
                                q.append((newr, newc, newk))
            res+=1                
        return -1


class UnitTest(unittest.TestCase):
    def test_1(self):
        grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]]
        k = 1
        self.assertEqual(Solution().shortestPath(grid, k), 6)
    
if __name__ == "__main__":
    unittest.main()
