import unittest
from typing import List
import collections
from collections import deque
'''
In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

Example 1:

Input: A = [[0,1],[1,0]]
Output: 1
Example 2:

Input: A = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1

'''
class Solution:
    def shortestBridge(self, A: List[List[int]]) -> int:
        '''
        Since there are only two islands, we can firstly use dfs to find one, and push these points into queue
        , and then use bfs to find the remaining one
        '''
        m, n = len(A), len(A[0])
        queue, visited, marked = deque(), set(), False
        
        def dfs(A, i, j, q, visited):
            if(i<0 or j < 0 or i>=len(A) or j >= len(A[0]) or (i,j) in visited or A[i][j] == 0):
                return
            visited.add((i,j))
            q.append((i,j))
            dfs(A, i+1, j, q, visited)
            dfs(A, i, j+1, q, visited)
            dfs(A, i-1, j, q, visited)
            dfs(A, i, j-1, q, visited)
        
        
        for i in range(m):
            if marked:
                break
            for j in range(n):
                if A[i][j] == 1:
                    dfs(A, i,j , queue, visited)
                    marked = True
                    break
        res = 0
        # use bfs
        while queue:
            length = len(queue)
            for k in range(length):
                x, y = queue.popleft()
                if (x,y) not in visited and A[x][y] == 1:
                    return res-1
    
                for dir in [[-1,0], [1,0], [0,1], [0,-1]]:
                    i = dir[0] + x
                    j = dir[1] + y
                    if i >= 0 and j >=0  and i < m and j < n and (i,j) not in visited:
                        if A[i][j] == 1:
                            return res 
                        queue.append((i,j))
                        visited.add((i,j))
            res += 1
        return res-1
    
class UnitTest(unittest.TestCase):
    def test(self):
        A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
        self.assertEqual(1, Solution().shortestBridge(A))
        
        A = [[0,1,0],[0,0,0],[0,0,1]]
        self.assertEqual(2, Solution().shortestBridge(A))
        
        A = [[0,1],[1,0]]
        self.assertEqual(1, Solution().shortestBridge(A))
if __name__ == "__main__":
    unittest.main()