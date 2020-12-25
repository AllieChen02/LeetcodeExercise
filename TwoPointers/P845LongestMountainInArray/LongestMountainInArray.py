import unittest
from typing import List
'''
You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.

Example 1:

Input: arr = [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: arr = [2,2,2]
Output: 0
Explanation: There is no mountain.
'''
class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        # time complexity: O(N^2), time limit exception
        # res = 0
        # if not arr:
        #     return res
        # for i in range(1,len(arr)-1):
        #     # start from arr[i]
        #     left, right = i, i
        #     while left > 0 and arr[left - 1] < arr[left]:
        #         left -= 1
        #     while right < len(arr) - 1 and arr[right+1] < arr[right]:
        #         right += 1
        #     if right - left + 1 >= 3 and left != i and right != i:
        #         res = max(res, right - left + 1)
        # return res
        
        res = 0
        if not arr or len(arr) < 3:
            return res
        
        # create two arrays, one is for descending, one for ascending
        asc, des = [0] * len(arr), [0] * len(arr)
        for i in range(1, len(arr)):
            if arr[i] > arr[i-1]:
                asc[i] = asc[i-1] + 1
        for i in range(len(arr)-2, -1, -1):
            if arr[i] > arr[i+1]:
                des[i] = des[i+1] + 1
        for a, d in zip(asc, des):
            temp = a + d + 1
            if temp >= 3 and temp > res and a != 0 and d != 0:
                res = temp
        return res   