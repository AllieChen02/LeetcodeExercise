import unittest

'''
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
'''
class Solution:
    def calculate(self, s: str) -> int:
        s = list(s)
        stack = []
        res, num, sign = 0, 0, '+'
        for idx, val in enumerate(s):
            if val.isdigit():
                num = num * 10 + int(val)
            if not val.isdigit() and val != ' ' or idx == len(s) - 1:
                if sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                elif sign == '/':
                    stack.append(int(stack.pop() / num))
                elif sign == '*':
                    stack.append(stack.pop() * num)
                sign = val
                num = 0
        while stack:
            res += stack.pop()    
        return res

class UnitTest(unittest.TestCase):
    def test_1(self):
        s = "3+2*2"
        self.assertEqual(7, Solution().calculate(s))
        
        s = " 3+5 / 2 "
        self.assertEqual(5, Solution().calculate(s))
if __name__ == "__main__":
    unittest.main()