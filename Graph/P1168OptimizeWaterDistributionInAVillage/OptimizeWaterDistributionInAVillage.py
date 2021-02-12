import unittest
from typing import List
import heapq
import collections
class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        '''
        首先利用最小生成树，找到一条最短的路径连接所有的点，（或者直接在当前处建立well）， 且选择其中建wells cost最小的作为起始点。
        '''
        graph = collections.defaultdict(list)
        for u, v, c in pipes:
            graph[u].append((c, v))
            graph[v].append((c, u))
        for i in range(n):
            graph[0].append((wells[i], i+1))
        visited = set()
        res, hq = 0, []
        node = 0
        heapq.heappush(hq, (0, 0)) # cost and start point
        while hq:
            cost, curr =  heapq.heappop(hq)
            if curr in visited:
                continue
            visited.add(curr)
            res += cost
            for next in graph[curr]:
                heapq.heappush(hq, next)
        return res
    
class UnitTest(unittest.TestCase):
    def test(self):
        n = 3
        wells = [1,2,2]
        pipes = [[1,2,1],[2,3,1]]
        self.assertEqual(3, Solution().minCostToSupplyWater(n , wells, pipes))
        
        n = 5
        wells = [46012,72474,64965,751,33304]
        pipes = [[2,1,6719],[3,2,75312],[5,3,44918]]
        self.assertEqual(131704, Solution().minCostToSupplyWater(n , wells, pipes))
        
if __name__ == "__main__":
    unittest.main()        
        