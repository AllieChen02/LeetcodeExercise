import unittest
from collections import deque
from typing import List
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        q = deque([])
        s = set(wordList)
        q.append(beginWord)
        level = 0
        while(q):
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                if curr == endWord:
                    return level + 1
                for i in range(0, len(curr)):
                    for j in 'abcdefghijklmnopqrstuvwxyz':
                        tmp = curr[:i] + j + curr[i+1:]
                        if tmp in s:
                            q.append(tmp)
                            s.remove(tmp)
            level = level + 1
        return 0
class UnitTest(unittest.TestCase):
    def test_1(self):
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log","cog"]
        self.assertEqual(Solution().ladderLength(beginWord, endWord, wordList), 5)
        
        wordList = ["hot","dot","dog","lot","log"]
        self.assertEqual(Solution().ladderLength(beginWord, endWord, wordList), 0)

if __name__ == "__main__":
    unittest.main()