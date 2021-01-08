import unittest
from collections import defaultdict, deque
from typing import List

class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        # BFS
        graph = defaultdict(list)
        visited, queue,res = set([0]),deque([0]), 0
        queue = deque([0])
        for s, t in connections:
            # from start to target, we record its cost is 1 because we begin our BFS from "0". So any place 0 could reach will be reversed
            graph[s].append((t, 1))
            graph[t].append((s, 0))
        while queue:
            temp = queue.popleft()
            for neigh, cost in graph[temp]:
                if neigh not in visited:
                    res += cost
                    visited.add(neigh)
                    queue.append(neigh)
        return res     

class UnitTest(unittest.TestCase):
    def test(self):
        n = 6
        connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
        self.assertEqual(3, Solution().minReorder(n, connections))
        
        n = 5
        connections = [[1,0],[1,2],[3,2],[3,4]]
        self.assertEqual(2, Solution().minReorder(n, connections))
if __name__ == "__main__":
    unittest.main()       
        
            