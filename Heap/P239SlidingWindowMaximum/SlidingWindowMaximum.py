import unittest
from typing import List
from collections import deque
'''
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
'''
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if not nums or len(nums) == 0:
            return []
        q = deque([])
        res = []
        for i in range(0, len(nums)):
            '''
            当 当前值大于deque的最后一个值时， 我们就pop queue中的末端元素。 保证queue中头部元素为当前sliding window的最大值
            '''
            while len(q) > 0 and nums[q[-1]] <= nums[i]:
                q.pop()
            q.append(i)
            # 当queue中有k个元素时
            if q[0] == i - k:
                q.popleft()
            if i >= k - 1:
                res.append(nums[q[0]])
        return res


class UnitTest(unittest.TestCase):
    def test(self):
        nums = [1,3,-1,-3,5,3,6,7]
        k = 3
        self.assertEqual([3,3,5,5,6,7], Solution().maxSlidingWindow(nums, k))
if __name__ == "__main__":
    unittest.main()
