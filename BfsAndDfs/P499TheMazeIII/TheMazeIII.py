import unittest
from typing import List
import collections
import heapq

class Node:
    def __init__(self,cost,x,y,s):
        self.cost = cost
        self.x = x
        self.y = y
        self.s = s
    def __lt__(self, other):
        if self.cost != other.cost:
            return True if self.cost < other.cost else False
        else:
            return True if self.s  <other.s else False
        
class Solution:
    def findShortestWay(self, maze: List[List[int]], ball: List[int], hole: List[int]) -> str:  
        h = [] # step, row, col
        h.append(Node(0, ball[0], ball[1], ""))
        m, n = len(maze), len(maze[0])
        visited = set()
        while h:
            curr = heapq.heappop(h)
            if curr.x == hole[0] and curr.y == hole[1]:
                return curr.s
            if (curr.x, curr.y) in visited:
                continue
            visited.add((curr.x, curr.y))
            for row, col, p in ((1, 0, "d"), (0, -1, "l"), (0, 1, "r"),(-1, 0, "u")):
                newx = curr.x
                newy = curr.y
                newcost = curr.cost
                news = curr.s
                while newx + row >= 0 and newx + row < m and newy + col >=0 and newy+col < n and maze[newx+row][newy+col] == 0:
                    newx += row
                    newy += col
                    newcost += 1
                    if newx == hole[0] and newy == hole[1]:
                        break
                if (newx, newy) not in visited:
                    heapq.heappush(h, Node(newcost, newx, newy, news + p))
        return "impossible"
        
    
class UnitTest(unittest.TestCase):
    def test(self):
        maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]
        ball = [4,3]
        hole = [0,1]
        self.assertEqual("lul", Solution().findShortestWay(maze, ball, hole))
        
        maze = [[0,0,0,0,0,0,0],[0,0,1,0,0,1,0],[0,0,0,0,1,0,0],[0,0,0,0,0,0,1]]
        ball = [0,4]
        hole = [3,5]
        self.assertEqual("dldr", Solution().findShortestWay(maze, ball, hole))
if __name__ == "__main__":
    unittest.main()