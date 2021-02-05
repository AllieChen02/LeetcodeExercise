import unittest

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        res = 0
        if len(s) == 0:
            return res
        # make use of stack while scanning the given string to check if the string scanned so far is valid
        stack, left = [], -1
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            elif s[i] == ')':
                if len(stack) == 0:
                    # update the valid start 
                    left = i + 1
                else:
                    stack.pop()
                    if len(stack) == 0:
                        res = max(res, i - left + 1)
                    else:
                        res = max(res, i - stack[-1])
        return res
                
class UnitTest(unittest.TestCase):
    def test_1(self):
        s = ")()())"
        self.assertEqual(4, Solution().longestValidParentheses(s))
        

if __name__ == "__main__":
    unittest.main()