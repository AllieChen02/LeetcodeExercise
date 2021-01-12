import unittest

class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        s = list(s)
        stack = []
        for idx, c in enumerate(s):
            if c == '(':
                stack.append(idx)
            elif c == ')':
                if len(stack) == 0:
                    # it indicates this ')' is invalid, we just remove it
                    s[idx] = ''
                else:
                    stack.pop()
        
        while len(stack):
            i = stack.pop()
            s[i] = ''
        # transfer list to string, using '' to connect
        return ''.join(s)


class UnitTest(unittest.TestCase):
    def test(self):
        s = "lee(t(c)o)de)"
        self.assertEqual("lee(t(c)o)de", Solution().minRemoveToMakeValid(s))

        s = "a)b(c)d"
        self.assertEqual("ab(c)d", Solution().minRemoveToMakeValid(s))
        
if __name__ == "__main__":
    unittest.main()