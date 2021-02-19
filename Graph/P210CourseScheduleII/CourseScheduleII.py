import unittest
from typing import List
from collections import deque

# using topological sort to check if there ia a circle in the graph
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        indegree = [0] * numCourses
        graph, visited, count = {}, set(), 0
        res = []    
        for i in range(numCourses):
            graph[i] = []
        for pre in prerequisites:
            graph[pre[1]].append(pre[0])
            indegree[pre[0]] += 1
        
        queue = deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
        while queue:
            curr = queue.popleft()
            if curr in visited:
                continue
            visited.add(curr)
            res.append(curr)
            count += 1
            for next in graph[curr]:
                indegree[next] -= 1
                if indegree[next] == 0:
                    queue.append(next)
        return res if numCourses == count else []
              
        

class UnitTest(unittest.TestCase):
    def test(self):
        numCourses = 2
        prerequisites = [[1,0]]
        self.assertEqual([0,1], Solution().findOrder(numCourses, prerequisites))
        
        numCourses = 4
        prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        self.assertEqual([0,1,2,3], Solution().findOrder(numCourses, prerequisites))
        
        numCourses = 1
        prerequisites = []
        self.assertEqual([0], Solution().findOrder(numCourses, prerequisites))
if __name__ == "__main__":
    unittest.main()