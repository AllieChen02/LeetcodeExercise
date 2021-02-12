import unittest
import heapq
from typing import List

class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        # build graph
        graph = {}  # {s: [(t1, cost), (t2, cost)]}
        for i in range(n):
            graph[i] = []
        for i in range(len(edges)):
            graph[edges[i][0]].append((edges[i][1], -succProb[i]))
            graph[edges[i][1]].append((edges[i][0], -succProb[i]))
        visited = [False] * n
        hq = [(1, start)]
        while hq:
            prob, curr = heapq.heappop(hq)
            if curr == end:
                return -prob
            if visited[curr]:
                continue
            visited[curr] = True
            for next in graph[curr]:
                temp = next[1] * prob
                if next[1] * prob > 0:
                    temp = -temp
                heapq.heappush(hq, (temp, next[0]))
        return 0

class UnitTest(unittest.TestCase):
    def test(self):
        n = 3
        edges = [[0,1],[1,2],[0,2]]
        succProb = [0.5,0.5,0.2]
        start = 0
        end = 2
        self.assertEqual(0.25000, Solution().maxProbability(n, edges, succProb, start, end))

        
        n = 3
        edges = [[0,1],[1,2],[0,2]]
        succProb = [0.5,0.5,0.3]
        start = 0
        end = 2
        self.assertEqual(0.30000, Solution().maxProbability(n, edges, succProb, start, end))

if __name__ == "__main__":
    unittest.main()

            
        