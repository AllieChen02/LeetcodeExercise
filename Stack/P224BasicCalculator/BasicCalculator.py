import unittest

class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        s = list(s)
        res, sign, num = 0, 1, 0
        for idx, val in enumerate(s):
            if val.isdigit():
                num = 10*num + int(val)
            elif val == '+':
                res += num * sign
                sign = 1
                num = 0
            elif val == '-':
                res += num * sign
                sign = -1
                num = 0
            elif val == '(':
                # store the previous result of expression into stack
                stack.append(res)
                stack.append(sign)
                sign = 1
                # a new expression, at this time, res resets to zero
                res = 0
                num = 0
            elif val == ')':
                res += num * sign   # 计算括号内的expression, 
                res *= stack.pop()  # sign
                res += stack.pop()  # num
                sign = 1
                num = 0
        res += sign * num
        return res

class UnitTest(unittest.TestCase):
    def test_1(self):
        s = "(1+(4+5+2)-3)+(6+8)"
        self.assertEqual(23, Solution().calculate(s))

if __name__ == "__main__":
    unittest.main()
