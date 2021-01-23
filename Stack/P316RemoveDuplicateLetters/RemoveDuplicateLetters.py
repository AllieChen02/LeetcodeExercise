import unittest


class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        if not s or len(s) == 0:
            return ""
        count = {}
        # count the number of occurences of character 
        for c in s:
            temp = ord(c) - ord('a')
            if temp in count:
                count[temp] += 1
            else:
                count[temp] = 1
        visited = set()
        stack = []
        
        for c in s:
            count[ord(c) - ord('a')] -= 1
            if c in visited:
                continue
            
            while stack and stack[-1] > c and count[ord(stack[-1]) - ord('a')] != 0:
                visited.remove(stack.pop())
            stack.append(c)
            visited.add(c)
        
        return ''.join(stack)

class UnitTest(unittest.TestCase):
    def test_1(self):
        s = "cbacdcbc"
        self.assertEquals("acdb", Solution().removeDuplicateLetters(s))
if __name__ == "__main__":
    unittest.main()
        
                
            