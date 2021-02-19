import unittest
from typing import List
from collections import deque

# using topological sort to check if there ia a circle in the graph
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0] * numCourses
        graph, visited, count = {}, set(), 0
        for i in range(numCourses):
            graph[i] = []
        for req in prerequisites:
            graph[req[1]].append(req[0])
            indegree[req[0]] += 1
        queue = deque()
        
        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(i)

        while queue:
            curr = queue.popleft()
            if curr in visited:
                continue
            visited.add(curr)
            count += 1
            for next in graph[curr]:
                indegree[next] -= 1
                if indegree[next] == 0:
                    queue.append(next)
        return count == numCourses    
        

class UnitTest(unittest.TestCase):
    def test(self):
        numCourses = 2
        prerequisites = [[1,0]]
        self.assertTrue(Solution().canFinish(numCourses, prerequisites))
        
        numCourses = 2
        prerequisites = [[1,0], [0,1]]
        self.assertFalse(Solution().canFinish(numCourses, prerequisites))
        
if __name__ == "__main__":
    unittest.main()