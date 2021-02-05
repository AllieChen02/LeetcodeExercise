import unittest
from typing import List

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c == '(' or c == '[' or c == '{':
                stack.append(c)
            elif c == ']':
                if len(stack) == 0 or stack.pop() != '[':
                    return False
            elif c == ')':
                if len(stack) == 0 or stack.pop() != '(':
                    return False
            elif c == '}':
                if len(stack) == 0 or stack.pop() != '{':
                    return False 
        return len(stack) == 0   

class UnitTest(unittest.TestCase):
    def test(self):
        s = "()[]{}"
        self.assertEqual(True, Solution().isValid(s))
        s = "(]"
        self.assertEqual(False, Solution().isValid(s))
        
if __name__ == "__main__":
    unittest.main()