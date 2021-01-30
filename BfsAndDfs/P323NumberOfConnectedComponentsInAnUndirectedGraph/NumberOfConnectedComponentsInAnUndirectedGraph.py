import unittest
from typing import List
import collections
class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        graph = collections.defaultdict(list)
        res, visited = 0, set()
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        def dfs(graph, visited, i):
            for nei in graph[i]:
                if nei not in visited:
                    visited.add(nei)
                    dfs(graph, visited, nei)
        
        for i in range(0, n):
            if i not in visited:
                visited.add(i)
                dfs(graph, visited, i)
                res += 1
        return res
        
        

class UnitTest(unittest.TestCase):
    def test(self):
        n = 5
        edges = [[0, 1], [1, 2], [3, 4]]
        self.assertEqual(2, Solution().countComponents(n, edges))

if __name__ == "__main__":
    unittest.main()