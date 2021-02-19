import unittest
from typing import List
from collections import deque

class Solution:
    def numberOfDays(self, Y: int, M: int) -> int:
        def is_leap_year(y):
            if y%4 == 0 and y % 100 != 0:
                return True
            elif y%4 == 0 and y % 400 == 0:
                return True
            return False
            
        big_month = [1, 3, 5, 7, 8, 10, 12]
        if M <= 0 or M > 12:
            return 0
        if M in big_month:
            return 31
        elif M == 2:
            return 29 if is_leap_year(Y) else 28
        else:
            return 30
        
              
        

class UnitTest(unittest.TestCase):
    def test(self):
        Y = 1992
        M = 7
        self.assertEqual(31, Solution().numberOfDays(Y,M))
        
        Y = 2000
        M = 2
        self.assertEqual(29, Solution().numberOfDays(Y,M))
if __name__ == "__main__":
    unittest.main()