import unittest
from typing import List
import collections
import heapq

        
class Solution:
    def findShortestWay(self, maze: List[List[int]], start: List[int], destination: List[int]) -> str:  
        h = [] # step, row, col
        h.append((0, start[0], start[1]))
        m, n = len(maze), len(maze[0])
        visited = set()
        while h:
            cost, i, j = heapq.heappop(h)
            if [i,j] == destination:
                return cost
            
            visited.add((i,j))
            for row, col in [[-1,0], [1,0], [0,1], [0,-1]]:
                x = i
                y = j
                newcost = cost
                while (x + row >= 0 and x + row < m and y + col >= 0 and y + col < n and maze[x + row][y + col] == 0):
                    x += row
                    y += col
                    newcost += 1
                if (x,y) not in visited:
                    heapq.heappush(h, (newcost, x, y))
        return -1
        
    
class UnitTest(unittest.TestCase):
    def test(self):
        maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
        ball = [0,4]
        hole = [4,4]
        self.assertEqual(12, Solution().findShortestWay(maze, ball, hole))
if __name__ == "__main__":
    unittest.main()