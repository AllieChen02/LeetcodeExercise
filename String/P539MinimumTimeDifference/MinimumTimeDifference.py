import unittest
from typing import List
import sys

class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        points, prev = [0] * 1440, 0
        minVal, maxVal = sys.maxsize, -sys.maxsize - 1  
        res = sys.maxsize
        for time in timePoints:
            arr = time.split(":")
            temp = int(arr[0]) * 60 + int(arr[1])
            # we have exactly two same time points
            if points[temp] != 0:
                return 0
            points[temp] = 1
            minVal = min(minVal, temp)
            maxVal = max(maxVal, temp)
        for i in range(minVal, maxVal + 1):
            if points[i] != 0:
                res = min(res, min(maxVal - minVal, 1440 - maxVal + minVal)) if i == minVal else min(res, i - prev)
                prev = i
        return res 
class UnitTest(unittest.TestCase):
    def test(self):
        # timePoints = ["00:00","23:59","00:00"]
        # self.assertEqual(0, Solution().findMinDifference(timePoints))
        
        timePoints = ["23:59","00:00"]
        self.assertEqual(1, Solution().findMinDifference(timePoints))
if __name__ == "__main__":
    unittest.main()   
            