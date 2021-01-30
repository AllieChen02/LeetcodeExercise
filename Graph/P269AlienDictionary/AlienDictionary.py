import unittest
from typing import List
import collections
from collections import deque


class Solution:
    def alienOrder(self, words: List[str]) -> str:
        if not words:
            return ""
        graph = collections.defaultdict(list)
        inDegree = collections.defaultdict(dict)
        for word in words:
            for c in word:
                graph[c] = []
                inDegree[c] = 0

        # build graph
        for i in range(1, len(words)):
            prev = words[i - 1]
            next = words[i]
            if len(prev) > len(next) and prev.startswith(next):
                return ""
            length = min(len(prev), len(next))
            for j in range(length):
                if prev[j] != next[j]:
                    graph[prev[j]].append(next[j])
                    inDegree[next[j]] += 1
                    break

        q = deque([])
        for key in graph:
            if inDegree[key] == 0:
                q.append(key)
        res = []
        while q:
            curr = q.popleft()
            res.append(curr)
            for child in graph[curr]:
                inDegree[child] -= 1
                if inDegree[child] == 0:
                    q.append(child)
        return ''.join(res) if len(res) == len(graph) else ''


class UnitTest(unittest.TestCase):
    def test(self):
        words = ["wrt", "wrf", "er", "ett", "rftt"]
        self.assertEqual("wertf", Solution().alienOrder(words))
        
        words = ["abc", "ab"]
        self.assertEqual("", Solution().alienOrder(words))


if __name__ == "__main__":
    unittest.main()
