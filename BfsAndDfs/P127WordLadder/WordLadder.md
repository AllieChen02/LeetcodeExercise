# 127. Word Ladder
- Data structure: Queue
- Start from the first index of beginWord, For each word popped by queue, check whether it is the endWord. 
  If yes, return level directly. Otherwise, continue to try 26 possible character in all places and 
  store the candidate, which is in the wordList into queue
- Using a level to record. For a loop, the words in the queue are all poped, then increases the level by 1
- To prune some cases, we convey list into set and if the word is visited, just remove it from the set. 