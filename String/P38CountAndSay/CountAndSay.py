import unittest
'''
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
'''
class Solution:
    def countAndSay(self, n: int) -> str:
        res = '1'
        if n == 1:
            return res
        for _ in range(n-1):
            curr, temp, count = res[0], '', 0
            for l in res:
                if curr == l:
                    count += 1
                else:
                    temp += str(count) + curr
                    curr = l
                    count = 1
            # 把最后一个字符串加进来
            temp += str(count)+curr
            res = temp
        return res 

class UnitTest(unittest.TestCase):
    def test(self):
        n = 4
        self.assertEquals('1211', Solution().countAndSay(n))
if __name__ == "__main__":
    unittest.main()

            