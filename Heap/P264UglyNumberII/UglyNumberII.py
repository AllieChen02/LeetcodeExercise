import unittest


class Solution:
    # time limit exceeded
    def nthUglyNumber(self, n: int) -> int:
        count, curr = 0, 0
        while count != n:
            curr += 1
            if self.isUgly(curr):
                count += 1   
        return curr
    
    def isUgly(self, curr):
        if curr == 0:
            return False
        while curr != 1:
            if curr % 2 == 0:
                curr /= 2
            elif curr % 3 == 0:
                curr /= 3
            elif curr % 5 == 0:
                curr /= 5
            else: 
                return False
        return True
    
    # better solution, time complexity is O(N)
    
    def nthUglyNumber_1(self, n: int) -> int:
        ugly = [1]
        i2, i3, i5 = 0, 0, 0
        while n > 1:
            u2, u3, u5 = 2 * ugly[i2], 3 * ugly[i3], 5 * ugly[i5]
            umin = min(u2, u3, u5)
            # Each element can only be multiplied by 2, 3, and 5 for one times(in fact the total times is 3), 
            # so after multiplied by 2, you should do i2 += 1......
            if umin == u2:
                i2 += 1
            if umin == u3:
                i3 += 1
            if umin == u5:
                i5 += 1
            ugly.append(umin)
            n -=1 
        return ugly[-1]
    


class UnitTest(unittest.TestCase):
    def test(self):
        n = 10
        self.assertEqual(12, Solution().nthUglyNumber(n))
        self.assertEqual(12, Solution().nthUglyNumber_1(n))
if __name__ == "__main__":
    unittest.main()