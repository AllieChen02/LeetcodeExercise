import unittest
from typing import List

class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        res = 0
        if not grid:
            return res
        m, n = len(grid), len(grid[0])
        row, col = [0] * m, [0] * n
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    row[i] += 1
                    col[j] += 1
                    res += 1
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    if row[i] == 1 and col[j] == 1:
                        res -= 1
        return res            
        

class UnitTest(unittest.TestCase):
    def test(self):
        grid = [[1,0],[0,1]]
        self.assertEqual(0, Solution().countServers(grid))
        
        grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
        self.assertEqual(4, Solution().countServers(grid))
        
if __name__ == "__main__":
    unittest.main()