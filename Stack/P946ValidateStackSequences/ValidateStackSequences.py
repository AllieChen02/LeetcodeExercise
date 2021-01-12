import unittest
from typing import List

# Time complexity: O(N)
class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        if len(pushed) != len(popped):
            return 0
        stack, i = [], 0
        for val in pushed:
            stack.append(val)
            while stack and stack[-1] == popped[i]:
                stack.pop()
                i += 1
        return len(stack) == 0

class UnitTest(unittest.TestCase):
    def test_1(self):
        pushed = [1,2,3,4,5]
        popped = [4,5,3,2,1]
        self.assertEqual(True, Solution().validateStackSequences(pushed, popped))
        
if __name__ == "__main__":
    unittest.main()


        