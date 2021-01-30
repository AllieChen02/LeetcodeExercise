import unittest
from typing import List
import collections
import heapq

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = collections.defaultdict(dict)
        for start, dest, cost in times:
            graph[start][dest] = cost
        h = [(0, k)]
        visited = {}
        while h:
            cost, node = heapq.heappop(h)
            if node not in visited:
                visited[node] = cost
                for neigh in graph[node]:
                   heapq.heappush(h, (visited[node] + graph[node][neigh], neigh))
        return max(visited.values()) if len(visited) == n else -1
    
class UnitTest(unittest.TestCase):
    def test(self):
        times = [[2,1,1],[2,3,1],[3,4,1]]
        n = 4
        k = 2
        self.assertEqual(2, Solution().networkDelayTime(times, n , k))
if __name__ == "__main__":
    unittest.main()