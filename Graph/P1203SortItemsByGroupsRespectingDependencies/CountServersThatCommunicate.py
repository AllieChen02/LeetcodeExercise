import unittest
from typing import List
from collections import deque
import collections
class Solution:
    # reference: https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/discuss/402401/Python-Use-topologically-sorted-items-and-groups-to-get-the-desired-order.
    '''
    Main idea:
    1. 根据before items 对所有item进行一个topological sort
    2. 根据group里面存储的item， 对group进行一个topological sort
    3. 对于得到item sort以后， 我们要对每个group里面的item进行排序
    '''
    
    def sortItems(self, n: int, m: int, group: List[int], beforeItems: List[List[int]]) -> List[int]:
                    
        # Create a new group for each item that belongs to no group. 
        for u in range(len(group)):
            if group[u] == -1:
                group[u] = m
                m += 1
                
        # do topology sort twice, one via group and the other one buy before items
        graph_before = [[] for _ in range(n)]
        indegree_before = [0] * n
        graph_group = [[] for _ in range(m)]
        indegree_group = [0] * m 
        
        for i in range(n):
            for item in beforeItems[i]:
                graph_before[item].append(i)
                indegree_before[i] += 1
                # if they do not belong to the same group, 
                if group[i] != group[item]:
                    graph_group[group[item]].append(group[i])
                    indegree_group[group[i]] += 1
                    
        def topologicalOrder(graph, indegree):
            res, queue = [], deque()
            # queue.append(node for node in graph if indegree[node] == 0)
            for node in range(len(graph)):
                if indegree[node] == 0:
                    queue.append(node)
            
            while queue:
                size = len(queue)
                for i in range(size):
                    temp = queue.popleft()
                    res.append(temp)
                    for next in graph[temp]:
                        indegree[next] -= 1
                        if indegree[next] == 0:
                            queue.append(next)
            return res if len(res) == len(graph) else []
        
                        
        item_order = topologicalOrder(graph_before, indegree_before)
        group_order = topologicalOrder(graph_group, indegree_group)
        if not item_order or not group_order: 
            return []
        
        # find order of items within each group
        order_within_group = collections.defaultdict(list)
        for v in item_order:
            order_within_group[group[v]].append(v)
        
        # STEP 5. Combine ordered groups.
        res = []
        for group in group_order:
            res += order_within_group[group]
        return res
        
                        
        
    
class UnitTest(unittest.TestCase):
    def test(self):
        n = 8
        m = 2
        group = [-1,-1,1,0,0,1,0,-1]
        beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
        self.assertEqual([6,3,4,5,2,0,7,1] , Solution().sortItems(n , m, group, beforeItems))
        
        
if __name__ == "__main__":
    unittest.main() 